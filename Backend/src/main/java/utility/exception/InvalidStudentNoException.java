package utility.exception;

public class InvalidStudentNoException extends RuntimeException {
    public static String customErrorMsg = "Öğrenci No zaten kullanımda. Lütfen başka bir öğrenci no girin.";

    public InvalidStudentNoException() {
        super(customErrorMsg);
    }

}
