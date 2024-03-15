package first.resale.controller;

import first.resale.dto.CurrentCursDto;
import first.resale.dto.CurrentCursOnceDto;
import first.resale.dto.сurrentcurs.ValCurs;
import first.resale.service.CurrentCursClient;
import first.resale.service.CurrentCursService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GetCurrentCursController {
    //http://www.cbr.ru/scripts/XML_daily.asp?date_req=02/03/2002
    //private final CurrentCursService currentCursService;
    //private final CurrentCursClient currentCursClient;
    //public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";
    public static  String URLSTART = "https://cbr.ru/scripts/XML_daily.asp?date_req";
    final RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/getCourse")
    @ResponseBody
    public ValCurs getCourse(@RequestParam String date) {
        //URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";
        //return currentCursService.findCourseInfo().toString();
        //return currentCursClient.getCourses().toString();

        //public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";

        //final RestTemplate restTemplate = new RestTemplate();


        //public List<CurrentCursOnceDto> getCourses() {
         /*   CurrentCursDto response = restTemplate.getForObject(URL, CurrentCursDto.class);

        if (response != null) {
            response
                    .getValute()
                    .forEach(x -> {
                        x.setValue(Double.parseDouble(x.get_Value().replace(",", ".")));
                        System.out.println(x);
                    });

            return response.getValute().toString();
        }

        return null;*/
        //}
        ValCurs valCurs = restTemplate.getForObject(URLSTART + date + ".xml", ValCurs.class);
        return valCurs;

    }
}
