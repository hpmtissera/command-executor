package com.example;

import com.zaxxer.nuprocess.NuAbstractProcessHandler;
import com.zaxxer.nuprocess.NuProcess;

import java.nio.ByteBuffer;

class ProcessHandler extends NuAbstractProcessHandler {
    private NuProcess nuProcess;
    private StringBuilder result = new StringBuilder();

    @Override
    public void onStart(NuProcess nuProcess) {
        this.nuProcess = nuProcess;
    }

    @Override
    public boolean onStdinReady(ByteBuffer buffer) {
        return false; // false means we have nothing else to write at this time
    }

    @Override
    public void onStdout(ByteBuffer buffer, boolean closed) {
        if (!closed) {
            byte[] bytes = new byte[buffer.remaining()];
            // You must update buffer.position() before returning (either implicitly,
            // like this, or explicitly) to indicate how many bytes your handler has consumed.
            buffer.get(bytes);
            result.append(new String(bytes));

            // For this example, we're done, so closing STDIN will cause the "cat" process to exit
            nuProcess.closeStdin(true);
        }
    }

    public String getResult() {
        return result.toString();
    }

    @Override
    public void onStderr(ByteBuffer buffer, boolean closed) {
        this.onStdout(buffer, false);
    }
}