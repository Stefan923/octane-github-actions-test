package me.stefan923.vulnerableapp.processor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataParser {
    public void parse(InputStream is) {
        // Vulnerabilitate Buffer Overflow
        byte[] buffer = new byte[1024];
        int bytesRead;
        try {
            while ((bytesRead = is.read(buffer)) != -1) {
                processBuffer(buffer, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processBuffer(byte[] buffer, int length) {
        // Procesare buffer
    }

    // Metodă securizată cu verificare dimensiune
    public void parseSecure(InputStream is) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] chunk = new byte[4096];
        int bytesRead;

        while ((bytesRead = is.read(chunk, 0, Math.min(chunk.length, is.available()))) != -1) {
            buffer.write(chunk, 0, bytesRead);
        }

        processBuffer(buffer.toByteArray(), buffer.size());
    }
}
