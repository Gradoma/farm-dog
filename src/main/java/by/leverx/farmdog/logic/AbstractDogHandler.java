package by.leverx.farmdog.logic;

import by.leverx.farmdog.entity.Dog;

public abstract class AbstractDogHandler {
    protected final FarmManager farmManager = FarmManager.getInstance();
    private AbstractDogHandler nextHandler;

    public AbstractDogHandler setNextHandler(AbstractDogHandler nextHandler){
        this.nextHandler = nextHandler;
        return nextHandler;
    }

    public abstract void handle(Dog dog);

    public void nextHandle(Dog dog){
        if(nextHandler != null){
            nextHandler.handle(dog);
        }
    }
}
