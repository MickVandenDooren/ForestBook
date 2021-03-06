package be.intecbrussel.the_notebook.service;

import java.util.*;
import java.util.stream.Collectors;

import be.intecbrussel.the_notebook.entities.animal_entities.*;
import be.intecbrussel.the_notebook.entities.plant_entities.*;

public class ForestNotebook {

    private List<Carnivore> carnivores = new LinkedList<>();
    private List<Omnivore> omnivores = new LinkedList<>();
    private List<Herbivore> herbivores = new LinkedList<>();

    private int plantCount = 0;
    private int animalCount = 0;

    private List<Animal> animals = new LinkedList<>();
    private List<Plant> plants = new LinkedList<>();


    public ForestNotebook(){}

    public List<Carnivore> getCarnivores() {
        return carnivores;
    }

    public void setCarnivores(List<Carnivore> carnivores) {
        this.carnivores = carnivores;
    }

    public List<Omnivore> getOmnivores() {
        return omnivores;
    }

    public void setOmnivores(List<Omnivore> omnivores) {
        this.omnivores = omnivores;
    }

    public List<Herbivore> getHerbivores() {
        return herbivores;
    }

    public void setHerbivores(List<Herbivore> herbivores) {
        this.herbivores = herbivores;
    }

    public int getPlantCount() {
        return plantCount;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void addAnimal(Animal animal){
        //Check to see if animal is in notebook
        boolean inNotebook = false;
        for (Animal a : animals) {
            if (animal.getName().equals(a.getName())) {
                inNotebook = true;
                break;
            }
        }
        if (inNotebook) {
            System.out.println();
            System.out.println("Animal [" + animal.getName() +"] already in notebook.");
        } else {
            animals.add(animal);
            animalCount++;

                        //Add animal to subclasses
                        if (animal instanceof Omnivore){
                            omnivores.add((Omnivore) animal);
                        }
                        if (animal instanceof Carnivore){
                            carnivores.add((Carnivore) animal);
                        }
                        if (animal instanceof Herbivore){
                        herbivores.add((Herbivore) animal);
                        }
        }
    }

    public void addPlant(Plant plant){
        //Check to see if plant is in notebook
        boolean inNotebook2 = false;
        for (Plant p : plants) {
            if (plant.getName().equals(p.getName())) {
                inNotebook2 = true;
                break;
            }
        }
        if (inNotebook2) {
            System.out.println();
            System.out.println("Plant [" + plant.getName() +"] already in notebook.");
        } else {
            plants.add(plant);
            plantCount++;
        }
    }

    public void printNotebook(){
        System.out.println("--- Notebook ---");
        System.out.println("PLANTS:");
        if (plantCount == 0){
            System.out.println("No plants in notebook");
        } else {
            System.out.println("["+ plantCount + " different plants]");
            plants.stream().map(Plant::getName).forEach(System.out::println);
        }
        System.out.println("================");

        System.out.println("ANIMALS:");
        if (animalCount == 0){
            System.out.println("No animals in notebook");
        } else {
            System.out.println("["+ animalCount+ " different animals]");
            System.out.println(herbivores.size() + " HERBIVORES: ");
            herbivores.stream().map(Herbivore::getName).forEach(System.out::println);
            System.out.println(carnivores.size() + " CARNIVORES: ");
            carnivores.stream().map(Carnivore::getName).forEach(System.out::println);
            System.out.println(omnivores.size() + " OMNIVORES: ");
            omnivores.stream().map(Omnivore::getName).forEach(System.out::println);
        }

        System.out.println("----------------");
    }

    public void sortAnimalsByName() {
        System.out.println();
        System.out.println("Animals being sorted by name...");
        animals = animals.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        herbivores = herbivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        carnivores = carnivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
        omnivores = omnivores.stream().sorted(Comparator.comparing(Animal::getName)).collect(Collectors.toList());
    }

    public void sortPlantsByName() {
        System.out.println();
        System.out.println("Plants being sorted by name...");
        plants = plants.stream().sorted(Comparator.comparing(Plant::getName)).collect(Collectors.toList());
    }

    public void sortAnimalsByHeight(){
        System.out.println();
        System.out.println("Animals being sorted by height...");
        animals = animals.stream().sorted(Comparator.comparing(Animal::getHeight)).collect(Collectors.toList());
        herbivores = herbivores.stream().sorted(Comparator.comparing(Animal::getHeight)).collect(Collectors.toList());
        carnivores = carnivores.stream().sorted(Comparator.comparing(Animal::getHeight)).collect(Collectors.toList());
        omnivores = omnivores.stream().sorted(Comparator.comparing(Animal::getHeight)).collect(Collectors.toList());
    }

    public void sortPlantsByHeight(){
        System.out.println();
        System.out.println("Plants being sorted by height...");
        plants = plants.stream().sorted(Comparator.comparing(Plant::getHeight)).collect(Collectors.toList());
    }




}
