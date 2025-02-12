package dclvs.rso_app.mappers;

import dclvs.rso_app.entities.EventReceiver;
import dclvs.rso_app.entities.EventTransceiver;
import dclvs.rso_app.exceptions.UnprocessableDateException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Mapper
public interface EventMapper {

    @Mappings({
            @Mapping(source = "eventId", target = "eventId"),
            @Mapping(source = "tagName", target = "tagName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "scheduledDate", target = "scheduledDate", qualifiedByName = "mapDate"),
            @Mapping(source = "beginAt", target = "beginAt", qualifiedByName = "mapDate"),
            @Mapping(source = "endsAt", target = "endsAt", qualifiedByName = "mapDate")
    })
    EventReceiver toReceiver(EventTransceiver eventTransceiver);

    @Mappings({
            @Mapping(source = "eventId", target = "eventId"),
            @Mapping(source = "tagName", target = "tagName"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "scheduledDate", target = "scheduledDate", qualifiedByName = "stringToDate"),
            @Mapping(source = "beginAt", target = "beginAt", qualifiedByName = "stringToDate"),
            @Mapping(source = "endsAt", target = "endsAt", qualifiedByName = "stringToDate")
    })
    EventTransceiver toTransceiver(EventReceiver eventReceiver);

    @Named("mapDate")
    default String map(Calendar date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date.getTime());
    }

    @Named("stringToDate")
    default Calendar map(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
        } catch (ParseException parseException) {
            throw new UnprocessableDateException(parseException.getMessage());
        }
        return calendar;
    }

}
