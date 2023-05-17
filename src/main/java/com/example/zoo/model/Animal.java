package com.example.zoo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    private String commonName;

    @NotNull
    @NotBlank
    @Column(length = 42)
    private String scientificName;

    @NotNull
    @NotBlank
    private String specie;

    @NotNull
    @NotBlank
    private String family;

}
