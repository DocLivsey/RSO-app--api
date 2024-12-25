package dclvs.rso_app.entities;

import dclvs.rso_app.entities.components.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserTransceiver {

    private Long userId;

    private Email email;

    private Password password;

    private String firstName;

    private String surName;

    private String patronymicName;

    private Calendar birthday;

    private Faculty faculty;

    private Speciality speciality;

    private Integer course;

    private Group group;

}
