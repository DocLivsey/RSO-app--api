package dclvs.rso_app.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class EventReceiver {

    private Long eventId;

    private String tagName;

    private String description;

    private String scheduledDate;

    private String beginAt;

    private String endsAt;

}
