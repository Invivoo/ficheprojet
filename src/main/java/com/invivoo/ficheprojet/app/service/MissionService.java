package com.invivoo.ficheprojet.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invivoo.ficheprojet.app.domain.Mission;
import com.invivoo.ficheprojet.app.domain.User;
import com.invivoo.ficheprojet.app.exceptions.DataNotFoundException;
import com.invivoo.ficheprojet.app.exceptions.UniqueConstraintException;
import com.invivoo.ficheprojet.app.repository.MissionRepository;
import com.invivoo.ficheprojet.app.repository.UserRepository;

@Service
@Transactional
public class MissionService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MissionRepository missionRepository;

    @Transactional(readOnly = true)
    public Set<Mission> listUserMissions(String login) {
	return userRepository.findOneByLogin(login).getMissions();
    }

    public Mission create(String login, Mission mission) {

	checkUniqueConstraint(mission);

	User user = getUserByLogin(login);
	user.getMissions().add(mission);

	userRepository.save(user);

	return mission;
    }

    @Transactional(readOnly = true)
    public Mission read(Long id) {
	return missionRepository.findOne(id);
    }

    public Mission update(Mission mission) {
	checkUniqueConstraint(mission);
	return missionRepository.save(mission);
    }

    public void delete(Long id) {
	Mission mission = missionRepository.findOne(id);
	User user = mission.getUser();
	user.getMissions().remove(mission);
	userRepository.save(user);
    }

    private User getUserByLogin(String login) {

	User user = userRepository.findOneByLogin(login);
	if (user == null)
	    throw new DataNotFoundException();

	return user;
    }

    private void checkUniqueConstraint(Mission mission) {
	Mission existMission = missionRepository.findOneByTitle(mission.getTitle());
	if (existMission != null)
	    throw new UniqueConstraintException();
    }
}
