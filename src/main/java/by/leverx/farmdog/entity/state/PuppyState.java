package by.leverx.farmdog.entity.state;

import by.leverx.farmdog.entity.AbstractDogState;
import by.leverx.farmdog.entity.Dog;

public class PuppyState extends AbstractDogState {
    public PuppyState(Dog dog){
        super(dog);
        dog.setTrained(false);
    }

    @Override
    public void feed() {
        System.out.println("Small portion for " + dog.getName());
        dog.setFed(true);
    }

    @Override
    public void doActivity() {
        System.out.println("Puppy is training");
        dog.setTrained(true);
    }
}
