package com.food.kitchen.presentation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.food.kitchen.domain.entity.Kitchen;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@JacksonXmlRootElement(localName = "kitchens") //quando o json entregar este objeto em formato json modifica o nome do elemento Root
@Data
public class ListKitchensXmlResponse {

    @JsonProperty("kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)//remove o nome da lista criado dinamicamente  list_kitchen
    @NonNull //lombok cria construtor tendo como parametro a list of Kitchen
    private List<Kitchen> kitchenList;
}
