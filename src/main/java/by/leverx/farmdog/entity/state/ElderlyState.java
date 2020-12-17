package by.leverx.farmdog.entity.state;

import by.leverx.farmdog.entity.AbstractDogState;
import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.logic.FarmManager;

public class ElderlyState extends AbstractDogState {
    private final FarmManager farmManager = FarmManager.getInstance();
    public ElderlyState(Dog dog){
        super(dog);
        dog.setTrained(true);
    }

    @Override
    public void feed() {
        System.out.println("Only one bone for old friend " + dog.getName());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println("Old friend wanna rest");
        farmManager.getAviaryByDogName(dog.getName()).setOccupied(true);
    }
}
