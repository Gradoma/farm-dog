package by.leverx.farmdog.logic.impl;

import by.leverx.farmdog.entity.Aviary;
import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.logic.AbstractDogHandler;

public class ActivitiesManager extends AbstractDogHandler {
    @Override
    public void handle(Dog dog) {
        dog.doActivity();
        System.out.println("Activity finished! Dog goes home");
        Aviary aviary = farmManager.getAviaryByDogName(dog.getName());
        if(!aviary.isOccupied()){
            aviary.setOccupied(true);
            System.out.println("Dog in aviary after hard work");
        }
        nextHandle(dog);
    }
}
