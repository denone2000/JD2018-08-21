package by.it.litvin.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void scalarAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0", var.toString());
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("4-2");
        assertEquals("2.0", var.toString());
    }

    @Test
    public void scalarMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2*3");
        assertEquals("6.0", var.toString());
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("6/2");
        assertEquals("3.0", var.toString());
    }


    @Test
    public void vectorAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1.0,2.0,3.0}+1");
        assertEquals("{2.0, 3.0, 4.0}", var.toString());
    }

    @Test
    public void vectorMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1.0,2.0,3.0}*2");
        assertEquals("{2.0, 4.0, 6.0}", var.toString());

    }

    @Test
    public void vectorDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,4.0,6.0}/2");
        assertEquals("{1.0, 2.0, 3.0}", var.toString());
    }

    @Test
    public void vectorAddVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1.0,2.0,3.0}+{1.0,2.0,3.0}");
        assertEquals("{2.0, 4.0, 6.0}", var.toString());
    }

    @Test
    public void vectorSubVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("6/2");
    }

}