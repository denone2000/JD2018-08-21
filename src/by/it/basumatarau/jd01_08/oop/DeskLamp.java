package by.it.basumatarau.jd01_08.oop;

public class DeskLamp extends Lamp {
    private boolean isPluggedIn;
    private boolean isOnDesk;
    private float brightness;
    private static int counter=0;
    final int ID = counter++;

    public DeskLamp(){
        super();
        isTurnedOn = false;
        powerCapacity = 40;
        isPluggedIn = false;
        isOnDesk = false;
        brightness = 0.5f;
        System.out.println("DeskLamp#"+ID+" of default configuration has been instantiated");
    }
    public DeskLamp(LightBulbColor color){
        super(color);
        isTurnedOn = false;
        powerCapacity = 40;
        isPluggedIn = false;
        isOnDesk = false;
        brightness = 0.5f;
        System.out.println("DeskLamp#"+ID+" with a lamp of " + color + " color has been instantiated");
    }
    public DeskLamp(LightBulbColor color, int capacity, boolean isTurnedOn){
        this(color);
        this.isOnDesk = true;
        this.isPluggedIn = true;
        this.isTurnedOn = isTurnedOn;
        this.powerCapacity = capacity;
        System.out.println("DeskLamp#"+ID+" with light bulb of " +color +"color, " +capacity+" W power capacity has been instantiated" + (isTurnedOn?"(and it's already turned on)": "(and it's turned off)"));
    }
    @Override
    public void setLightBulbColor(LightBulbColor color){
        System.out.println("Before changing the light bulb of the DeskLamp#"+ID+" for another one of " + color + " color the Lamp must be turned off");
        this.turnOff();
        super.setLightBulbColor(color);
        System.out.println("After changing the light bulb the DeskLamp#"+ID+" is turned on");
        this.turnOn();
    }

    @Override
    public void goBrighter(){
        if(this.brightness>=1.0){
            System.out.println("DeskLamp#"+ID+" is already at full brightness");
        }else{
            this.brightness+=0.1f;
            System.out.println("DeskLamp#"+ID+" brightness has been set at " + brightness);
        }
    }
    @Override
    public void goDarker(){
        if(this.brightness<=0.0f){
            System.out.println("DeskLamp#"+ID+" is already at minimum brightness");
        }else{
            this.brightness-=0.1f;
            System.out.println("DeskLamp#"+ID+" brightness has been set at " + brightness);
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
