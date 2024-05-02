package dtos;

import models.VehicleType;

public class IssueTicketRequestDto {
    private long gateID;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;

    public long getGateID() {
        return gateID;
    }

    public void setGateID(long gateID) {
        this.gateID = gateID;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
