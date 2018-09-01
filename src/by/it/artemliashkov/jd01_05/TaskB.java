package by.it.artemliashkov.jd01_05;

public class TaskB {
    public   static void main(String args[])
    {
        step1();
        step2();
    }

    public static void step1()
    {
        double y[]=new double[11];
        double r[]=new double[11];
        int i=0;
        double res=0.0;
        for(double a=0;a<=2;a=a+0.2)
        {
            for (int k = 1; k <=6 ; k++) {
                r[k]=Math.pow(7,a)-Math.cos(k);
                res=res+r[k];
                if(k==6)
                {
                    y[i]=res;
                    res=0;
                }
            }
            i++;
        }
        for (int j = 0; j < 11; j++) {
            System.out.printf("При a=%6.2f Сумма y=%g",j*0.2,y[j]);
            System.out.println();
        }
    }

    public static void step2()
    {
        double y[]=new double[15];
        double b=0.0;
        int i=0;
        boolean isTrue=false;
        for(double a=-2.75;a<=0.75;a=a+0.25)
        {
            isTrue=false;
            if((a>-2)&&(a<=-1))
            {
                isTrue=true;
                b=Math.sin(Math.pow(a,2));
            }
            if((a>-1)&&(a<0.2))
            {
                isTrue=true;
                b=Math.cos(Math.pow(a,2));
            }
            if(a==0.2)
            {
                isTrue=true;
                b=1/Math.tan(Math.pow(a,2));
            }
            if(isTrue) {
                y[i] = Math.abs(Math.log10(b) + 2.74);
                System.out.printf("При a=%6.2f y=%g",a,y[i]);
                System.out.println();
            }
            else {
                System.out.printf("При a=%6.2f результат не определен", a);
                System.out.println();
            }
            i++;
        }
    }
}
