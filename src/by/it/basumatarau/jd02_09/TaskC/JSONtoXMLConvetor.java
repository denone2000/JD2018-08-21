package by.it.basumatarau.jd02_09.TaskC;

import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONtoXMLConvetor extends AbstractConverter {
    private JSONtoXMLConvetor(){

    }

    JSONtoXMLConvetor(Class clazz){
        this.beanClass = clazz;
    }

    @Override
    public void load(File src) {
        try(FileReader fr = new FileReader(src)){
            bean=new GsonBuilder().serializeNulls().setPrettyPrinting().create().fromJson(fr, beanClass);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void load(String src) {
        bean=new GsonBuilder().serializeNulls().setPrettyPrinting().create().fromJson(src, beanClass);
    }

    @Override
    public void save(File dest) {
        try(FileWriter fw = new FileWriter(dest)){
            Marshaller marshaller = JAXBContext.newInstance(this.beanClass).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, fw);
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getText() {
        String result="";
        try (FileWriter fw = new FileWriter(result)){
            Marshaller marshaller = JAXBContext.newInstance(this.beanClass).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, fw);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
