package by.it.galushka.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {

    @Test
    public void AddScalar() throws CalcException {
        Parser parser = new Parser();
        Var var1 = parser.calc("A=2+5.3");
        assertEquals("7.3", var1.toString());
        System.out.println(var1.toString());
        Var var2 = parser.calc("B=A*3.5");
        assertEquals("25.55", var2.toString());
        System.out.println(var2.toString());
        Var var3 = parser.calc("B1=B+0.11*-5");
        System.out.println(var3.toString());
        assertEquals("25.0", var3.toString());
        Var var4 = parser.calc("B2=A/2-1");
        assertEquals("2.65", var4.toString());
        Var var5 = parser.calc("C=B+(A*2)");
        assertEquals("40.15", var5.toString());
        Var var6 = parser.calc("D=((C-0.15)-20)/(7-5)");
        assertEquals("10.0", var6.toString());
        Var var7 = parser.calc("E={2,3}*(D/2)");
        assertEquals("{10,15}", var7.toString());
    }
}