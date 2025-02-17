package dclvs.rso_app.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(title = "Container for user's data", description = "Пользовательские данные")
public class UserReceiver {

    private Long userId;

    private String email;

    private String password;

    private String firstName;

    private String surName;

    private String patronymicName;

    private String birthday;

    private String faculty;

    private String speciality;

    private Integer course;

    private String group;

}
