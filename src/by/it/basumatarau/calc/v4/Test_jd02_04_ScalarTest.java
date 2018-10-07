package by.it.basumatarau.calc.v4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_jd02_04_ScalarTest {
    @Test
    public void scalarAdd() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("2.1234+2.4321");
        assertEquals("adding scalar values: ","4.5555", result.toString());
    }
    @Test
    public void scalarSub() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("2-3.23451");
        assertTrue("subtracting scalar values: ", result.toString().contains("-1.23451"));
    }
    @Test
    public void scalarMul() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("2.123*3.13");
        assertTrue("multiplication scalar values: ", result.toString().contains("6.64499"));
    }
    @Test
    public void scalarDiv() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("6.66/2.22");
        assertEquals("dividing scalar values: ","3.0", result.toString());
    }
    @Test
    public void scalarExpressionCalc() throws Exception{
        Parser instance = new Parser();
        String expression1 = "A=2+5.3";
        String expression2 = "B=A*3.5";
        String expression3 = "B1=B+0.11*-5";
        String expression4 = "B2=A/2-1";

        assertTrue("scalar parsing: "+expression1, instance.calc(expression1).toString().contains("7.3"));
        assertTrue("scalar parsing: "+expression2, instance.calc(expression2).toString().contains("25.55"));
        assertTrue("scalar parsing: "+expression3, instance.calc(expression3).toString().contains("25"));
        assertTrue("scalar parsing: "+expression4, instance.calc(expression4).toString().contains("2.65"));
    }
}