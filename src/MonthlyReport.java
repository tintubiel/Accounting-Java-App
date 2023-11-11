import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<MothlyReportRow> expenses;
    ArrayList<MothlyReportRow> incomes;

    public void setFields(ArrayList<String> content) {
        expenses = new ArrayList<>();
        incomes = new ArrayList<>();
        for (int i=1; i<content.size(); i+=1) {
            String line = content.get(i);
            MothlyReportRow row = new MothlyReportRow();
            String[] fields = line.split(",");
            boolean is_income = Boolean.parseBoolean(fields[1]);
            row.setFields(fields);

            if (is_income) {
                expenses.add(row);
            } else {
                incomes.add(row);
            }
        }
    }

    public MothlyReportRow searchMaxExpense() {
        MothlyReportRow maxItem = new MothlyReportRow();
        for(MothlyReportRow item: expenses) {
            if (maxItem.price < item.price) {
                maxItem = item;
            }
        }
        return(maxItem);
    }

    public MothlyReportRow searchMaxIncome() {
        MothlyReportRow maxItem = new MothlyReportRow();
        for(MothlyReportRow item:incomes) {
            if (maxItem.price < item.price) {
                maxItem = item;
            }
        }
        return(maxItem);
    }

    public int sumExpense() {
        int sumExpencee = 0;
        for(MothlyReportRow item: expenses) {
            sumExpencee+= item.price;
        }
        return(sumExpencee);
    }

    public int sumIncome() {
        int sumIncome = 0;
        for(MothlyReportRow item:incomes) {
            sumIncome+= item.price;
        }
        return(sumIncome);
    }
}





