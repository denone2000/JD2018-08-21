package by.it.artemliashkov.jd02_04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test_jd02_04 {

    @Test
    public void scalarAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("2+2");
        assertEquals("4.0", var.toString());
    }



    @Test
    public void scalarMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("3.5*2");
        assertEquals("7.0", var.toString());
    }

    @Test
    public void scalarSubScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("22.5-1.5");
        assertEquals("21.0", var.toString());
    }

    @Test
    public void scalarDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("9/3");
        assertEquals("3.0", var.toString());
    }

    @Test
    public void vectorAddScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1,2}+2");
        assertEquals("{3.0, 4.0}", var.toString());

    }

    @Test
    public void vectorMulScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1,2}*3");
        assertEquals("{3.0, 6.0}", var.toString());
    }

    @Test
    public void vectorSubScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{5,6,7}-1");
        assertEquals("{4.0, 5.0, 6.0}", var.toString());
    }

    @Test
    public void vectorDivScalar() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1,2}/4");
        assertEquals("{0.25, 0.5}", var.toString());
    }

    @Test
    public void vectorAddVector() throws Exception {
        Parser parser = new Parser();
        assertEquals("{7.0, 9.0, 11.0}", parser.calc("{2,3,4}+{5,6,7}").toString());

    }

    @Test
    public void vectorMulVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{1,2}*{3,4}");
        assertEquals("11.0", var.toString());
    }

    @Test
    public void vectorSubVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{5,6,7}-{2,3,4}");
        assertEquals("{3.0, 3.0, 3.0}", var.toString());
    }


    @Test
    public void matrixMulVector() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{1,2},{8,3}}*{1,2}");
        assertEquals("{5.0, 14.0}", var.toString());
    }

    @Test
    public void matrixAddMatrix() throws Exception {
        Parser parser = new Parser();
        assertEquals("{{4.0, 7.0}, {9.0, 7.0}}", parser.calc("{{3,5},{1,4}}+{{1,2},{8,3}}").toString());

    }

    @Test
    public void matrixMulMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{1,2},{8,3}}*{{2,5},{7,2}}");
        assertEquals("{{16.0, 9.0}, {37.0, 46.0}}", var.toString());
    }

    @Test
    public void matrixSubMatrix() throws Exception {
        Parser parser = new Parser();
        Var var = parser.calc("{{4,5},{9,7}}-{{1,2},{8,3}}");
        assertEquals("{{3.0, 3.0}, {1.0, 4.0}}", var.toString());
    }


}
