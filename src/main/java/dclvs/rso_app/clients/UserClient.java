package dclvs.rso_app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-server", url = "${server.url.base}${server.url.user}")
public interface UserClient {

    @GetMapping("${server.url.user.all}")
    ResponseEntity<?> getAllUsersOnEvent(Long eventId);

}
