package first.resale.exceptions;

public class ExchangeRateUnavailableException extends Exception {
    public ExchangeRateUnavailableException(String message) {
        super(message);
    }
}
