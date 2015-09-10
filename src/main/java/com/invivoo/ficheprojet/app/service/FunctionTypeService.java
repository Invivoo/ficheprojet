package com.invivoo.ficheprojet.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.invivoo.ficheprojet.app.domain.FunctionType;
import com.invivoo.ficheprojet.app.repository.FunctionTypeRepository;

@Service
@Transactional
public class FunctionTypeService {

    @Autowired
    private FunctionTypeRepository userRepository;

    @Transactional(readOnly = true)
    public List<FunctionType> list() {
	return userRepository.findAll();
    }

    public FunctionType save(FunctionType functionType) {
	return userRepository.save(functionType);
    }

    @Transactional(readOnly = true)
    public FunctionType read(Long id) {
	return userRepository.getOne(id);
    }

    public void delete(Long id) {
	userRepository.delete(id);
    }
}
