package first.resale.handlers;

import first.resale.exceptions.ExchangeRateUnavailableException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

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
}
