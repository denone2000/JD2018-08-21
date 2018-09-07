package by.it.basumatarau.jd01_08.oop;

public abstract class Lamp implements SourceOfLight {
    public enum LightBulbColor{
        WHITE, RED, GREEN, BLUE
    }
    private LightBulbColor color;

    /**
     * xCoordinate, yCoordinate and zCoordinate - are distances from power outlet to the instance of Lamp
     *
     **/
    private Location location;
    boolean isTurnedOn;
    int powerCapacity;

    public Lamp(){
        this.color = LightBulbColor.WHITE;
    }
    public Lamp (LightBulbColor color, Location location){
        this.color = color;
        this.location = new Location(location.xCoord, location.yCoord, location.zCoord);
    }

    protected double getDistanceToPowerOutlet(){
        if (this.location!=null){
        return Math.sqrt(Math.pow(location.xCoord, 2.0)+ Math.pow(location.yCoord, 2.0)+ Math.pow(location.zCoord, 2.0));
        }else return 1.5f;
    }

    @Override
    public void move(Location anotherLocation) {
        location = new Location(anotherLocation.xCoord, anotherLocation.yCoord, anotherLocation.zCoord);
    }

    public void setLightBulbColor (LightBulbColor color){
        System.out.println("Lamp's light bulb is being changed from " + this.color + " to " + color);
        this.color = color;
    }

    @Override
    public void turnOn(){
        isTurnedOn = true;
        System.out.println("Lamp is being turned on...");
    }
    @Override
    public void turnOff(){
        isTurnedOn = false;
        System.out.println("Lamp is being turned off...");
    }

    abstract public void goBrighter();
    abstract public void goDarker();
}
