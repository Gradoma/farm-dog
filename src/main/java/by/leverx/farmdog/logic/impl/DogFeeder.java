package by.leverx.farmdog.logic.impl;

import by.leverx.farmdog.entity.Aviary;
import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.logic.AbstractDogHandler;

public class DogFeeder extends AbstractDogHandler {

    @Override
    public void handle(Dog dog) {
        System.out.println("Morning meal for " + dog.getName());
        dog.feed();
        Aviary aviary = farmManager.getAviaryByDogName(dog.getName());
        System.out.println(dog.getName() + " leave from aviary");
        aviary.setOccupied(false);
        nextHandle(dog);
        System.out.println("Evening meal for " + dog.getName());
        dog.feed();
    }
}
