package by.it.korolchuk.jd02_05.Calc_jd02_05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test02_04 {

    @Test
    public void testAdd(){
        Parser parser = new Parser();
        Var calc = parser.calc("2+2");
        assertEquals("4.0", calc.toString());
    }

    @Test
    public void testSub(){
        Parser parser = new Parser();
        Var calc = parser.calc("2-2");
        assertEquals("0.0", calc.toString());
    }

    @Test
    public void testMul() {
        Parser parser = new Parser();
        Var calc = parser.calc("2*2");
        assertEquals("4.0", calc.toString());
    }

    @Test
    public void testDiv() {
        Parser parser = new Parser();
        Var calc = parser.calc("2/2");
        assertEquals("1.0", calc.toString());
    }

    @Test
    public void testExpression() {
        Parser parser = new Parser();
        assertEquals("7.3", parser.calc("A=2+5.3").toString());
        assertEquals("25.55", parser.calc("B=A*3.5").toString());
        assertEquals("25.0", parser.calc("B1=B+0.11*-5").toString());
        assertEquals("2.65", parser.calc("B2=A/2-1").toString());
    }
}