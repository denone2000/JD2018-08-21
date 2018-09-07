package by.it.basumatarau.jd01_08.oop;

public abstract class Lamp implements SourceOfLight {
    public enum LampColor{
        WHITE, RED, GREEN, BLUE
    }
    private LampColor color;
    protected boolean isTurnedOn;
    protected int powerCapacity;

    public void changeColor(LampColor color){
        this.color = color;
    }

    @Override
    public void turnOn(){
        isTurnedOn = true;
    }
    @Override
    public void turnOff(){
        isTurnedOn = false;
    }

    abstract public void goBrighter();
    abstract public void goDarker();
}
