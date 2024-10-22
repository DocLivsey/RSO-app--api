package dclvs.rso_app.entities.components;

import dclvs.rso_app.Constants;
import dclvs.rso_app.exceptions.UnprocessableEmailException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
@Getter
public class Email {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@(.+)$",
            Pattern.CASE_INSENSITIVE
    );

    private String email;

    public Email(String email) {
        setEmail(email);
    }

    public void setEmail(String email) {
        try {
            validateEmail(email);
            this.email = email;
        } catch (UnprocessableEmailException exception) {
            this.email = Constants.UNDEFINED;
            log.error(exception.getMessage(), exception);
        }
    }

    public static boolean isEmailCorrect(String email) {
        return VALID_EMAIL_ADDRESS_REGEX
                .matcher(email)
                .matches();
    }

    public void validateEmail(String email) throws UnprocessableEmailException {
        if (!isEmailCorrect(email)) {
            throw new UnprocessableEmailException(
                    STR."\{Constants.ANSI_RED_BACKGROUND}" +
                            "email form is not correct! Validation did not pass" +
                            STR."\{Constants.RESET}"
            );
        } else {
            log.info("{}email is correct! Validation passed successfully{}",
                    STR."\{Constants.ANSI_GREEN_BACKGROUND}",
                    STR."\{Constants.RESET}"
            );
        }
    }

}
