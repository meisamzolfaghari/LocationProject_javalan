package ir.javaland.projects.location.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "STREET_ADDRESS")
    private String streetAddress;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_PROVINCE")
    private String stateProvince;

    @OneToOne(mappedBy = "location")
    @JoinColumn(name = "COUNTRY_ID")
    private Country country;

    public Location() {
    }

    public Location(String streetAddress, String postalCode, String city, String stateProvince) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.stateProvince = stateProvince;
    }

    public Long getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(streetAddress, location.streetAddress) &&
                Objects.equals(postalCode, location.postalCode) &&
                Objects.equals(city, location.city) &&
                Objects.equals(stateProvince, location.stateProvince) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", stateProvince='" + stateProvince + '\'' +
                ", country=" + country +
                '}';
    }
}
