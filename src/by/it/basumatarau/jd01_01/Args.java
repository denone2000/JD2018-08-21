package by.it.basumatarau.jd01_01;

public class Args {

    private String[] args;

    Args(String[] args){
        this.args = args;
    }

    public void printArgs(){
        int i = 1;
        for (String arg : args){
            System.out.println("Arg#" + i++ + ": " + arg);
        }
    }
}
