//package first.resale.handlers;
//
//import first.resale.exceptions.ExchangeRateUnavailableException;
//import first.resale.exceptions.NotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.client.ClientHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.client.ResponseErrorHandler;
//
//import java.io.IOException;
//
//import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
//import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;
//
//@Component
//public class RestTemplateResponseErrorHandler1 implements ResponseErrorHandler {
//
//    @Override
//    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
//        return httpResponse.getStatusCode().is5xxServerError() ||
//                httpResponse.getStatusCode().is4xxClientError() ||
//                httpResponse.getStatusCode().isError();
//    }
//
//    @Override
//    public void handleError(ClientHttpResponse httpResponse) throws IOException {
//        if (httpResponse.getStatusCode().is5xxServerError()) {
//            //Handle SERVER_ERROR
//            throw new HttpClientErrorException(httpResponse.getStatusCode());
//        } else if (httpResponse.getStatusCode().is4xxClientError()) {
//            //Handle CLIENT_ERROR
//            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new NotFoundException();
//            }
//        }
//    }
//
//    @Override
//    public void handleError(ClientHttpResponse httpResponse) throws IOException {
//
//        if (httpResponse.getStatusCode()
//                .series() == HttpStatus.Series.SERVER_ERROR) {
//            // handle SERVER_ERROR
//        } else if (httpResponse.getStatusCode()
//                .series() == HttpStatus.Series.CLIENT_ERROR) {
//            // handle CLIENT_ERROR
//            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new NotFoundException();
//            }
//        }
//    }
//}