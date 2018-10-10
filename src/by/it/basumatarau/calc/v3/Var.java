package by.it.basumatarau.calc.v3;

import java.io.*;
import java.util.*;

public abstract class Var implements Operation {
    private static HashMap<String, Var> varHashMap = new HashMap<>();

    static {
        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator
                + Var.class.getName().replaceAll("[.]", File.separator).replaceAll(Var.class.getSimpleName(),"");
        File file = new File(path+"vars.txt");
        if(file.exists()){
            try(BufferedReader buffR = new BufferedReader(new FileReader(file))){
                String line;
                while((line=buffR.readLine())!=null){
                    varHashMap.put(line.split("=")[0],createVar(line.split("=")[1]));
                }
            }catch (IOException | CalcException e){
                e.printStackTrace();
            }
        }
    }

    static Var saveVar(String name, Var var){
        varHashMap.put(name, var);

        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator
                + Var.class.getName().replaceAll("[.]", File.separator).replaceAll(Var.class.getSimpleName(),"");
        File file = new File(path+"vars.txt");
        try(BufferedWriter buffW = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry<String, Var> entry : varHashMap.entrySet()) {
                buffW.write(entry.getKey() + "=" +entry.getValue()+'\n');
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return var;
    }
    static String sortvar(){
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet<>(varHashMap.keySet());
        Iterator<String> entryIterator = treeSet.iterator();
        String key;
        while(entryIterator.hasNext()){
            sb.append(key=entryIterator.next()).append("=").append(varHashMap.get(key)).append("\n");
        }
        return sb.toString();
    }
    static String printVar(){
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Var>> entries = Var.varHashMap.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            sb.append(entry.toString()).append("\n");
        }
        return sb.toString();
    }

    static Var createVar(String strOperand) throws CalcException{
        if (strOperand.trim().matches(RegExPatterns.SCALAR)) return new Scalar(strOperand);
        if (strOperand.trim().matches(RegExPatterns.VECTOR)) return new Vector(strOperand);
        if (strOperand.trim().matches(RegExPatterns.MATRIX)) return new Matrix(strOperand);
        if (varHashMap.containsKey(strOperand)){return varHashMap.get(strOperand);}

        throw new CalcException(
                CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.VAR_EXCEPTION_OPERAND_NOT_PARSED)
        );
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(
                String.format(
                        CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.VAR_EXCEPTION_ILLEGAL_SUM_OPERATION),
                        this, other
                )
        );
    }
    public abstract Var addTo(Scalar scalar) throws CalcException;
    public abstract Var addTo(Vector vector) throws CalcException;
    public abstract Var addTo(Matrix matrix) throws CalcException;

    @Override
    public Var sub(Var other)  throws CalcException{
        throw new CalcException(
                String.format(
                        CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.VAR_EXCEPTION_ILLEGAL_SUB_OPERATION),
                        other, this
                )
        );
    }
    public abstract Var subAnother(Scalar scalar) throws CalcException;
    public abstract Var subAnother(Vector vector) throws CalcException;
    public abstract Var subAnother(Matrix matrix) throws CalcException;

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(
                String.format(
                        CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.VAR_EXCEPTION_ILLEGAL_MUL_OPERATION),
                        this, other
                )
        );
    }
    public abstract Var mulBy(Scalar scalar) throws CalcException;
    public abstract Var mulBy(Vector vector) throws CalcException;
    public abstract Var mulBy(Matrix matrix) throws CalcException;
    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(
                String.format(
                        CalcExceptionResManager.ENTITY.getMsgByKey(I18nKeys.VAR_EXCEPTION_ILLEGAL_DIV_OPERATION),
                        other, this
                )
        );
    }
    public abstract Var divBy(Scalar scalar) throws CalcException;
    public abstract Var divBy(Vector vector) throws CalcException;
    public abstract Var divBy(Matrix matrix) throws CalcException;
}
