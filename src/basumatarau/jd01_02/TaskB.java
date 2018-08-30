package basumatarau.jd01_02;
import java.util.*;

public class TaskB {
    public static void main(String[] args) {

        step1();

        Scanner scanner = new Scanner(System.in);
        System.out.println("");

        step2(scanner.nextInt());
        System.out.println("");
        double a, b, c = 0.0;
        String str = scanner.nextLine();
        String strArr[] = (str.trim().split(" "));

        a = Double.parseDouble(strArr[0]);
        b = Double.parseDouble(strArr[1]);
        c = Double.parseDouble(strArr[2]);

        step3(a, b, c);
    }

    public static void step1(){
        int num = 0;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.print(Integer.toString(++num)+" ");
            }
            System.out.println('\n');
        }
    }

    public static void step2(int month){
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default:{
                System.out.println("нет такого месяца");
                break;
            }
        }
    }

    public static void step3(double a, double b, double c){

        double discr = Math.pow(b, 2.0) - 4*(a*c);

        if (discr<0){
            System.out.println("корней нет");
        }
        else if (discr == 0){
            System.out.println(b/((-2.0)*a));
        }
        else {
            System.out.print(Double.toString((b - Math.sqrt(discr))/((-2.0)*a)));
            System.out.print(" ");
            System.out.print(Double.toString((b + Math.sqrt(discr))/((-2.0)*a)));
        }
    }
}
