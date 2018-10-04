package by.it.korolchuk.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {

    @Test
    public void testAddCalc(){
        Parser parser = new Parser();
        Var calc = parser.calc("2+2");
        assertEquals("4.0", calc.toString());
    }

    @Test
    public void testSubCalc(){
        Parser parser = new Parser();
        Var calc = parser.calc("2-2");
        assertEquals("0.0", calc.toString());
    }

    @Test
    public void testMulCalc() {
        Parser parser = new Parser();
        Var calc = parser.calc("2*2");
        assertEquals("4.0", calc.toString());
    }

    @Test
    public void testDivCalc() {
        Parser parser = new Parser();
        Var calc = parser.calc("2/2");
        assertEquals("1.0", calc.toString());
    }

    @Test
    public void testExpression() {
        Parser parser = new Parser();
        Var calc = parser.calc("A=2+2*-3/-2");
        assertEquals("5.0", calc.toString());
    }
}