package by.it.galushka.jd02_06.TaskC;

public class Report {

    private String headline = "";
    private String startTime = "";
    private String enteredExpression = "";
    private String exeptions = "";
    private String endTime = "";

    void setHeadline(String headline) {
        this.headline = headline;
    }

    void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    void setEnteredExpression(String enteredExpression) {
        this.enteredExpression = enteredExpression;
    }

    void setEcxeptions(String exeptions) {
        this.exeptions = exeptions;
    }

    void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return headline + "\n"
                + startTime + "\n"
                + enteredExpression + "\n"
                + exeptions + "\n"
                + "Конец отчета.\n"
                + endTime + "\n";
    }
}
