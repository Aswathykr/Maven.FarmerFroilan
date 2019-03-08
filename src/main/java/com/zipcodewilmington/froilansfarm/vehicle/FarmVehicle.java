package com.zipcodewilmington.froilansfarm.vehicle;

import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.vehicle.interfaces.Vehicle;

public abstract class FarmVehicle implements Vehicle {
    boolean hasRidden;
    boolean operated;

    public void operate(Farm farm){
        this.operated = true;
    }

    public boolean isOperated() {
        return operated;
    }

    @Override
    public boolean hasRidden() {
        return hasRidden;
    }

    @Override
    public void setHasRidden(boolean hasRidden) {
        this.hasRidden = hasRidden;
    }

    @Override
    public void printRideableObject() {
        System.out.println( this.getClass().toString());
    }

}
