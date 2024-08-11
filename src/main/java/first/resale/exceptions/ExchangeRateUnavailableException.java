package first.resale.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

//@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ExchangeRateUnavailableException extends Exception {
    public ExchangeRateUnavailableException(String message) {
        super(message);
    }
}
