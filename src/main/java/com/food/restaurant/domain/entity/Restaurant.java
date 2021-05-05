package com.food.restaurant.domain.entity;

import com.food.kitchen.domain.entity.Kitchen;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurant {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    //nullable=true / false determina se o campo pode ser ou não nulo
    @Column(name="taxa_frete")
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "kitchen_id") //default cozinha_id
    private Kitchen kitchen;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", taxaFrete=" + taxaFrete +
                '}';
    }
}
