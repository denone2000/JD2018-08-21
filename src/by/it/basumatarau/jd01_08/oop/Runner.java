package by.it.basumatarau.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
        SourceOfLight defaultSourceOfLight = new DeskLamp();
        SourceOfLight someSourceOfLight = new DeskLamp(Lamp.LightBulbColor.BLUE, new SourceOfLight.Location(2.0,2.0, 1.5));
        SourceOfLight anotherSourceOfLight = new DeskLamp(Lamp.LightBulbColor.GREEN, new SourceOfLight.Location(2.0, 2.0, 1.5), 80, true);

        defaultSourceOfLight.turnOn();
        someSourceOfLight.turnOn();
        anotherSourceOfLight.turnOn();
        defaultSourceOfLight.move(new SourceOfLight.Location(1.5,1.5,1.5));
        someSourceOfLight.move(new SourceOfLight.Location(1.5,1.5,1.5));
        anotherSourceOfLight.move(new SourceOfLight.Location(1.5,1.5,1.5));

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
