public class YearlyReportRow {
    int month;
    int amount;

    public void setFields(String[] fields) {
        this.month = Integer.parseInt(fields[0]);
        this.amount = Integer.parseInt(fields[1]);
    }
}
