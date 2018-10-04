package by.it.basumatarau.calc.v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test_jd02_04_MatrixTest {
    @Test
    public void matrixAdd() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{{2.1234, 2.1234}, {2.1234, 2.1234}} + 2.4321");
        assertTrue("adding matrix to scalar: ", result.toString().matches("\\{\\{4.5555,\\s?4.5555\\},\\s?\\{4.5555,\\s?4.5555\\}\\}"));
        Var result2 = instance.calc("{{2.1234, 2.1234}, {2.1234, 2.1234}} + {{2.4321, 2.4321}, {0, 0}}");
        assertTrue("adding matrix to matrix: ", result2.toString().matches("\\{\\{4.5555,\\s?4.5555\\},\\s?\\{2.1234,\\s?2.1234\\}\\}"));
    }

    @Test
    public void matrixSub() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{{2.1234, 2.1234}, {2.1234, 2.1234}} - 2.4321");
        assertTrue("subtracting scalar from matrix: ",
                result.toString().matches("\\{\\{-0.3087,\\s?-0.3087\\},\\s?\\{-0.3087,\\s?-0.3087\\}\\}"));
        Var result2 = instance.calc("{{2.1234, 2.1234}, {2.1234, 2.1234}}- {{2.4321, 2.4321}, {0, 0}}");
        assertTrue("subtracting matrix from matrix: ",
                result2.toString().matches("\\{\\{-0.3087,\\s?-0.3087\\},\\s?\\{2.1234,\\s?2.1234\\}\\}"));
    }

    @Test
    public void mulMul() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{{2.123, 2.123},{2.123, 2.123}}*3.13");
        assertTrue("multiplication matrix by scalar: ",
                result.toString().matches("\\{\\{6.64499\\d*,\\s?6.64499\\d*\\},\\s?\\{6.64499\\d*,\\s?6.64499\\d*\\}\\}"));
        Var result2 = instance.calc("{{2.123, 2.123},{2.123, 2.123}}*{3.13, 1}");
        assertTrue("multiplication matrix by vector: ",
                result2.toString().matches("\\{8.76799\\d*,\\s?8.76799\\d*\\}"));
        Var result3 = instance.calc("{{2.123, 2.123},{2.123, 2.123}}*{{2,2},{1,1}}");
        assertTrue("multiplication matrix by matrix: ",
                result3.toString().matches("\\{\\{6.369\\d*,\\s?6.369\\d*\\},\\s?\\{6.369\\d*,\\s?6.369\\d*\\}\\}"));
    }

    @Test
    public void matrixDiv() throws Exception{
        Parser instance = new Parser();
        Var result = instance.calc("{{6.66,6.66},{6.66,6.66}}/2.22");
        assertTrue("division matrix by scalar: ",result.toString().matches("\\{\\{3.0,\\s?3.0\\},\\s?\\{3.0,\\s?3.0\\}\\}"));
    }

    @Test
    public void matrixExpressionCalc() throws Exception{
        Parser instance = new Parser();
        String expression1 = "A=2+5.3";
        String expression2 = "B=A*3.5";
        String expression3 = "B1=B+0.11*-5";
        String expression4 = "B2=A/2-1";

        String expression5 = "C=B+(A*2)";
        String expression6 = "D=((C-0.15)-20)/(7-5)";
        String expression7 = "{2,3}*(D/2)";

        String expression8 = "E=B*(A+2)*{{1,2,3}, {4,5,6}}";
        String expression9 = "F=((E-10.0)*2)/(7-5)";
        String expression10 = "F-(D/2)";

        assertTrue("scalar parsing: "+expression1, instance.calc(expression1).toString().contains("7.3"));
        assertTrue("scalar parsing: "+expression2, instance.calc(expression2).toString().contains("25.55"));
        assertTrue("scalar parsing: "+expression3, instance.calc(expression3).toString().contains("25"));
        assertTrue("scalar parsing: "+expression4, instance.calc(expression4).toString().contains("2.65"));

        assertTrue("scalar parsing: "+expression5, instance.calc(expression5).toString().contains("40.15"));
        assertTrue("scalar parsing: "+expression6, instance.calc(expression6).toString().contains("10.0"));
        assertTrue("scalar parsing: "+expression7, instance.calc(expression7).toString().matches("\\{10[.0]+,\\s?15[.0]+\\}"));

        assertTrue("scalar parsing: "+expression8, instance.calc(expression8).toString().matches("\\{\\{237.615\\d*,\\s?475.23\\d*,\\s?712.845\\d*},\\s?\\{950.46\\d*,\\s?1188.075\\d*,\\s?1425.69\\d*\\}\\}"));
        assertTrue("scalar parsing: "+expression9, instance.calc(expression9).toString().matches("\\{\\{227.615\\d*,\\s?465.23\\d*,\\s?702.845\\d*},\\s?\\{940.46\\d*,\\s?1178.075\\d*,\\s?1415.69\\d*\\}\\}"));
        assertTrue("scalar parsing: "+expression10, instance.calc(expression10).toString().matches("\\{\\{222.615\\d*,\\s?460.23\\d*,\\s?697.845\\d*\\},\\s?\\{935.46\\d*,\\s?1173.075\\d*,\\s?1410.69\\d*\\}\\}"));
    }

}