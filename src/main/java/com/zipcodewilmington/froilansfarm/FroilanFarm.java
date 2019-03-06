package com.zipcodewilmington.froilansfarm;


import com.zipcodewilmington.froilansfarm.animal.Chicken;
import com.zipcodewilmington.froilansfarm.animal.Farmer;
import com.zipcodewilmington.froilansfarm.animal.Horse;
import com.zipcodewilmington.froilansfarm.animal.Person;
import com.zipcodewilmington.froilansfarm.crop.CornStalk;
import com.zipcodewilmington.froilansfarm.crop.Crop;
import com.zipcodewilmington.froilansfarm.crop.GenericVegetation;
import com.zipcodewilmington.froilansfarm.crop.TomatoPlant;
import com.zipcodewilmington.froilansfarm.edible.Tomato;
import com.zipcodewilmington.froilansfarm.storage.ChickenCoop;
import com.zipcodewilmington.froilansfarm.storage.Farm;
import com.zipcodewilmington.froilansfarm.storage.FarmHouse;
import com.zipcodewilmington.froilansfarm.storage.Stable;
import com.zipcodewilmington.froilansfarm.storage.field.CropRow;
import com.zipcodewilmington.froilansfarm.storage.field.Field;
import com.zipcodewilmington.froilansfarm.vehicle.CropDuster;
import com.zipcodewilmington.froilansfarm.vehicle.Tractor;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by leon on 2/26/18.
 */
public class FroilanFarm {

    private Farm farm;
    private Farmer froilan;
    private Farmer froilanda;

    public Farm getFarm() {
        return farm;
    }

    //Construct the farm
    public FroilanFarm() {

        farm = new Farm();
        addFieldToFarm(farm);
        addChickenCoopToFarm(farm);
        addStablesToFarm(farm);
        addVehiclesToFarm(farm);
        addFarmHouseToFarm(farm);

    }

    private void addVehiclesToFarm(Farm farm) {
        farm.addVehicles(new CropDuster());
        farm.addVehicles(new Tractor());
        farm.addVehicles(new Tractor());
    }

    private void addFarmHouseToFarm(Farm farm) {
        froilan = new Farmer(farm);
        froilanda = new Farmer(farm);

        farm.addFarmerToFarm(froilan);
        farm.addFarmerToFarm(froilanda);
    }

    private void addFieldToFarm(Farm farm) {
        Field field = new Field();

        farm.CreateCropRowInField(CornStalk::new, 5);
        farm.CreateCropRowInField(TomatoPlant::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
        farm.CreateCropRowInField(GenericVegetation::new, 5);
    }
    private void addChickenCoopToFarm(Farm farm) {
        farm.addChickenCoopToFarm(ChickenCoop::new, Chicken::new, 4, 15);
    }

    private void addStablesToFarm(Farm farm) {
        farm.addStablesToFarm(Stable::new, Horse::new,3, 10);
    }

    public Farmer getFroilan() {
        return froilan;
    }
    public Farmer getFroilanda() {
        return froilanda;
    }

    public void rideHorse() {
        List<Person> farmerList = farm.getFarmHouse().getFarmers();
        farmerList.forEach(person -> {
            if(person instanceof Farmer) {
                for (Horse horse : farm.getHorses()) {
                    ((Farmer) person).mount(horse);
                    ((Farmer) person).dismount(horse);
                }
            }
        });
    }
}