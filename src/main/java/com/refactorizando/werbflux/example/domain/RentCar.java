package com.refactorizando.werbflux.example.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RentCar {
    @Id
    private Long id;
    private String nombre;
}
