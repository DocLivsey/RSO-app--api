package dclvs.rso_app.entities.components;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Data
@AllArgsConstructor
public class Password {

    private String password;

    // TODO: this method of hashing has been found not to comply with the determinism requirement
    public byte[] mocPasswordHashing() throws NoSuchAlgorithmException {
        // Generating salt (key)
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);

        // Hashing password
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.update(salt);
        return messageDigest.digest(password.getBytes());
    }

    public boolean matches(Password password) {
        return hashCode() == password.hashCode();
    }

    public boolean matches(String password) {
        return matches(new Password(password));
    }

    public boolean matches(int password) {
        return hashCode() == password;
    }

}
