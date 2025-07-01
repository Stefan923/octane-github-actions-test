package me.stefan923.vulnerableapp.service;

import me.stefan923.vulnerableapp.processor.FileDataImporter;
import me.stefan923.vulnerableapp.processor.RemoteDataLoader;
import me.stefan923.vulnerableapp.processor.XMLDataProcessor;

public class DataImportService {
    public void importFromSource(String source) throws Exception {
        if (source.startsWith("http")) {
            new RemoteDataLoader().loadData(source);
        } else if (source.endsWith(".xml")) {
            new XMLDataProcessor().process(source);
        } else {
            new FileDataImporter().importFile(source);
        }
    }
}