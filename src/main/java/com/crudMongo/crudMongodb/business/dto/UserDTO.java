package com.crudMongo.crudMongodb.business.dto;

import com.crudMongo.crudMongodb.infrastructure.entity.UserEntity;

import java.time.LocalDateTime;

public record UserDTO(String id, String name, String email, String document, LocalDateTime registerDate,
                      LocalDateTime updateDate) {
    public UserDTO(UserEntity userEntity) {
        this(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getDocument(), userEntity.getRegisterDate(), userEntity.getUpdateDate());
    }
}
