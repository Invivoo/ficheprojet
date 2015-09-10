package com.invivoo.ficheprojet.app.repository;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;

import com.invivoo.ficheprojet.app.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByLogin(String login);

    User findOneByEmail(String email);

    User findOneByActivationKey(String activationKey);

    List<User> findAllByActivatedIsFalseAndCreatedDateBefore(DateTime dateTime);

    User findOneByResetKey(String resetKey);
}
