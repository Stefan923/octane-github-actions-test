package me.stefan923.vulnerableapp.controller;

import me.stefan923.vulnerableapp.service.DataImportService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DataImportController {
    public void importData(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        DataImportService importService = new DataImportService();

        try {
            importService.importFromSource(source);
            response.getWriter().println("Data imported successfully");
        } catch (Exception e) {
            response.sendError(500, "Import failed");
        }
    }
}