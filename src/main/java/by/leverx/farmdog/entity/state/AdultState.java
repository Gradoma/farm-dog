package by.leverx.farmdog.entity.state;

import by.leverx.farmdog.entity.AbstractDogState;
import by.leverx.farmdog.entity.Dog;

public class AdultState extends AbstractDogState {
    public AdultState(Dog dog){
        super(dog);
        dog.setTrained(true);
    }

    @Override
    public void feed() {
        System.out.println("Big enough portion for " + dog.getName());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println(dog.getName() + " is working");
    }
}
