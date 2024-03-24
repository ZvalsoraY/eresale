package first.resale.controller;

//import first.resale.dto.сurrentcurs.ObjectFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import first.resale.dto.сurrentcurs.ValCurs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.StringReader;
import java.util.List;

@RestController
public class GetCurrentCursController {
    //http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
    //private final CurrentCursService currentCursService;
    //private final CurrentCursClient currentCursClient;
    //public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";
    //public static  String URLSTART = "https://cbr.ru/scripts/XML_daily.asp?date_req=";
    final RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/getCourse")
    @ResponseBody
    public ValCurs getCourse(@RequestParam String date) throws JsonProcessingException, JAXBException {

        String response = restTemplate.getForObject("http://cbr.ru/scripts/XML_daily.asp?date_req={date}", String.class, date);
        JAXBContext context = JAXBContext.newInstance(ValCurs.class);
        return (ValCurs) context.createUnmarshaller()
                .unmarshal(new StringReader(response));

    }
}
