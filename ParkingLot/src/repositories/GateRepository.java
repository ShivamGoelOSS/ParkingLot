package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Optional;

public class GateRepository {
    private HashMap<Long, Gate> gates=new HashMap<>();
    public Optional<Gate> findById(Long gateId){
        if(gates.containsKey(gateId)){
            return Optional.of(gates.get(gateId));
        }
        else{
            return Optional.empty();
        }
    }
}
