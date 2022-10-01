package com.refactorizando.werbflux.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@ToString
public class RentCar {
    @Id
    private Long id;

    private String nombre;

    private String cars;
}
