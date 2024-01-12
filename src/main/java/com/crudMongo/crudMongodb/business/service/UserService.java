package com.crudMongo.crudMongodb.business.service;

import com.crudMongo.crudMongodb.business.dto.UserDTO;
import com.crudMongo.crudMongodb.infrastructure.entity.UserEntity;
import com.crudMongo.crudMongodb.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository  userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserDTO user) {
        userRepository.save(new UserEntity(user));
    }
    public UserDTO getUserById(String id) {
        return userRepository.findById(id).map(UserDTO::new).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public List<UserDTO> getUsers(){
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    public void updateUser(UserDTO user) {
        UserEntity oldUserEntity = userRepository.findById(user.id()).orElseThrow(() -> new RuntimeException("User not found"));
        oldUserEntity.setName(user.name());
        oldUserEntity.setEmail(user.email());
        oldUserEntity.setDocument(user.document());
        oldUserEntity.setUpdateDate(user.updateDate());
        oldUserEntity.setRegisterDate(user.registerDate());
        userRepository.save(oldUserEntity);
    }
}
