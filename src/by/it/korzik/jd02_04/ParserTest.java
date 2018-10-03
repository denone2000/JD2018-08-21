package by.it.korzik.jd02_04;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private  Scalar scalar = new Scalar(5);
    private  Scalar otherScalar = new Scalar(4);
    @Test
    public void calcOneOperation() throws CalcException {
        Parser parser = new Parser();
        Var res = parser.calcOneOperation("1","+","2");
        assertEquals("3.0",res.toString());
    }

    @Test
    public void calc() throws CalcException {
        Parser parser = new Parser();
        Var res = parser.calc("a=2+2*2/-4");
        assertEquals("1.0",res.toString());
    }

    @Test
    public void add() throws CalcException {
        Var res = scalar.add(otherScalar);
        assertEquals("9.0", res.toString());
    }

    @Test
    public void sub() throws CalcException {
        Var res = scalar.sub(otherScalar);
        assertEquals("1.0", res.toString());
    }

    @Test
    public void mul() throws CalcException {
        Var res = scalar.mul(otherScalar);
        assertEquals("20.0", res.toString());
    }

    @Test
    public void div() throws CalcException {
        Var res = scalar.div(otherScalar);
        assertEquals("1.25", res.toString());
    }
}