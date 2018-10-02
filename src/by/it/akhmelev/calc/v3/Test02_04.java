package by.it.akhmelev.calc.v3;

import by.it.akhmelev.calc.v3.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {
    @Test
    public void testAdd() throws Exception {
        by.it.akhmelev.calc.v3.Parser parser = new by.it.akhmelev.calc.v3.Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0",var.toString());
    }

    @Test
    public void testSub() throws Exception {
        by.it.akhmelev.calc.v3.Parser parser = new by.it.akhmelev.calc.v3.Parser();
        Var var = parser.calc("2-3");
        assertEquals("-1.0",var.toString());
    }


    @Test
    public void testExpression() throws Exception {
        by.it.akhmelev.calc.v3.Parser parser = new by.it.akhmelev.calc.v3.Parser();
        Var var = parser.calc("A=2+3*4");
        assertEquals("14.0",var.toString());
    }

}