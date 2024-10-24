package dclvs.rso_app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-server", url = "${server.url.base}${server.url.user}")
public interface UserClient {

    @GetMapping("${server.url.user.all}")
    ResponseEntity<?> getAllUsersOnEvent(@RequestParam Long eventId);

}
