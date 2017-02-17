package rest.dto;

import domain.model.Country;

import javax.xml.bind.annotation.XmlRootElement;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@XmlRootElement
public class TourDto {

    private int id;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
