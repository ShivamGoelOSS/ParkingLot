package services;

import exceptions.InvalidGateException;
import models.*;
import repositories.GateRepository;
import repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    public TicketService(GateRepository gateRepository){
        this.gateRepository=gateRepository;
        this.vehicleRepository=vehicleRepository;
    }
    public Ticket issueTicket(Long GateID, VehicleType vehicleType, String vehicleNumber, String ownerName) throws InvalidGateException {
        Ticket ticket=new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setTicketStatus(TicketStatus.OPEN);
        Optional<Gate> optionalGate=gateRepository.findById(GateID);
        if(optionalGate.isEmpty()){
            throw new InvalidGateException("Invalid Gate ID");
        }
        ticket.setGeneratedAt(optionalGate.get());
        Optional<Vehicle> optionalVehicle=vehicleRepository.findByNumber(vehicleNumber);
        if(optionalVehicle.isEmpty()){
            optionalVehicle =vehicleRepository.createVehicle(vehicleNumber,vehicleType,ownerName);
        }
        ticket.setVehicle(optionalVehicle.get());
        return ticket;
    }
}
