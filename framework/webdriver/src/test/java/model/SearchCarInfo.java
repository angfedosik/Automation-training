package model;

public class SearchCarInfo {
    private String pickUpLocation;
    private String pickUpDate;
    private String dropOffLocation;
    private String dropOffDate;

    public SearchCarInfo(String pickUpLocation, String pickUpDate, String dropOffLocation, String dropOffDate) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffLocation = dropOffLocation;
        this.dropOffDate = dropOffDate;
    }

    public SearchCarInfo(String pickUpLocation, String pickUpDate, String dropOffDate) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public SearchCarInfo(String pickUpDate, String dropOffDate){
        this.pickUpDate=pickUpDate;
        this.dropOffDate=dropOffDate;
    }
    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }
}
