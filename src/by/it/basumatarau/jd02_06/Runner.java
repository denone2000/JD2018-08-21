package by.it.basumatarau.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.addMsg("test", Logger.MsgType.INPUT);
        logger.addMsg("test1", Logger.MsgType.INPUT);
        logger.addMsg("test2", Logger.MsgType.INPUT);
        logger = Logger.getInstance();
        logger.addMsg("test3", Logger.MsgType.INPUT);
        logger.addMsg("test4", Logger.MsgType.INPUT);
    }
}
