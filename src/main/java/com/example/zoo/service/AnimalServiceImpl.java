package com.example.zoo.service;

import com.example.zoo.model.Animal;
import com.example.zoo.repository.AnimalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService{

    @Autowired
    AnimalDao animalDao;

    @Override
    public List<Animal> getAllAnimals() {
        return animalDao.findAll();
    }

    @Override
    public Animal getAnimalById(int id) {
        return animalDao.findById(id).orElse(null);
    }

    @Override
    public List<Animal> getAnimalByName(String name) {
        return animalDao.findByCommonName(name);
    }

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalDao.save(animal);
    }

    @Override
    public void deleteAnimalById(int id) {
        animalDao.deleteById(id);
    }
}
