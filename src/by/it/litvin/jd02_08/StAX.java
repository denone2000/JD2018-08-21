package by.it.litvin.jd02_08;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

class StAX {
    private XMLStreamReader reader;

    StAX(XMLStreamReader reader) {
        this.reader = reader;
    }

    String parse() throws XMLStreamException {
        StringBuilder text = new StringBuilder();
        String tab = "";
        StringBuilder buff = new StringBuilder();
        while (reader.hasNext()) {
            int operation = reader.next();
            switch (operation) {
                case XMLStreamConstants.START_ELEMENT:
                    String qName = reader.getLocalName();
                    int attCount = reader.getAttributeCount();
                    text.append(tab).append("<").append(qName);
                    for (int i = 0; i < attCount; i++) {
                        String name = reader.getAttributeLocalName(i);
                        String value = reader.getAttributeValue(i);
                        text.append(" ").append(name).append("=\"").append(value).append("\"");

                    }
                    text.append(">\n");
                    tab = tab + "\t";
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    String qName2 = reader.getLocalName();
                    String tx = buff.toString().trim();
                    if (tx.length() > 0)
                        text.append(tab).append(tx).append("\n");
                    buff.setLength(0);
                    tab = tab.substring(1);
                    text.append(tab).append("</").append(qName2).append(">\n");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    String part = reader.getText();
                    buff.append(part);
                    break;
            }
        }
        return text.toString();
    }


}
