package by.leverx.farmdog.entity;

import by.leverx.farmdog.entity.staff.Staff;
import by.leverx.farmdog.entity.staff.impl.CleanerStaff;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Aviary {
    private List<Staff> staffList;
    private Dog dog;
    private boolean occupied;
    private boolean isClean;

    public Aviary(Dog dog){
        this.dog = dog;
        staffList = new ArrayList<>();
        staffList.add(new CleanerStaff());
    }

    public void setOccupied(boolean occupied) {
        if(!occupied){
            staffList.forEach(staff -> staff.serve(this));
        }
        this.occupied = occupied;
        System.out.println();
    }
}
