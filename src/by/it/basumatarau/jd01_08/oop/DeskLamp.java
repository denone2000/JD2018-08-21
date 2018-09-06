package by.it.basumatarau.jd01_08.oop;

public class DeskLamp extends Lamp {
    boolean isPlugged;
    boolean isOnTheDesk;

    public DeskLamp(){
        System.out.println("DeskLamp default constructor");
        this.color = LampColor.WHITE;
        isTurnedOn = false;
        powerCapacity = 40;
        isPlugged = false;
        isOnTheDesk = false;
    }
    public DeskLamp(LampColor color){
        this();
        System.out.println("DeskLamp(LampColor color) constructor");
        this.color = color;
    }
    public DeskLamp(LampColor color, int capacity, boolean isTurnedOn){
        this(color);
        System.out.println("DeskLamp(LampColor color, int capacity, boolean isTurnedOn) constructor");
        this.isOnTheDesk = true;
        this.isPlugged = true;
        this.isTurnedOn = isTurnedOn;
        this.powerCapacity = capacity;
    }
    void playMusic(){
        System.out.println("Plays some music");
    }
    void playMusic(String songName){
        System.out.println("Plays "+ songName);
    }

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
