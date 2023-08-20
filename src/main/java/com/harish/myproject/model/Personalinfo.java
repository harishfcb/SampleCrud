package com.harish.myproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Personalinfo")
public class Personalinfo {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String age;
    private String phoneNumber;

}

