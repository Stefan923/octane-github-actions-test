package me.stefan923.vulnerableapp.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandExecutor {
    public void executeCommand(String command) throws IOException {
        // Vulnerabilitate Command Injection
        Runtime.getRuntime().exec(command);
    }

    // Metodă securizată cu parametri fixați
    public void executeCommandSecure(String baseCommand, String... args) throws IOException {
        List<String> command = new ArrayList<>();
        command.add(baseCommand);
        command.addAll(Arrays.asList(args));

        ProcessBuilder pb = new ProcessBuilder(command);
        pb.start();
    }
}