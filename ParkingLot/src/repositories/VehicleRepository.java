package repositories;

import models.User;
import models.Vehicle;
import models.VehicleType;

import java.util.HashMap;
import java.util.Optional;

public class VehicleRepository {
    private HashMap<String, Vehicle> vehicles=new HashMap<>();
    public Optional<Vehicle> findByNumber(String id){
        if(vehicles.containsKey(id)){
            return Optional.of(vehicles.get(id));
        }
        else{
            Vehicle vehicle=new Vehicle();
            vehicles.put(id,vehicle);
            return Optional.of(vehicle);
        }
    }
    public Optional<Vehicle> createVehicle(String number, VehicleType vehicleType, String ownerName){
        Vehicle vehicle =new Vehicle();
        vehicle.setVehicleType(vehicleType);
        User owner=new User();
        owner.setName(ownerName);
        vehicle.setOwner(owner);
        vehicle.setVehicleNumber(number);
        vehicles.put(number,vehicle);
        return Optional.of(vehicle);
    }
}
