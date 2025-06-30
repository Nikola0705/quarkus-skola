package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Predmet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String naziv;

    @ManyToMany(mappedBy = "predmeti")
    public List<Ucitelj> ucitelji;
}