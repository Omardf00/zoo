package com.example.zoo.repository;

import com.example.zoo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalDao extends JpaRepository<Animal, Integer> {
}
