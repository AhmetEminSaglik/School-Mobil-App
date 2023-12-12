package utility.exception;

public class InvalidSignupUsernameException extends RuntimeException {
    public static String customErrorMsg = "Kullanıcı adı zaten kullanımda. Lütfen başka bir kullanıcı adı seçin";

    public InvalidSignupUsernameException() {
        super(customErrorMsg);
    }

}
