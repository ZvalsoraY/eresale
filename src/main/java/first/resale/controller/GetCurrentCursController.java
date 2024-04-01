package first.resale.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import first.resale.dto.сurrentcurs.ValCurs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;

@RestController
public class GetCurrentCursController {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String cbrUrl = "http://cbr.ru/scripts/XML_daily.asp?date_req={date}";

    @GetMapping(value = "/getCourse")
    @ResponseBody
    public ValCurs getCourse(@RequestParam String date) throws JsonProcessingException, JAXBException {

        String response = restTemplate.getForObject(cbrUrl, String.class, date);
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        return (ValCurs) context.createUnmarshaller()
                .unmarshal(new StringReader(response));

    }
}
