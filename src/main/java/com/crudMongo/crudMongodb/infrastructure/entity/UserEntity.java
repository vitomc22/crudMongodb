package com.crudMongo.crudMongodb.infrastructure.entity;

import com.crudMongo.crudMongodb.business.dto.UserDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String document;
    private LocalDateTime   registerDate;
    private LocalDateTime   updateDate;

    public UserEntity(UserDTO user) {
        this.name = user.name();
        this.email = user.email();
        this.document = user.document();
        this.registerDate = user.registerDate();
        this.updateDate = user.updateDate();
    }
}
