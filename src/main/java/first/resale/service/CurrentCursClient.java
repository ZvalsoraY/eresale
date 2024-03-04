package first.resale.service;

import first.resale.dto.CurrentCursDto;
import first.resale.dto.CurrentCursOnceDto;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CurrentCursClient {
    public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/01/2022.xml";

    final RestTemplate restTemplate = new RestTemplate();


    public List<CurrentCursOnceDto> getCourses() {
        CurrentCursDto response = restTemplate.getForObject(URL, CurrentCursDto.class);

        if (response != null) {
            response
                    .getValute()
                    .forEach(x -> {
                        x.setValue(Double.parseDouble(x.get_Value().replace(",", ".")));
                        System.out.println(x);
                    });

            return response.getValute();
        }

        return null;
    }
}
