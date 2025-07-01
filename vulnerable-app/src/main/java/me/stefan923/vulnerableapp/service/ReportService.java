package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.processor.ReportGenerator;

public class ReportService {
    public String generateReport(String reportType, String startDate, String endDate) {
        ReportGenerator generator = new ReportGenerator();
        return generator.generateReport(reportType, startDate, endDate);
    }
}