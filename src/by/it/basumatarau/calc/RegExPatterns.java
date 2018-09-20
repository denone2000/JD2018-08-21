package by.it.basumatarau.calc;

class RegExPatterns {

    static final String OPERATOR = "((?<=([\\w{})\\]]\\s?))[-+=*/])|(^[.])|(^[-+=*/])";
    static final String SCALAR = "((?<=[\\w\\d}]?\\s?)(\\d+[.]?\\d*))|((?<=[\\w\\d}]?\\s?[-+*/,{]\\s?)([-]?\\d+[.]?\\d*))|(^((-)?\\d+[.]?\\d*))";
    static final String VECTOR = "\\{(("+SCALAR+")(, ?)?)+}";
    static final String MATRIX = "\\{(("+VECTOR+")(, ?)?)+}";
    static final String OPENING_SEPARATOR = "[\\{\\(\\[]";
    static final String CLOSING_SEPARATOR = "[\\}\\)\\]]";

    static final String SEPARATOR = "(("+OPENING_SEPARATOR+")|("+CLOSING_SEPARATOR+"))";
    static final String LITERAL = "("+SCALAR+")|("+VECTOR+")|("+MATRIX+")";
    static final String IDENTIFIER = "[\\w_]+";
    static final String TOKEN = "("+LITERAL+")|("+OPERATOR+")|("+SEPARATOR+")|("+IDENTIFIER+")";
    static final String SIMPLE_TOKEN = "((-)?\\d+[.]?\\d*)|(\\{\\s?((((-)?\\d+[.]?\\d*)(,\\s?)?)+)\\s?\\})|\\{\\s?((\\{\\s?((((-)?\\d+[.]?\\d*)(,\\s?)?)+)\\s?\\})(,\\s?)?)+\\s?\\}|(((?<=([-*+/\\w{}]\\s?))[-+=*/])|(^[-+=*/]))|([\\w_]+)";
}
