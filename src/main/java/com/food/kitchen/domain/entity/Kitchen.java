package com.food.kitchen.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data //lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="kitchens")
public class Kitchen {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @Override
    public String toString() {
        return "Kitchen -- Meu {" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
