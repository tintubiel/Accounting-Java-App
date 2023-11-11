import java.util.ArrayList;

public class YearlyReport {
    int year;
    String[] monthsNames = {"Январь", "Февраль", "Март"};
    ArrayList<YearlyReportRow> expences;
    ArrayList<YearlyReportRow> incomes;

    public void setFields(ArrayList<String> content, int year) {
        this.year = year;
        this.expences = new ArrayList<>(3);
        this.incomes = new ArrayList<>(3);
        for (int i = 1; i < content.size(); i += 1) {
            String line = content.get(i);
            YearlyReportRow row = new YearlyReportRow();
            String[] fields = line.split(",");
            boolean is_income = Boolean.parseBoolean(fields[2]);
            row.setFields(fields);

            if (is_income) {
                expences.add(row.month-1, row);
            } else {
                incomes.add(row.month-1, row);
            }
        }
    }

    public int searchMeanExpence(){
        int sumExpence = 0;
        for(YearlyReportRow item:expences) {
            sumExpence += item.amount;
            }
        return((int)(sumExpence/expences.size()));
    }

    public int searchMeanIncome(){
        int sumIncome = 0;
        for(YearlyReportRow item:incomes) {
            sumIncome += item.amount;
        }
        return((int)(sumIncome/incomes.size()));
    }

    public void printIncome(){
        for(YearlyReportRow item:incomes){
            System.out.println("Месяц: " + monthsNames[item.month-1] + ", доход: " + item.amount);
        }
    }
}
