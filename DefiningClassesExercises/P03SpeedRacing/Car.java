package DefiningClassesExercises.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostFor1Kilometer;
    private int distanceTravel;


    public Car(String model, int fuelAmount, double fuelCostFor1Kilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1Kilometer = fuelCostFor1Kilometer;
        this.distanceTravel = distanceTravel;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostFor1Kilometer() {
        return fuelCostFor1Kilometer;
    }

    public int getDistanceTravel() {
        return distanceTravel;
    }
    public boolean drive(int kmDrive){
        // 1. нужно количечство гориво, за да преминем дадените км (kmDrive)
        double needFuel = kmDrive*this.fuelCostFor1Kilometer;
        if (needFuel<=this.fuelAmount){
            //можем да изминем разстоянието
            this.fuelAmount-=needFuel;
            this.distanceTravel+=kmDrive;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuelAmount,this.distanceTravel);

    }
}
