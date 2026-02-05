package se.iths.martin.javaverktyglabb2.exception;

public class MaxWithdrawalExceededException extends RuntimeException {

    public MaxWithdrawalExceededException(String message) {
        super(message);
    }
}
