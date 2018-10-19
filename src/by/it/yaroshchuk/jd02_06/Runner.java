package by.it.yaroshchuk.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("1");
        logger.log("2");
        logger = null;
        logger = Logger.getInstance();
        logger.log("3");
        logger.log("4");
    }
}
