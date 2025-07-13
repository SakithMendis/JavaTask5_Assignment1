package main;

public class Truck extends Vehicle{

    private int bedLength;
    private double payloadCapacity;

    public Truck(String make, String model, String color, int year, double price,int bedLength, double payloadCapacity) {
        super(make, model, color, year, price);
        this.bedLength = bedLength;
        this.payloadCapacity = payloadCapacity;
    }
    public int getBedLength() {
        return bedLength;
    }
    public void setBedLength(int bedLength) {
        this.bedLength = bedLength;
    }
    public double getPayloadCapacity() {
        return payloadCapacity;
    }
    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }
}
