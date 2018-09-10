package by.it.artemliashkov.jd01_09;

 class Var extends Operation {
      static Var createVar(String strVar) {
         if(strVar.matches(Patterns.SCALAR))
             return new Scalar(strVar);
         if(strVar.matches(Patterns.VECTOR))
             return new Vector(strVar);
         if(strVar.matches(Patterns.MATRIX))
             return new Matrix(strVar);
         //TODO create exception
         return null;
     }

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
