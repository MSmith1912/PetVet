package com.Mark.PetVet.petVet.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int animalId;

    @Column(name ="animal_group")
    private String group;

    @Column(name ="animal_classification")
    private String classification;

    @Column(name ="animal_species")
    private String species;

    @Column(name ="animal_breed")
    private String breed;

    @Column(name ="animal_name")
    private String name;

    @Column(name ="animal_dob")
    private String DOB;

    @Column(name ="animal_weight")
    private Double weight;

    @Column(name ="animal_description")
    private String description;

    @ManyToOne
    @JoinColumn(name="animal_owner")
    private User animal_owner;

    public Animal() {

    }

    public Animal(String group, String classification, String species, String breed, String name, String DOB, Double weight, String description, User animal_owner) {
        this.group = group;
        this.classification = classification;
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.DOB = DOB;
        this.weight = weight;
        this.description = description;
        this.animal_owner = animal_owner;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAnimal_owner() {
        return animal_owner;
    }

    public void setAnimal_owner(User animal_owner) {
        this.animal_owner = animal_owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                group.equals(animal.group) &&
                classification.equals(animal.classification) &&
                species.equals(animal.species) &&
                breed.equals(animal.breed) &&
                name.equals(animal.name) &&
                DOB.equals(animal.DOB) &&
                weight.equals(animal.weight) &&
                description.equals(animal.description) &&
                animal_owner.equals(animal.animal_owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, group, classification, species, breed, name, DOB, weight, description, animal_owner);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalId=" + animalId +
                ", group='" + group + '\'' +
                ", classification='" + classification + '\'' +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", DOB='" + DOB + '\'' +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", animal_owner=" + animal_owner +
                '}';
    }

}
