public class SearchCar {
    private String pickUpLocation;
    private String pickUpDate;
    private String pickUpTime;
    private String dropOffLocation;
    private String dropOffDate;
    private String dropOffTime;

    public SearchCar(String pickUpLocation, String pickUpDate, String pickUpTime, String dropOffLocation, String dropOffDate, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.dropOffLocation = dropOffLocation;
        this.dropOffDate = dropOffDate;
        this.dropOffTime = dropOffTime;
    }

    public SearchCar(String pickUpLocation, String pickUpDate, String pickUpTime, String dropOffDate, String dropOffTime) {
        this.pickUpLocation = pickUpLocation;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.dropOffDate = dropOffDate;
        this.dropOffTime = dropOffTime;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public String getDropOffTime() {
        return dropOffTime;
    }
}
