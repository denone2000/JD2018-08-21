package by.it.nesterovich.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04 {

    @Test
    public void scalarAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0", var.toString());
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("22.5-0.5");
        assertEquals("22.0", var.toString());
    }

    @Test
    public void scalarMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2*-2");
        assertEquals("-4.0", var.toString());
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("-6/-2");
        assertEquals("3.0", var.toString());
    }
}