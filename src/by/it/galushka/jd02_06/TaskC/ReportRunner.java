package by.it.galushka.jd02_06.TaskC;

public class ReportRunner {
    public static void main(String[] args) {
        Writter writter = new Writter();
        ReportBuilder rb = new ShortReport();
        writter.setReportBuilder(rb);
        writter.constructReport();
        System.out.println(writter.getReport());
        rb = new FullReport();
        writter.setReportBuilder(rb);
        writter.constructReport();
        System.out.println(writter.getReport());
    }
}
