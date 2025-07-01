package me.stefan923.vulnerableapp.processor;

import me.stefan923.vulnerableapp.validator.FilenameValidator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileDataImporter {
    public void importFile(String filename) throws IOException {
        // Vulnerabilitate Path Traversal
        File file = new File("/uploads/" + filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            new DataParser().parse(fis);
        }
    }

    // Metodă securizată cu validare nume fișier
    public void importFileSecure(String filename) throws IOException {
        String safeFilename = new FilenameValidator().sanitizeFilename(filename);
        File file = new File("/uploads/" + safeFilename);
        try (FileInputStream fis = new FileInputStream(file)) {
            new DataParser().parse(fis);
        }
    }
}