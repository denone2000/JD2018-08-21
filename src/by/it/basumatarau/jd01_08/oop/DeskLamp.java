package by.it.basumatarau.jd01_08.oop;

public class DeskLamp extends Lamp {
    private boolean isPluggedIn;
    private boolean isOnDesk;
    private byte brightness;
    private static int counter=1;
    private final int ID = counter++;
    private final double POWER_CABLE_LENGTH = getDistanceToPowerOutlet();

    public DeskLamp(){
        super();
        isTurnedOn = false;
        powerCapacity = 40;
        isPluggedIn = false;
        isOnDesk = false;
        brightness = 50;
        System.out.println("DeskLamp#"+ID+" of default configuration has been instantiated");
    }
    public DeskLamp(LightBulbColor color, Location location){
        super(color, location);
        isTurnedOn = false;
        powerCapacity = 40;
        isPluggedIn = false;
        isOnDesk = false;
        brightness = 50;
        System.out.println("DeskLamp#"+ID+" with a light bulb of " + color + " color has been instantiated");
    }
    public DeskLamp(LightBulbColor color, Location location, int capacity, boolean isTurnedOn){
        this(color, location);
        isOnDesk = true;
        isPluggedIn = true;
        this.isTurnedOn = isTurnedOn;
        powerCapacity = capacity;
        System.out.println("DeskLamp#"+ID+" with light bulb of " +color +" color, " +capacity+" W power capacity has been instantiated" + (isTurnedOn?"(and it's already turned on)": "(and it's turned off)"));
    }
    @Override
    public void move(Location anotherLocation) {
        System.out.println("Trying to move the DeskLamp#"+ID+" to another place");
        if(POWER_CABLE_LENGTH<Math.sqrt(Math.pow(anotherLocation.xCoord, 2.0)+ Math.pow(anotherLocation.yCoord, 2.0)+ Math.pow(anotherLocation.zCoord, 2.0))){
            System.out.println("Power cable is too short to move the DeskLamp#"+ID+" that far from the power outlet");
        }else {
            super.move(anotherLocation);
            System.out.println("DeskLamp#"+ID+" has been moved to another location successfully");
        }
    }
    @Override
    public void setLightBulbColor(LightBulbColor color){
        System.out.println("Before changing the light bulb of the DeskLamp#"+ID+" for another one of " + color + " color the Lamp must be turned off");
        this.turnOff();
        super.setLightBulbColor(color);
        System.out.println("After the light bulb has been changed the DeskLamp#"+ID+" is turned on");
        this.turnOn();
    }
    @Override
    public void goBrighter(){
        if(this.brightness>=100){
            System.out.println("DeskLamp#"+ID+" is already at full brightness");
        }else{
            this.brightness+=10;
            System.out.println("DeskLamp#"+ID+" brightness has been set at " + brightness+"%");
        }
    }
    @Override
    public void goDarker(){
        if(this.brightness<=0){
            System.out.println("DeskLamp#"+ID+" is already at minimum brightness");
        }else{
            this.brightness-=10;
            System.out.println("DeskLamp#"+ID+" brightness has been set at " + brightness+"%");
        }
    }
    @Override
    public void turnOff() {
        super.turnOff();
        if(isPluggedIn) {isPluggedIn=false;}
        System.out.println("DescLamp#"+ID+" has been turned off and unplugged");
    }
    @Override
    public void turnOn() {
        if(!isOnDesk) {isOnDesk=true;}
        if(!isPluggedIn) {isPluggedIn=true;}
        System.out.println("DescLamp#"+ID+" is going to be turned on (it has been plugged in and installed on table)");
        super.turnOn();
    }
}
