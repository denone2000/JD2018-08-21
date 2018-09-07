package by.it.basumatarau.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        SourceOfLight someSourceOfLight = new DeskLamp(Lamp.LightBulbColor.BLUE);
        someSourceOfLight.turnOn();

        ((DeskLamp)someSourceOfLight).setLightBulbColor(Lamp.LightBulbColor.RED);

        ((DeskLamp)someSourceOfLight).goBrighter();

        someSourceOfLight.turnOff();
    }
}
