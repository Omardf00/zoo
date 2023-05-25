package com.example.zoo.service;

import com.example.zoo.model.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> getAllAnimals();

    public Animal getAnimalById(int id);

    public List<Animal> getAnimalByName(String name);

    public Animal saveAnimal(Animal animal);

    public void deleteAnimalById(int id);

}
