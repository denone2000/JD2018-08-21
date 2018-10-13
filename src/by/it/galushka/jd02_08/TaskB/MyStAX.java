package by.it.galushka.jd02_08.TaskB;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class MyStAX {

    private static String tab = "";
    private static StringBuilder characters = new StringBuilder();

    public static void main(String[] args) {
        String file = System.getProperty("user.dir");
        file = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/Fighters.xml";
        try (FileInputStream input = new FileInputStream(file)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "<" + reader.getLocalName());
                        if (reader.getAttributeCount() > 0) {
                            for (int i = 0; i < reader.getAttributeCount(); i++) {
                                String name = reader.getAttributeLocalName(i);
                                String value = reader.getAttributeValue(i);
                                System.out.print(" " + name + " = " + value);
                            }
                        }
                        System.out.println(">");
                        tab = tab + "\t";
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        characters.append(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (characters.length() > 0) {
                            System.out.println(tab + characters);
                            characters.setLength(0);
                        }
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + reader.getLocalName() + ">");
                        break;
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }


    }
}
