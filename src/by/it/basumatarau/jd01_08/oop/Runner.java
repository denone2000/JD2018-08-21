package by.it.basumatarau.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        SourceOfLight defaultSourceOfLight = new DeskLamp();
        SourceOfLight someSourceOfLight = new DeskLamp(Lamp.LightBulbColor.BLUE);
        SourceOfLight anotherSourceOfLight = new DeskLamp(Lamp.LightBulbColor.GREEN, 80, true);

        defaultSourceOfLight.turnOn();
        someSourceOfLight.turnOn();
        anotherSourceOfLight.turnOn();

        ((DeskLamp)someSourceOfLight).setLightBulbColor(Lamp.LightBulbColor.RED);

        for (int i = 0; i < 3; i++) {
            ((DeskLamp)someSourceOfLight).goBrighter();
        }
        ((DeskLamp)someSourceOfLight).goDarker();

        defaultSourceOfLight.turnOff();
        someSourceOfLight.turnOff();
        anotherSourceOfLight.turnOff();
    }
}
