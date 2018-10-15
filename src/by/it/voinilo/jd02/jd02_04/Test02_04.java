package by.it.voinilo.jd02.jd02_04;


import org.junit.Test;

import static org.junit.Assert.*;

public class Test02_04 {
    @Test
    public void testAdd() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0",var.toString());
    }

    @Test
    public void testSub() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2-3");
        assertEquals("-1.0",var.toString());
    }


    @Test
    public void testExpression() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("A=2+3*4");
        assertEquals("14.0",var.toString());
    }

}