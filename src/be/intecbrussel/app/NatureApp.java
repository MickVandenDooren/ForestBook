package be.intecbrussel.app;

import be.intecbrussel.entities.animal_entities.*;
import be.intecbrussel.entities.plant_entities.*;
import be.intecbrussel.service.ForestNotebook;

import java.util.*;

public class NatureApp {

    public static void main(String[] args) {

        ForestNotebook notebook = new ForestNotebook();

        Flower plant1 = new Flower("rose");
        notebook.addPlant(plant1);
        plant1.setHeight(10);
        plant1.setSmell(Scent.SWEET);

        Bush plant2 = new Bush("blueberries",40);
        plant2.setFruit("blueberry");
        plant2.setLeafType(LeafType.NEEDLE);
        notebook.addPlant(plant2);

        Weed plant3 = new Weed("dandelion",20);
        notebook.addPlant(plant3);

        Bush plant4 = new Bush("raspberries",50);
        plant4.setLeafType(LeafType.NEEDLE);
        plant4.setFruit("raspberry");
        notebook.addPlant(plant4);

        Herbivore animal1 = new Herbivore("sheep",30,80,100);
        notebook.addAnimal(animal1);

        Carnivore animal2 = new Carnivore("fox",20,60,100);
        animal2.setMaxFoodSize(120);
        notebook.addAnimal(animal2);

        Omnivore animal3 = new Omnivore("raccoon", 7,40,60);
        notebook.addAnimal(animal3);

        Herbivore animal4 = new Herbivore("rabbit",3,25,40);
        notebook.addAnimal(animal4);

        Herbivore animal5 = new Herbivore("deer",60,200,150);
        Set<Plant> deerDiet = new HashSet<>();
        animal5.setPlantDiet(deerDiet);
        animal5.addPlantToDiet(plant2);
        notebook.addAnimal(animal5);

        notebook.printNotebook();

        notebook.sortAnimalsByName();
        notebook.sortPlantsByName();

        //Check if duplicate-checks work
        Flower plant5 = new Flower("rose");
        notebook.addPlant(plant5);

        Herbivore animal6 = new Herbivore("rabbit",4,21,40);
        notebook.addAnimal(animal6);

        //Split output for easy recognition
        System.out.println("///////////////////");
        notebook.printNotebook();



    }
}
