package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class PublicHoliday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String date;
    public String localName;
    public String name;
    public String countryCode;
    public boolean fixed;
    public boolean global;
    public int year;

    @OneToMany(mappedBy = "holiday", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<HolidayType> types;
}