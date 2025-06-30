package model;

import jakarta.persistence.*;

@Entity
public class HolidayType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String type;

    @ManyToOne
    @JoinColumn(name = "holiday_id")
    public PublicHoliday holiday;
}