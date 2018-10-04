package by.it.basumatarau.calc.v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04_VectorTest {

    @Test
    public void vectorAdd() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{2.1234, 2.1234} + 2.4321");
        assertTrue("adding scalar to vector: ", result.toString().matches("\\{4.5555,\\s?4.5555\\}"));
        Var result2 = instance.calc("{2.1234, 2.1234} + {2.4321, 0}");
        assertTrue("adding vector to vector: ", result2.toString().matches("\\{4.5555,\\s?2.1234\\}"));
    }

    @Test
    public void vectorSub() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{2.1234, 2.1234} - 2.4321");
        assertTrue("adding scalar to vector: ", result.toString().matches("\\{-0.3087,\\s?-0.3087\\}"));
        Var result2 = instance.calc("{2.1234, 2.1234} - {2.4321, 0}");
        assertTrue("adding vector to vector: ", result2.toString().matches("\\{-0.3087,\\s?2.1234\\}"));
    }

    @Test
    public void vectorMul() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{2.123, 2.123}*3.13");
        assertTrue("multiplication vector by scalar: ", result.toString().matches("\\{6.64499\\d+,\\s?6.64499\\d+\\}"));
        Var result2 = instance.calc("{2.123, 2.123}*{3.13, 1}");
        assertTrue("multiplication vector by vector: ", result2.toString().matches("8.76799\\d+"));
    }

    @Test
    public void vectorDiv() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{6.66,6.66}/2.22");
        assertTrue("dividing vector by scalar: ",result.toString().matches("\\{3.0,\\s?3.0\\}"));
    }

    @Test
    public void vectorExpressionCalc() throws Exception{
        Parser instance = new Parser();
        String expression1 = "A=2+5.3";
        String expression2 = "B=A*3.5";
        String expression3 = "B1=B+0.11*-5";
        String expression4 = "B2=A/2-1";

        String expression5 = "C=B+(A*2)";
        String expression6 = "D=((C-0.15)-20)/(7-5)";
        String expression7 = "{2,3}*(D/2)";

        assertTrue("scalar parsing: "+expression1, instance.calc(expression1).toString().contains("7.3"));
        assertTrue("scalar parsing: "+expression2, instance.calc(expression2).toString().contains("25.55"));
        assertTrue("scalar parsing: "+expression3, instance.calc(expression3).toString().contains("25"));
        assertTrue("scalar parsing: "+expression4, instance.calc(expression4).toString().contains("2.65"));

        assertTrue("scalar parsing: "+expression5, instance.calc(expression5).toString().contains("40.15"));
        assertTrue("scalar parsing: "+expression6, instance.calc(expression6).toString().contains("10.0"));
        assertTrue("scalar parsing: "+expression7, instance.calc(expression7).toString().matches("\\{10[.0]+,\\s?15[.0]+\\}"));
    }

}