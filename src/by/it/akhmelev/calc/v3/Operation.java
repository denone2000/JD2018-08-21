package by.it.akhmelev.calc.v3;

import by.it.akhmelev.calc.v3.*;

interface Operation {
    Var add(Var other) throws by.it.akhmelev.calc.v3.CalcException;

    Var sub(Var other) throws by.it.akhmelev.calc.v3.CalcException;

    Var mul(Var other) throws by.it.akhmelev.calc.v3.CalcException;

    Var div(Var other) throws by.it.akhmelev.calc.v3.CalcException;
}