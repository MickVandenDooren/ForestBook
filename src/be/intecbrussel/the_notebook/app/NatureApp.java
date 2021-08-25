package be.intecbrussel.the_notebook.app;

import be.intecbrussel.the_notebook.entities.animal_entities.*;
import be.intecbrussel.the_notebook.entities.plant_entities.*;
import be.intecbrussel.the_notebook.service.ForestNotebook;

import java.util.*;

public class NatureApp {

    public static void main(String[] args) {

        ForestNotebook notebook = new ForestNotebook();

        //Adding 5 plants (at least 1 in each category)
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

        Tree plant5 = new Tree("oak",750);
        notebook.addPlant(plant5);

        //Adding 9 animals (3 for each category)

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
        notebook.addAnimal(animal5);

        Carnivore animal6 = new Carnivore("owl",4,50,170);
        animal6.setMaxFoodSize(10);
        notebook.addAnimal(animal6);

        Carnivore animal7 = new Carnivore("black bear",110,150,230);
        notebook.addAnimal(animal7);

        Omnivore animal8 = new Omnivore("rat",0.5,6,10);
        notebook.addAnimal(animal8);

        Omnivore animal9 = new Omnivore("swine",50,100,120);
        notebook.addAnimal(animal9);

        //Adding herbivore diet to herbivore and omnivore animals
        Set<Plant> herbivoreDiet = new HashSet<>();

        herbivoreDiet.add(plant1);
        herbivoreDiet.add(plant2);
        herbivoreDiet.add(plant3);
        herbivoreDiet.add(plant4);

        animal1.setPlantDiet(herbivoreDiet);
        animal3.setPlantDiet(herbivoreDiet);
        animal4.setPlantDiet(herbivoreDiet);
        animal9.setPlantDiet(herbivoreDiet);

        //print out notebook
        notebook.printNotebook();

        //sort animals
        notebook.sortAnimalsByName();
        notebook.sortPlantsByName();

        //Check if duplicate-checks work
        Flower plant6 = new Flower("rose");
        notebook.addPlant(plant6);

        Herbivore animal10 = new Herbivore("rabbit",4,21,40);
        notebook.addAnimal(animal10);

        //Split output for easy recognition
        System.out.println();
        System.out.println("///////////////////");
        System.out.println();

        //Print sorted notebook
        notebook.printNotebook();
    }
}
