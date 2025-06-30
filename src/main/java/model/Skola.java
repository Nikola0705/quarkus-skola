package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Skola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String naziv;

    @OneToMany(mappedBy = "skola", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Ucitelj> ucitelji;
}