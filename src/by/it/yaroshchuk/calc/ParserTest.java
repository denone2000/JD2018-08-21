package by.it.yaroshchuk.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0", var.toString());
    }

    @Test
    public void testSubScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("8-2");
        assertEquals("6.0", var.toString());
    }

    @Test
    public void testMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("3*2");
        assertEquals("6.0", var.toString());
    }

    @Test
    public void testDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("15/3");
        assertEquals("5.0", var.toString());
    }
    
    @Test
    public void testAddVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,3.5}+{1.5,6.5}");

        assertEquals("{3.5,10.0}", var.toString());
    }

    @Test
    public void testAddVectorScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,3.5}+2");
        assertEquals("{4.0,5.5}", var.toString());
    }

    @Test
    public void testSubVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,6.5}-{1.5,3.5}");
        assertEquals("{0.5,3.0}", var.toString());
    }

    @Test
    public void testSubVectorScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,3.5}-2");
        assertEquals("{0.0,1.5}", var.toString());
    }

    @Test
    public void testMulVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2,3}*{1,6}");
        assertEquals("20.0", var.toString());
    }

    @Test
    public void testMulVectorScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{2.0,3.5}*2");
        assertEquals("{4.0,7.0}", var.toString());
    }

    @Test
    public void testDivVectorScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{4,6}/2");
        assertEquals("{2.0,3.0}", var.toString());
    }

    @Test
    public void testAddMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2.0,3.5},{1.5,6.5}}+{{2.0,3.5},{1.5,6.5}}");
        assertEquals("{{4.0,7.0},{3.0,13.0}}", var.toString());
    }

    @Test
    public void testSubMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{2.0,3.5},{1.5,6.5}}-{{1.0,2.0},{0.5,4.5}}");
        assertEquals("{{1.0,1.5},{1.0,2.0}}", var.toString());
    }

}