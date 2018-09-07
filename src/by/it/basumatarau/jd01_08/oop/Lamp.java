package by.it.basumatarau.jd01_08.oop;

public abstract class Lamp implements SourceOfLight {
    public enum LightBulbColor{
        WHITE, RED, GREEN, BLUE
    }
    public Lamp(){
        this.color = LightBulbColor.WHITE;
    }
    public Lamp (LightBulbColor color){
        this.color = color;
    }
    private LightBulbColor color;
    protected boolean isTurnedOn;
    protected int powerCapacity;

    public void setLightBulbColor (LightBulbColor color){
        System.out.println("Lamp's light bulb is being changed from " + this.color + " to " + color);
        this.color = color;
    }

    @Override
    public void turnOn(){
        System.out.println("");
        isTurnedOn = true;
    }
    @Override
    public void turnOff(){
        isTurnedOn = false;
    }

    abstract public void goBrighter();
    abstract public void goDarker();
}
