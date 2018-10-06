package by.it.galushka.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {

    @Test
    public void scalarAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "2+2";
        Var var1 = parser.calc(expression);
        assertEquals("4.0", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
    }

    @Test
    public void scalarSub() throws CalcException {
        Parser parser = new Parser();
        String expression = "4-2";
        Var var1 = parser.calc(expression);
        assertEquals("2.0", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
    }

    @Test
    public void scalarMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "3*4";
        Var var1 = parser.calc(expression);
        assertEquals("12.0", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
    }

    @Test
    public void scalarDiv() throws CalcException {
        Parser parser = new Parser();
        String expression = "12/4";
        Var var1 = parser.calc(expression);
        assertEquals("3.0", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
    }

    @Test
    public void vectorAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3} + {4,5,6}";
        Var var1 = parser.calc(expression);
        assertEquals("{5.0, 7.0, 9.0}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{1,2,3} + 1.0";
        Var var2 = parser.calc(expression);
        assertEquals("{2.0, 3.0, 4.0}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
    }

    @Test
    public void vectorSub() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3} - {4,5,6}";
        Var var1 = parser.calc(expression);
        assertEquals("{-3.0, -3.0, -3.0}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{1,2,3} - 1.0";
        Var var2 = parser.calc(expression);
        assertEquals("{0.0, 1.0, 2.0}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
    }

    @Test
    public void vectorMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3} * {4,5,6}";
        Var var1 = parser.calc(expression);
        assertEquals("32.0", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{1,2,3} * 2.0";
        Var var2 = parser.calc(expression);
        assertEquals("{2.0, 4.0, 6.0}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
    }

    @Test
    public void vectorDiv() throws CalcException {
        Parser parser = new Parser();
        String expression = "{1,2,3} / 2.0";
        Var var1 = parser.calc(expression);
        assertEquals("{0.5, 1.0, 1.5}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
    }

    @Test
    public void matrixAdd() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{1, 2}, {3, 4}} + {{4, 5}, {7, 8}}";
        Var var1 = parser.calc(expression);
        assertEquals("{{5.0, 7.0}, {10.0, 12.0}}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{{1, 2}, {3, 4}} + 1.0";
        Var var2 = parser.calc(expression);
        assertEquals("{{2.0, 3.0}, {4.0, 5.0}}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
    }

    @Test
    public void matrixSub() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{1, 2}, {3, 4}} - {{4, 5}, {7, 8}}";
        Var var1 = parser.calc(expression);
        assertEquals("{{-3.0, -3.0}, {-4.0, -4.0}}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{{1, 2}, {3, 4}} - 1.0";
        Var var2 = parser.calc(expression);
        assertEquals("{{0.0, 1.0}, {2.0, 3.0}}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
    }

    @Test
    public void matrixMul() throws CalcException {
        Parser parser = new Parser();
        String expression = "{{1, 2}, {3, 4}} * {{4, 5}, {7, 8}}";
        Var var1 = parser.calc(expression);
        assertEquals("{{18.0, 21.0}, {40.0, 47.0}}", var1.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var1);
        System.out.println("------------------------------");
        expression = "{{1, 2}, {3, 4}} * {5, 6}";
        Var var2 = parser.calc(expression);
        assertEquals("{17.0, 39.0}", var2.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var2);
        System.out.println("------------------------------");
        expression = "{{1, 2}, {3, 4}} * 2.0";
        Var var3 = parser.calc(expression);
        assertEquals("{{2.0, 4.0}, {6.0, 8.0}}", var3.toString());
        System.out.println("Ввод: " + expression
                + "\nРезультат: " + var3);
        System.out.println("------------------------------");
    }

    @Test
    public void expressTest() throws CalcException {
        Parser parser = new Parser();
        Var var1 = parser.calc("A=2+5.3");
        assertEquals("7.3", var1.toString());
        Var var2 = parser.calc("B=A*3.5");
        assertEquals("25.55", var2.toString());
        Var var3 = parser.calc("B1=B+0.11*-5");
        assertEquals("25.0", var3.toString());
        Var var4 = parser.calc("B2=A/2-1");
        assertEquals("2.65", var4.toString());
        Var var5 = parser.calc("C=B+(A*2)");
        assertEquals("40.15", var5.toString());
        Var var6 = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", var6.toString());
        Var var7 = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10.0, 15.0}", var7.toString());
        Var var8 = parser.calc("{{1,2},{8,3}}-2");
        assertEquals("{{-1.0, 0.0}, {6.0, 1.0}}", var8.toString());
        Var var9 = parser.calc("{{1,2},{8,3}}*{1,2}");
        assertEquals("{5.0, 14.0}", var9.toString());
        Var var10 = parser.calc("{{1,2},{8,3}}*{{1,2},{8,3}}");
        assertEquals("{{17.0, 8.0}, {32.0, 25.0}}", var10.toString());
        Var var11 = parser.calc("{{1,2},{8,3}}+{{1,2},{8,3}}");
        assertEquals("{{2.0, 4.0}, {16.0, 6.0}}", var11.toString());
    }
}