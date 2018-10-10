package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;

interface Operation {

    Var add(Var other) throws CalcException, IOException;

    Var sub(Var other) throws CalcException, IOException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}
