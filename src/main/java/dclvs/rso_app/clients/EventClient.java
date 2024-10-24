package dclvs.rso_app.clients;

import dclvs.rso_app.entities.EventTransceiver;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@FeignClient(name = "event-server", url = "${server.url.base}${server.url.event}")
public interface EventClient {

    @GetMapping("${server.url.event.all}")
    ResponseEntity<?> allEventsAtDate(@RequestParam Calendar date);

    @PostMapping("${server.url.event.add}")
    ResponseEntity<?> addEvent(@RequestBody EventTransceiver eventTransceiver);

    @DeleteMapping("${server.url.event.remove}")
    ResponseEntity<?> removeEvent(@RequestParam Long eventId);

}
