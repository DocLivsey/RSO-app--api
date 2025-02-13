package dclvs.rso_app.mappers;

import dclvs.rso_app.entities.UserReceiver;
import dclvs.rso_app.entities.UserTransceiver;
import dclvs.rso_app.entities.components.*;
import dclvs.rso_app.exceptions.UnprocessableDateException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.text.ParseException;
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

    @Mappings({
            @Mapping(source = "userId", target = "userId"),
            @Mapping(source = "email", target = "email", qualifiedByName = "stringToEmail"),
            @Mapping(source = "password", target = "password", qualifiedByName = "stringToPassword"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "surName", target = "surName"),
            @Mapping(source = "patronymicName", target = "patronymicName"),
            @Mapping(source = "birthday", target = "birthday", qualifiedByName = "stringToBirthday"),
            @Mapping(source = "faculty", target = "faculty", qualifiedByName = "stringToFaculty"),
            @Mapping(source = "speciality", target = "speciality", qualifiedByName = "stringToSpeciality"),
            @Mapping(source = "course", target = "course"),
            @Mapping(source = "group", target = "group", qualifiedByName = "stringToGroup")
    })
    UserTransceiver toTransceiver(UserReceiver userReceiver);

    @Named("mapEmail")
    default String map(Email email) {
        return email.getEmail();
    }

    @Named("mapPassword")
    default String map(Password password) {
        return password.getPassword();
    }

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

    @Named("stringToEmail")
    default Email stringToEmail(String email) {
        return new Email(email);
    }

    @Named("stringToPassword")
    default Password stringToPassword(String password) {
        return new Password(password);
    }

    @Named("stringToBirthday")
    default Calendar stringToBirthday(String birthday) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(birthday));
        } catch (ParseException parseException) {
            throw new UnprocessableDateException(parseException.getMessage());
        }
        return calendar;
    }

    @Named("stringToFaculty")
    default Faculty stringToFaculty(String facultyTitleRUS) {
        return new Faculty(facultyTitleRUS);
    }

    @Named("stringToSpeciality")
    default Speciality stringToSpeciality(String specialityTitleRUS) {
        return new Speciality(specialityTitleRUS);
    }

    @Named("stringToGroup")
    default Group stringToGroup(String groupTitleRUS) {
        return new Group(groupTitleRUS);
    }

}
