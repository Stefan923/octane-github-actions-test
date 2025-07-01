package me.stefan923.vulnerableapp.security;

import me.stefan923.vulnerableapp.controller.CustomHttpServletRequest;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class SecurityFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verifică token CSRF pentru cererile POST
        if ("POST".equalsIgnoreCase(httpRequest.getMethod())) {
            CSRFTokenValidator validator = new CSRFTokenValidator();
            if (!validator.isValidToken(httpRequest)) {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF token");
                return;
            }
        }

        // Sanitizare parametri pentru XSS
        Map<String, String[]> sanitizedParams = new HashMap<>();
        for (Map.Entry<String, String[]> entry : httpRequest.getParameterMap().entrySet()) {
            String[] values = entry.getValue();
            String[] sanitizedValues = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                sanitizedValues[i] = SecurityUtils.sanitizeHTML(values[i]);
            }
            sanitizedParams.put(entry.getKey(), sanitizedValues);
        }

        // Continuă cu cererea modificată
        chain.doFilter(new CustomHttpServletRequest(httpRequest, sanitizedParams), response);
    }

    // Implementări necesare pentru interfața Filter
    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}