package by.it.basumatarau.jd01_08.oop;

public class DeskLamp extends Lamp {
    private boolean isPlugged;
    private boolean isOnTheDesk;
    private float brightness;

    public DeskLamp(){
        System.out.println("DeskLamp default constructor");
        //this.color = LampColor.WHITE;
        super.changeColor(LampColor.WHITE);
        isTurnedOn = false;
        powerCapacity = 40;
        isPlugged = false;
        isOnTheDesk = false;
        brightness = 0.5f;
    }
    public DeskLamp(LampColor color){
        this();
        System.out.println("DeskLamp(LampColor color) constructor");
        //this.color = color;
        super.changeColor(LampColor.WHITE);
    }
    public DeskLamp(LampColor color, int capacity, boolean isTurnedOn){
        this(color);
        System.out.println("DeskLamp(LampColor color, int capacity, boolean isTurnedOn) constructor");
        this.isOnTheDesk = true;
        this.isPlugged = true;
        this.isTurnedOn = isTurnedOn;
        this.powerCapacity = capacity;
    }
    @Override
    public void changeColor(LampColor color){
        this.turnOff();
        super.changeColor(color);
        this.turnOn();
    }

    @Override
    public void goBrighter(){
        if(this.brightness>=1.0){
            System.out.println("Lamp is already set at full brightness");
        }else{
            this.brightness+=0.1f;
        }
    }
    @Override
    public void goDarker(){
        if(this.brightness<=0.0f){
            System.out.println("Lamp is already set at minimum brightness");
        }else{
            System.out.println("Lower brightness has been set to a Lamp");
            this.brightness-=0.1f;
        }
    }

    /*void playMusic(){
        System.out.println("Plays some music");
    }
    void playMusic(String songName){
        System.out.println("Plays "+ songName);
    }*/

    @Override
    public void turnOff() {
        super.turnOff();
        System.out.println("DescLamp has been turned off and unplugged");
        if(isPlugged) {isPlugged=false;}
    }
    @Override
    public void turnOn() {
        System.out.println("DescLamp is going to be turned on: and punt on the desk and plugged (if not)");
        if(!isOnTheDesk) {isOnTheDesk=true;}
        if(!isPlugged) {isPlugged=true;}
        if(!isTurnedOn) {isTurnedOn=true;}
        super.turnOn();
    }
}
