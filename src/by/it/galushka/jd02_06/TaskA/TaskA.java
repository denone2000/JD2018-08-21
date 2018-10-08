package by.it.galushka.jd02_06.TaskA;

public class TaskA {

    private static MySingleton logger = MySingleton.getMySingleton();

    public static void main(String[] args) {
        logger.log("ERROR!!!");
        getExeption();
    }

    private static void getExeption() {
        String[] array = new String[3];
        try {
            String str = array[3];
            System.out.println(str);
        } catch (Exception e) {
            String message = e.toString();
            logger.log(message);
        }
    }
}
