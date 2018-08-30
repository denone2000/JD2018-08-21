package basumatarau.jd01_01;

public class Hello {
    private String moto = "Hello Wrorld!";

    public void setMoto(String moto){
        this.moto = moto;
    }

    public String getMoto(){
        return moto;
    }

    public void printMoto(){
        System.out.println(moto);
    }
}
