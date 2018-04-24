package com.example;

import com.zaxxer.nuprocess.NuProcess;
import com.zaxxer.nuprocess.NuProcessBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Executor {
    private static Logger logger = Logger.getLogger(WebSocketExecutor.class.getName());

    public static String executeCommand(String command) {
        try {
            NuProcessBuilder pb = new NuProcessBuilder(Arrays.asList(command));
            ProcessHandler handler = new ProcessHandler();
            pb.setProcessListener(handler);
            NuProcess process = pb.start();
            process.wantWrite();
            process.waitFor(0, TimeUnit.SECONDS);
            return handler.getResult();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error occurred when executing command: " + command, e);
            return "Error when executing command.";
        }
    }
}
