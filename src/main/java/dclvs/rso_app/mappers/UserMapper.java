package dclvs.rso_app.mappers;

import dclvs.rso_app.entities.UserReceiver;
import dclvs.rso_app.entities.UserTransceiver;
import dclvs.rso_app.entities.components.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Mapper
public interface UserMapper {

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "email", target = "email", qualifiedByName = "mapEmail"),
            @Mapping(source = "password", target = "password", qualifiedByName = "mapPassword"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "surName", target = "surName"),
            @Mapping(source = "patronymicName", target = "patronymicName"),
            @Mapping(source = "birthday", target = "birthday", qualifiedByName = "mapBirthday"),
            @Mapping(source = "faculty", target = "faculty", qualifiedByName = "mapFaculty"),
            @Mapping(source = "speciality", target = "speciality", qualifiedByName = "mapSpeciality"),
            @Mapping(source = "course", target = "course"),
            @Mapping(source = "group", target = "group", qualifiedByName = "mapGroup")
    })
    UserReceiver toReceiver(UserTransceiver userTransceiver);

    @Named("mapEmail")
    default String map(Email email) {
        return email.getEmail();
    }

    @Named("mapPassword")
    default String map(Password password) {
        return password.getPassword();
    }

    // TODO: check in database how birthday was wrote in table
    @Named("mapBirthday")
    default String map(Calendar birthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(birthday.getTime());
    }

    @Named("mapFaculty")
    default String map(Faculty faculty) {
        return faculty.getTitleRUS();
    }

    @Named("mapSpeciality")
    default String map(Speciality speciality) {
        return speciality.getTitleRUS();
    }

    @Named("mapGroup")
    default String map(Group group) {
        return group.getTitleRUS();
    }

}
