package by.leverx.farmdog.logic.impl;

import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.logic.AbstractDogHandler;

public class Veterinarian extends AbstractDogHandler {

    @Override
    public void handle(Dog dog) {
        if(!dog.isHealthy()){
            System.out.println(dog.getName() + " need to be heal");
            dog.setHealthy(true);
        }
        System.out.println(dog.getName() + " is healthy");
        nextHandle(dog);
    }
}
