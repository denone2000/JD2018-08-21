package by.it.bindyuk.jd02_04.calcV2;

import org.junit.Assert;

import static org.junit.Assert.*;

public class ParserTest {

    @org.junit.Test
    public void add() throws Exception {
        Parser parser = new Parser();
        String expression = "A=2+5.3";
        String res = parser.calc(expression).toString();
        String control = "7.3";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void mul() throws Exception {
        Parser parser = new Parser();
        String expression = "B=A*3.5";
        String res = parser.calc(expression).toString();
        String control = "25.55";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void sub() throws Exception {
        Parser parser = new Parser();
        String expression = "B1=B+0.11*-5";
        String res = parser.calc(expression).toString();
        String control = "25.0";
        assertEquals(res, control);
    }

    @org.junit.Test
    public void div() throws Exception {
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
        String control = "{4,6}";
        assertEquals(res, control);
    }
}