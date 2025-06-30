package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Ucitelj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String ime;

    @ManyToOne
    @JoinColumn(name = "skola_id")
    public Skola skola;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ucitelj_predmet",
            joinColumns = @JoinColumn(name = "ucitelj_id"),
            inverseJoinColumns = @JoinColumn(name = "predmet_id"))
    public List<Predmet> predmeti;
}