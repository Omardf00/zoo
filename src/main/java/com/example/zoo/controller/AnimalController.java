package com.example.zoo.controller;

import com.example.zoo.model.Animal;
import com.example.zoo.service.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/animal")
@CrossOrigin("http://localhost:8888")
@Tag(name = "Animal Services", description = "A list of services designed for the complete CRUD of the animals")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping
    @Operation(description = "Returns a complete list of all the animals in the database")
    @ApiResponse(responseCode = "200", description = "List returned")
    @ApiResponse(responseCode = "500", description = "Error with the service")
    public ResponseEntity<?> getAllAnimals() {

        List<Animal> animals = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        try {
            animals = animalService.getAllAnimals();
        } catch (DataAccessException e) {
            response.put("error", "There was an error trying to access the data base");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("error", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(animals, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Returns an animal by its id")
    @ApiResponse(responseCode = "200", description = "Animal returned")
    @ApiResponse(responseCode = "404", description = "Animal not found")
    @ApiResponse(responseCode = "500", description = "Error with the service")
    public ResponseEntity<?> getAnimalById(@PathVariable("id") int id) {

        Animal animal;
        Map<String, Object> response = new HashMap<>();

        try {
            animal = animalService.getAnimalById(id);
            if (animal == null) {
                response.put("error", "There's no animal with id " + id + " in the data base");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException e) {
            response.put("error", "There was an error trying to access the data base");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("error", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(animal, HttpStatus.OK);
    }

    @PostMapping
    @Operation(description = "Inserts a new animal in the data base")
    @ApiResponse(responseCode = "201", description = "Animal created")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "500", description = "Error with the service")
    public ResponseEntity<?> saveAnimal(@Valid @RequestBody Animal animal, BindingResult result) {

        Map<String, Object> response = new HashMap<>();
        Animal animalTmp;

        if (result.hasErrors()) {
            response.put("error", "The fields are not in the correct form");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            animalTmp = animalService.saveAnimal(animal);
        } catch (DataAccessException e) {
            response.put("error", "There was an error trying to access the data base");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("error", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(animalTmp, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(description = "Updates an animal in the database")
    @ApiResponse(responseCode = "200", description = "Animal updated")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Animal not found")
    @ApiResponse(responseCode = "500", description = "Error with the service")
    public ResponseEntity<?> updateAnimal(@Valid @RequestBody Animal animal, BindingResult result) {

        Map<String, Object> response = new HashMap<>();
        Animal animalTmp;

        if (result.hasErrors() || animal.getId() == 0) {
            response.put("error", "The fields are not in the correct form");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        if (animalService.getAnimalById(animal.getId()) == null) {
            response.put("error", "There's no animal with id " + animal.getId() + " in the data base");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            animalTmp = animalService.saveAnimal(animal);
        } catch (DataAccessException e) {
            response.put("error", "There was an error trying to access the data base");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("error", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(animalTmp, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Removes an animal from the database by its id")
    @ApiResponse(responseCode = "200", description = "Animal deleted")
    @ApiResponse(responseCode = "404", description = "Animal not found")
    @ApiResponse(responseCode = "500", description = "Error with the service")
    public ResponseEntity<?> deleteAnimal(@PathVariable("id") int id) {

        Map<String, Object> response = new HashMap<>();

        try {
            if (animalService.getAnimalById(id) == null) {
                response.put("error", "There's no animal with id " + id + " in the data base");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            animalService.deleteAnimalById(id);
        } catch (DataAccessException e) {
            response.put("error", "There was an error trying to access the data base");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.put("error", "The service is not available at the moment");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "The animal has been successfuly deleted");
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

}
