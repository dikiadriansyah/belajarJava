public class Car3 {
    // Variables describing the characteristics of an individual car, varies per
    // object
    private int milesPerGallon;
    private String name;
    private String color;
    public int numGallonsInTank;

    public Car3() {
        milesPerGallon = 0;
        name = "";
        color = "";
        numGallonsInTank = 0;
    }

    // ----------------------
    // public void Car() {
    // milesPerGallon = 0;
    // name = "";
    // color = "";
    // numGallonsInTank = 0;
    // }
    // ----------------------

    // this is where an individual object is created
    public Car3(int mpg, int gallonsInTank, String carName, String carColor) {
        milesPerGallon = mpg;
        name = carName;
        color = carColor;
        numGallonsInTank = gallonsInTank;
    }

    // methods to make the object more usable
    // Cars need to drive
    public void drive(int distanceInMiles) {
        // get miles left in car
        int miles = numGallonsInTank * milesPerGallon;

        // check that car has enough gas to drive distanceInMiles
        if (miles <= distanceInMiles) {
            numGallonsInTank = numGallonsInTank - (distanceInMiles / milesPerGallon);
            System.out.println("Drove " + numGallonsInTank + " miles!");
        } else {
            System.out.println("Could not drive!");
        }
    }

    public void paintCar(String newColor) {
        color = newColor;
    }

    // set new Miles Per Gallon
    public void setMPG(int newMPG) {
        milesPerGallon = newMPG;
    }

    // set new number of Gallon In Tank
    public void setGallonsInTank(int numGallons) {
        numGallonsInTank = numGallons;
    }

    public void nameCar(String newName) {
        name = newName;
    }

    // Get the Car color
    public String getColor() {
        return color;
    }

    // Get the Car name
    public String getName() {
        return name;
    }

    // Get the number of Gallons
    public int getGallons() {
        return numGallonsInTank;
    }

}
