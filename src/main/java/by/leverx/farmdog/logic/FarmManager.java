package by.leverx.farmdog.logic;

import by.leverx.farmdog.entity.Aviary;
import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.entity.state.AdultState;
import by.leverx.farmdog.entity.state.ElderlyState;
import by.leverx.farmdog.entity.state.PuppyState;
import by.leverx.farmdog.logic.impl.ActivitiesManager;
import by.leverx.farmdog.logic.impl.DogFeeder;
import by.leverx.farmdog.logic.impl.Veterinarian;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FarmManager {
    private static FarmManager instance;
    private List<Dog> dogList;
    private Map<String, Aviary> aviaryMap;
    @Setter
    private AbstractDogHandler handler;

    private FarmManager(){
    }

    public static FarmManager getInstance() {
        if(instance == null){
            instance = new FarmManager();
        }
        return instance;
    }

    public void setDogList(List<Dog> dogList){
        this.dogList = dogList;
        aviaryMap = new HashMap<>();
        dogList.forEach(dog -> aviaryMap.put(dog.getName(), new Aviary(dog)));
    }

    public Aviary getAviaryByDogName(String name){
        return aviaryMap.get(name);
    }

    public void startDay(){
        setHandlers();
        for (Dog dog: dogList) {
            System.out.println(dog.getName() + " start day");
            defineDogType(dog);
            handler.handle(dog);
        }
    }

    private void defineDogType(Dog dog){
        int ages = Period.between(dog.getBirthday(), LocalDate.now()).getYears();
        if(ages == 0){
            dog.setState(new PuppyState(dog));
        } else if(ages > 8){
            dog.setState(new ElderlyState(dog));
        } else {
            dog.setState(new AdultState(dog));
        }
    }

    private void setHandlers(){
        DogFeeder feederHandler = new DogFeeder();
        feederHandler.setNextHandler(new Veterinarian())
                .setNextHandler(new ActivitiesManager());
        this.handler = feederHandler;
    }
}
