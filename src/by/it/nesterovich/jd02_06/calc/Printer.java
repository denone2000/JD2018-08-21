package by.it.nesterovich.jd02_06.calc;

class Printer {

    void print(Var variable) {
        if (variable != null) {
            Logger.getInstance().writeReport(String.valueOf(variable),TitleType.OUTPUT);
            System.out.println(variable);
        }
    }
}
