package com.food.kitchen.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@JsonRootName(value = "kitchen")
@Data //lombok
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="kitchens")
public class Kitchen {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore //not show this field when jackson convert object into json
    //@JsonProperty(value = "name_modified_only_rest")
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
