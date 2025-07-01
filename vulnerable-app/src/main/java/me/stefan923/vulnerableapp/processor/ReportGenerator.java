package me.stefan923.vulnerableapp.processor;

import org.owasp.encoder.Encode;

public class ReportGenerator {
    public String generateReport(String reportType, String startDate, String endDate) {
        // Vulnerabilitate XSS
        return "<div class='report'><h1>" + reportType + " Report</h1>" +
                "<p>Period: " + startDate + " to " + endDate + "</p>" +
                "<div>" + generateReportData(reportType) + "</div></div>";
    }

    private String generateReportData(String reportType) {
        // Simulare date raport
        return "<table><tr><td>Data 1</td><td>Data 2</td></tr></table>";
    }

    // Metodă securizată cu encoding
    public String generateReportSecure(String reportType, String startDate, String endDate) {
        return "<div class='report'><h1>" + Encode.forHtml(reportType) + " Report</h1>" +
                "<p>Period: " + Encode.forHtml(startDate) + " to " + Encode.forHtml(endDate) + "</p>" +
                "<div>" + generateReportData(reportType) + "</div></div>";
    }
}