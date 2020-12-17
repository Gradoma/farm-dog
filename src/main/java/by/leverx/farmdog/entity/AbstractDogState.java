package by.leverx.farmdog.entity;

public abstract class AbstractDogState {
    protected Dog dog;

    public AbstractDogState(Dog dog){
        this.dog = dog;
    }

    public abstract void feed();
    public abstract void doActivity();
}
