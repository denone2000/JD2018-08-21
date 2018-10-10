package by.it.korzik.jd01.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    private static void step1() {
        double[] arr = new double[30];
        double iter = (9.0 - 5.33) / 30;
        System.out.println("Массив A[]");
        for (int v = 0; v < arr.length; v++) {
            arr[v] =iter*v+5.33;
            for (int i = 0; i < 5; i++) {
            }
        }
        for (int v = 0; v < arr.length; v++) {
                System.out.printf("A[% -3d] = %-9.5f", v, arr[v]);
                int x=0;x++;
                if (x==5){x=0;
                    System.out.println();}
        }
        System.out.println();
    }

}
