package me.stefan923.vulnerableapp.processor;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLDataProcessor {
    public void process(String filePath) throws Exception {
        // Vulnerabilitate XXE
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = (Document) builder.parse(new File(filePath));
        processDocument(doc);
    }

    // Metodă securizată pentru procesare XML
    public void processSecure(String filePath) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = (Document) builder.parse(new File(filePath));
        processDocument(doc);
    }

    private void processDocument(Document doc) {
        // Procesare document
    }
}