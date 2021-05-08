package com.food.restaurant.domain.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.food.kitchen.domain.entity.Kitchen;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;

@JsonRootName(value = "restaurant")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurant {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    //nullable=true / false determina se o campo pode ser ou não nulo
    @Column(name="taxa_frete", nullable = false)
    private BigDecimal feeTransportTaxe;

    @ManyToOne
    @JoinColumn(name = "kitchen_id") //default cozinha_id
    //@JsonIgnore
    private Kitchen kitchen;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", taxaFrete=" + feeTransportTaxe +
                '}';
    }
}
