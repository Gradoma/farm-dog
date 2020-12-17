package by.leverx.farmdog.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Dog {
    private String name;
    private LocalDate birthday;
    private boolean healthy;
    private boolean fed;
    private boolean trained;
    private AbstractDogState state;

    public void feed(){
        state.feed();
    }

    public void doActivity(){
        state.doActivity();
    }
}
