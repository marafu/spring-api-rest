package ga.cosse.sprigrestapi.domain.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Address {
    String street;
    Integer streetNumber;
    String zipcode;
    String landmark;
    @ManyToOne
    City city;
}
