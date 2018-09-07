package by.it.basumatarau.jd01_08.oop;

public interface SourceOfLight {
    /**
     * xCoord, yCoord and zCoord - are respective projections of distances from the power outlet to the instance of SourceOfLight
     *
     **/
    class Location{
        public double xCoord;
        public double yCoord;
        public double zCoord;
        public Location(double x, double y, double z){
            xCoord = x;
            yCoord = y;
            zCoord = z;
        }
    }
    void turnOn();
    void turnOff();
    void move(Location anotherLocation);
}
