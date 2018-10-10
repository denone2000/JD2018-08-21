package by.it.bindyuk.jd02_06.calcV3;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @org.junit.Test
    public void ScalarAdd() throws Exception {
        Parser parser = new Parser();
        String expression = "A=2+5.3";
        String res = parser.calc(expression).toString();
        String control = "7.3";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void ScalarMul() throws Exception {
        Parser parser = new Parser();
        String expression = "B=A*3.5";
        String res = parser.calc(expression).toString();
        String control = "25.55";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void ScalarSub() throws Exception {
        Parser parser = new Parser();
        String expression = "B1=B+0.11*-5";
        String res = parser.calc(expression).toString();
        String control = "25.0";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void ScalarDiv() throws Exception {
        Parser parser = new Parser();
        String expression = "B2=A/2-1";
        String res = parser.calc(expression).toString();
        String control = "2.65";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void vectorAdd() throws Exception {
        Parser parser = new Parser();
        String expression = "{1,2}+{3,4}";
        String res = parser.calc(expression).toString();
        String control = "{4.0, 6.0}";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void vectorSub() throws Exception {
        Parser parser = new Parser();
        String expression = "{3,4}-{1,2}";
        String res = parser.calc(expression).toString();
        String control = "{2.0, 2.0}";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void vectorMul() throws Exception {
        Parser parser = new Parser();
        String expression = "{3,4}*{1,2}";
        String res = parser.calc(expression).toString();
        String control = "11.0";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void vectorDiv() throws Exception {
        Parser parser = new Parser();
        String expression = "{3,4}/2";
        String res = parser.calc(expression).toString();
        String control = "{1.5, 2.0}";
        assertEquals(res, control);
    }
}