package com.ehsan;

import java.util.ArrayList;
import java.util.List;

public class Actuator implements IObservable {

    private boolean StatusOfCooling;
    private Actuator(IObservable sensor){StatusOfCooling = false;}


    /// Calling User_builder in Actuator.
    public Actuator() {
        Sensor.getBuilder();
    }
    static int Temperature;


    /// To make a list of observers.
    private List<IObserver> Observers = new ArrayList<>();

    private void addObserver(IObserver Observer2){
        Observers.add(Observer2);
    }

    private void removeObserver(IObserver Observer2){
        Observers.remove(Observer2);
    }

    private void notifyObserver(){
        for(IObserver Observer1: Observers){
            Observer1.Update(StatusOfCooling);
        }
    }

    /// Dependency Inversion - Using advertising function.
    @Override
    public void advertising() {
        addObserver(Sensor.getBuilder());
        notifyObserver();
    }

    @Override
    public void advertising2() {
        removeObserver(Sensor.getBuilder());
        notifyObserver();
    }
}




