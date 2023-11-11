import java.util.ArrayList;

public class ReportManager {
    MonthlyReport [] monthlyReports = new MonthlyReport[12];
    int savedMonth = 0;
    String[] monthsNames = {"Январь", "Февраль", "Март"};
    YearlyReport yearlyReport;

    public void addMonthReport(ArrayList<String> content, int month) {//add month report in ReportManager
        MonthlyReport report = new MonthlyReport();
        report.setFields(content);
        monthlyReports[month-1] = report;
        savedMonth += 1;
        if(savedMonth == 3){
            System.out.println("Отчеты за месяц успешно добавлены");
        }
    }

    public void addYearlyReport(ArrayList<String> content, int year) {//add year report in ReportManager
        YearlyReport report = new YearlyReport();
        report.setFields(content, year);
        yearlyReport = report;
        System.out.println("Отчет за год успешно добавлен");
    }

    public void checkReports() {//is reports correct
        if((yearlyReport==null)||(savedMonth==0)){
            System.out.println("Для сверки отчетов нужно сначала загрузить их в программу.");
            return;
        }
        for (YearlyReportRow row : yearlyReport.expences) {//check expences
            MonthlyReport currentMonthReport = monthlyReports[row.month-1];
            if (currentMonthReport.sumExpense() != row.amount) {
                System.out.println("Расхождение в расходах, месяц: " + monthsNames[row.month-1]);
                return;
            }
        }
        for (YearlyReportRow row : yearlyReport.incomes) {//check incomes
            MonthlyReport currentMonthReport = monthlyReports[row.month-1];
            if (currentMonthReport.sumIncome() != row.amount) {
                System.out.println("Расхождение в доходах, месяц: " + monthsNames[row.month-1]);
                return;
            }
        }
        System.out.println("Расхождений в отчетах не выявлено");
    }

    public void printMonthlyReports() {
        if(savedMonth==0){
            System.out.println("Для печати отчетов нужно сначала загрузить их в программу.");
            return;
        }
        for(int monthNum=0; monthNum<savedMonth; monthNum+=1){
            MonthlyReport report = monthlyReports[monthNum];
            System.out.println("Месяц: " + monthsNames[monthNum]);
            MothlyReportRow maxIncomeItem = report.searchMaxIncome();
            System.out.println("Cамый прибыльный товар: " + maxIncomeItem.itemName +", сумма прибыли: "+ maxIncomeItem.price);
            MothlyReportRow maxExpenceItem = report.searchMaxExpense();
            System.out.println("Cамая большая трата: "+maxExpenceItem.itemName +", сумма прибыли: "+ maxExpenceItem.price);
        }
    }

    public void printYearlyReport() {
        if(yearlyReport==null){
            System.out.println("Для печати отчета нужно сначала загрузить его в программу.");
            return;
        }
        System.out.println(yearlyReport.year + " год");//print num of year
        yearlyReport.printIncome();// print income by month
        System.out.println("Средний расход за год: " + yearlyReport.searchMeanExpence());//print mean expence
        System.out.println("Средний доход за год: " + yearlyReport.searchMeanIncome());//print mean income

    }
}
