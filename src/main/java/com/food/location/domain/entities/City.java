package com.food.location.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cities")
public class City {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(length = 50)
    private String name;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;
}
