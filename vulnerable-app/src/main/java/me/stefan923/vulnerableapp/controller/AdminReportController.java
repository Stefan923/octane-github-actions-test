package me.stefan923.vulnerableapp.controller;

import me.stefan923.vulnerableapp.service.ReportService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminReportController {
    public void generateReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reportType = request.getParameter("type");
        ReportService reportService = new ReportService();

        String report = reportService.generateReport(reportType,
                request.getParameter("startDate"),
                request.getParameter("endDate"));

        response.getWriter().println(report);
    }
}