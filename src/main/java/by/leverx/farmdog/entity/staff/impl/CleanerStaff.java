package by.leverx.farmdog.entity.staff.impl;

import by.leverx.farmdog.entity.Aviary;
import by.leverx.farmdog.entity.staff.Staff;

public class CleanerStaff implements Staff {

    @Override
    public void serve(Aviary aviary) {
        aviary.setClean(true);
        System.out.println("Aviary for " + aviary.getDog().getName() + " is clean");
    }
}
