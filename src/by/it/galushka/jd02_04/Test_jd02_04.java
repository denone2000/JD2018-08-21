package by.it.galushka.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {

    @Test
    public void testAll() throws CalcException {
        Parser parser = new Parser();
        Var var1 = (Var) parser.calc("A=2+5.3");
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