package by.it.basumatarau.jd02_09.TaskC;

import com.google.gson.GsonBuilder;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XMLtoJSONconverter extends AbstractConverter {
    private XMLtoJSONconverter(){

    }
    XMLtoJSONconverter(Class clazz){
        beanClass = clazz;
    }

    @Override
    public void load(File src) {
        try(FileReader fr = new FileReader(src)){
            Unmarshaller unmarshaller = JAXBContext.newInstance(this.beanClass).createUnmarshaller();
            this.bean = unmarshaller.unmarshal(fr);
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public void load(String src) {
        try{
            Unmarshaller unmarshaller = JAXBContext.newInstance(this.beanClass).createUnmarshaller();
            this.bean = unmarshaller.unmarshal(new InputSource(src));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(File dest) {
        try(FileWriter fw = new FileWriter(dest)){
            new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(bean, fw);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getText() {
        return new GsonBuilder().setPrettyPrinting().serializeNulls().create().toJson(bean);
    }
}
