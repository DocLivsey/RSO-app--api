package dclvs.rso_app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-server", url = "http://localhost:8080/user")
public interface UserClient {

    @GetMapping("/all")
    ResponseEntity<?> getAllUsersOnEvent(Long eventId);

}
