package model;

import jakarta.persistence.*;

@Entity
public class Ucitelj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String ime;

    @ManyToOne
    @JoinColumn(name = "skola_id")
    public Skola skola;
}