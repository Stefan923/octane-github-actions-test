package me.stefan923.vulnerableapp.processor;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RemoteDataLoader {
    public void loadData(String url) throws IOException {
        // Vulnerabilitate SSRF
        InputStream is = new URL(url).openStream();
        new DataParser().parse(is);
    }
}