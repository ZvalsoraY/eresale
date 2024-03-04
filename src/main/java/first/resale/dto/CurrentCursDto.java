package first.resale.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "ValCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class CurrentCursDto implements Serializable {

    @XmlElement(name = "Valute")
    private List<CurrentCursOnceDto> valute;
    @XmlElement(name = "Date")
    private LocalDate date;

    public List<CurrentCursOnceDto> getValute() {
        return valute;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "valute=" + valute +
                ", date=" + date +
                '}';
    }
}
