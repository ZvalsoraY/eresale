package first.resale.handlers;

import first.resale.exceptions.ExchangeRateUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
//import first.resale.exceptions.NotFoundException;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

//@RestControllerAdvice
@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler{
    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode()
                .series() == SERVER_ERROR) {
            try {
                throw new ExchangeRateUnavailableException(httpResponse.getStatusText());
            } catch (ExchangeRateUnavailableException e) {
                throw new RuntimeException(e);
            }
            // handle SERVER_ERROR
        } else if (httpResponse.getStatusCode()
                .series() == CLIENT_ERROR) {
            try {
                throw new ExchangeRateUnavailableException(httpResponse.getStatusText());
            } catch (ExchangeRateUnavailableException e) {
                throw new RuntimeException(e);
            }
            // handle CLIENT_ERROR
        }
    }

    /*@ExceptionHandler(value = {ExchangeRateUnavailableException.class})
    public ResponseEntity<Object> restTemplateResponseErrorHandler
            (ExchangeRateUnavailableException exchangeRateUnavailableException)
    {
        RestTemplateResponseErrorHandler restTemplateResponseErrorHandler = new ExchangeRateUnavailableException(
                exchangeRateUnavailableException.getMessage(),
                exchangeRateUnavailableException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(restTemplateResponseErrorHandler, HttpStatus.NOT_FOUND);
    }*/
//    @ExceptionHandler(ExchangeRateUnavailableException.class)
//    public ResponseEntity<ErrorMessage> notFoundException(NotFoundException exception) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(new ErrorMessage(exception.getMessage()));
//    }
}
