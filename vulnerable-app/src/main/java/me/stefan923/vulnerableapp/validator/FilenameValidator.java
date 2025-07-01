package me.stefan923.vulnerableapp.validator;

public class FilenameValidator {
    public String sanitizeFilename(String filename) {
        // Protecție Path Traversal
        return filename.replaceAll("[^a-zA-Z0-9\\.\\-]", "_")
                .replaceAll("\\.\\.", "_");
    }
}