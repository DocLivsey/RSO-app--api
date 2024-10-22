package dclvs.rso_app.entities.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
@Slf4j
@EqualsAndHashCode
public class Password { // TODO: in future create password hashing -> as consequence supplement password datasource mapping model

    private String password;

    public Password(String password) {
        this.password = password;
        this.password = STR."\{hashCode()}";
    }

}
