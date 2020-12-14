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

    public Animal() {

    }

    public Animal(String group, String classification, String species, String breed, String name, String DOB, Double weight, String description) {
        this.group = group;
        this.classification = classification;
        this.species = species;
        this.breed = breed;
        this.name = name;
        this.DOB = DOB;
        this.weight = weight;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return animalId == animal.animalId &&
                Objects.equals(group, animal.group) &&
                Objects.equals(classification, animal.classification) &&
                Objects.equals(species, animal.species) &&
                Objects.equals(breed, animal.breed) &&
                Objects.equals(name, animal.name) &&
                Objects.equals(DOB, animal.DOB) &&
                Objects.equals(weight, animal.weight) &&
                Objects.equals(description, animal.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalId, group, classification, species, breed, name, DOB, weight, description);
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
                ", weight='" + weight + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
