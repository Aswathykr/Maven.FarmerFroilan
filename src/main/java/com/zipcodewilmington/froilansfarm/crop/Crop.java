package com.zipcodewilmington.froilansfarm.crop;

import com.zipcodewilmington.froilansfarm.animal.interfaces.Produce;
import com.zipcodewilmington.froilansfarm.edible.Edible;
import com.zipcodewilmington.froilansfarm.edible.GenericVegetation;

import java.util.function.Supplier;

public class Crop<T extends Edible> implements Produce {
    Supplier<T> edibleSupplier;

    public Crop(Supplier<T> edibleSupplier){
        this.edibleSupplier = edibleSupplier;
    }

    public Edible yield() {
        return (Edible) edibleSupplier.get();
    }
}