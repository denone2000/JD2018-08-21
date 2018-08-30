package by.it.basumatarau.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step1(0.0, 2.0, 0.2);
        step2(-6.0, 2.0, 0.5);
        System.out.println(Math.log(Math.abs(-1.0+2.74)));
    }

    private static void step1(double lowerLim, double upperLim, double delta) {
        double sum = 0.0;
        for (int i = 0; i <= (upperLim-lowerLim)/delta; i++) {
            for (int x = 1; x <= 6; x++) {
                sum+=Math.pow(7.0, lowerLim + i*delta)-Math.cos(x);
            }
            System.out.printf("При a=%-3.1f Сумма y = %e%n", lowerLim + delta*i, sum);
            sum = 0;
        }
    }

    private static void step2(double lowerLim, double upperLim, double delta) {
        for (int i = 1; i < (upperLim-lowerLim)/delta ; i++) {
            if(-2.0 < (lowerLim+i*delta)/2.0 && (lowerLim+i*delta)/2.0 <=-1){
                System.out.printf("При x/2=%-4.2f α= %e%n", (lowerLim + delta*i)/2.0, Math.log(Math.abs(Math.sin(Math.pow(lowerLim+i*delta,2.0))+2.74)));
            }else if(-1 <= (lowerLim+i*delta)/2.0 && (lowerLim+i*delta)/2.0 < 0.2) {
                System.out.printf("При x/2=%-4.2f α= %e%n", (lowerLim + delta*i)/2.0, Math.log(Math.abs(Math.cos(Math.pow(lowerLim+i*delta,2.0))+2.74)));
            }else if((lowerLim+i*delta)/2.0 == 0.2){
                System.out.printf("При x/2=%-4.2f α= %e%n", (lowerLim + delta*i)/2.0, Math.log(Math.abs((1.0/Math.tan(Math.pow(lowerLim+i*delta,2.0)))+2.74)));
            }else System.out.printf("При x/2=%-4.2f вычисления не определены%n", (lowerLim + delta*i)/2.0);
        }
    }
}
