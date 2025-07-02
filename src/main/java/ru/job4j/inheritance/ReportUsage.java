package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        HtmlReport htmlreport = new HtmlReport();
        String text1 = htmlreport.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonreport = new JSONReport();
        String text2 = jsonreport.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}