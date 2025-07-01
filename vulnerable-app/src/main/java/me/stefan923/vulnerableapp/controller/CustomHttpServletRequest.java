package me.stefan923.vulnerableapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import java.util.Map;

public class CustomHttpServletRequest extends HttpServletRequestWrapper {
    private final Map<String, String[]> sanitizedParams;

    public CustomHttpServletRequest(HttpServletRequest request, Map<String, String[]> sanitizedParams) {
        super(request);
        this.sanitizedParams = sanitizedParams;
    }

    @Override
    public String getParameter(String name) {
        String[] values = getParameterValues(name);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        return sanitizedParams;
    }

    @Override
    public String[] getParameterValues(String name) {
        return sanitizedParams.get(name);
    }
}