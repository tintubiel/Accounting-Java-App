import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        ReportManager reportmanager = new ReportManager();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {//add month reports to ReportManager
                String fileNamePart = "m.2021";
                String[] months = {"01", "02", "03"};
                for (String month : months) {
                    String fileName = fileNamePart + month + ".csv";
                    ArrayList<String> content = reader.readFileContents(fileName);
                    reportmanager.addMonthReport(content, Integer.parseInt(month));
                }
            } else if (i == 2) {//add year reports to ReportManager
                String fileNamePart = "y.";
                String year = "2021";
                String fileName = fileNamePart+year+".csv";
                ArrayList<String> content = reader.readFileContents(fileName);
                reportmanager.addYearlyReport(content,Integer.parseInt(year));
            } else if (i == 3) {//check reports
                reportmanager.checkReports();
            } else if (i == 4) {//print months reports
                reportmanager.printMonthlyReports();
            } else if (i == 5) {//print year report
                reportmanager.printYearlyReport();
            } else if (i == 6) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }

    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты.");
        System.out.println("2 - Считать годовой отчёт.");
        System.out.println("3 - Сверить отчёты.");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах.");
        System.out.println("5 - Вывести информацию о годовом отчёте.");
        System.out.println("6 - Выйти из приложения.");
    }


}
