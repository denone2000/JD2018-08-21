package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.CalcException;
import by.it.korzik.jd02.jd02_04.Var;

interface Operation {
    Var add(Var other) throws CalcException;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}
