package com.example.zoo.repository;

import com.example.zoo.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalDao extends JpaRepository<Animal, Integer> {

    @Query(value = "SELECT *\n" +
            "FROM animal\n" +
            "WHERE common_name LIKE %:query% OR scientific_name LIKE %:query% LIMIT 5",
            nativeQuery = true)
    public List<Animal> findByCommonName(@Param("query") String name);

}
