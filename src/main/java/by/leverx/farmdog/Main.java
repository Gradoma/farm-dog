package by.leverx.farmdog;

import by.leverx.farmdog.entity.Dog;
import by.leverx.farmdog.logic.FarmManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogList = new ArrayList<>();
        Dog d1 = new Dog();
        d1.setName("Jack");
        d1.setHealthy(false);
        d1.setFed(false);
        d1.setBirthday(LocalDate.now().minusYears(10));
        dogList.add(d1);

        Dog d2 = new Dog();
        d2.setName("Bekky");
        d2.setHealthy(true);
        d2.setFed(false);
        d2.setBirthday(LocalDate.now().minusYears(3));
        dogList.add(d2);

        Dog d3 = new Dog();
        d3.setName("Poly");
        d3.setHealthy(false);
        d3.setFed(false);
        d3.setBirthday(LocalDate.now().minusMonths(11));
        dogList.add(d3);

        FarmManager farmManager = FarmManager.getInstance();
        farmManager.setDogList(dogList);

        farmManager.startDay();
    }
}
