package by.it.artemliashkov.jd01_08;

public class Var extends Operation {
    public Var add(Var Other)
    {
        System.out.println("Операция сложения  невозможна");
        return null;
    }
    public Var sub(Var Other)
    {
        System.out.printf("Операция вычитания  невозможна");
        return null;
    }
    public Var mul(Var Other)
    {
        System.out.printf("Операция умножения  невозможна");
        return null;
    }
    public Var div(Var Other)
    {
        System.out.printf("Операция деления  невозможна");
        return null;
    }

}
