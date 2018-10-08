package by.it.galushka.demo.exceptions;

public class ExceptionsDemo {

    public static void main(String[] args) {
        int[] array = new int[3];
        try{
            int res= array[3];
        }catch (Exception e){
            System.out.println(e.getClass().getSimpleName());
//            Throwable[] stackTrace = e.;
//            for (int i = 0; i < stackTrace.length; i++) {
//                System.out.println(i+": "+stackTrace[i].toString());
//            }
        }
    }
}
