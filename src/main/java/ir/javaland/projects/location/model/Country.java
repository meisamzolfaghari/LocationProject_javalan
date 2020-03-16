package ir.javaland.projects.location.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @OneToOne
    private Location location;

    public Country() {
    }

    public Country(String countryCode, String countryName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
    }

    public Country(String countryCode, String countryName, Location location) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(countryCode, country.countryCode) &&
                Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}