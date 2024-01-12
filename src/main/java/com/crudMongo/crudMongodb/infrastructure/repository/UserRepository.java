package com.crudMongo.crudMongodb.infrastructure.repository;

import com.crudMongo.crudMongodb.infrastructure.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends MongoRepository<UserEntity,String> {
}
