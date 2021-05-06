package com.food.location.domain.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "states")
public class State {

    @Id
    @EqualsAndHashCode.Include
    @Column(columnDefinition = "TINYINT(3)")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(length = 30)
    private String name;

    @Column(length = 2, columnDefinition = "Char(2)")
    private String uf;
}
