package ru.akvine.servlet.pages;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class GreetingPage {

    public void greeting(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><body>");
        printWriter.write("<a href=\"/login\">Login</a>");
        printWriter.write("</body></html>");
        printWriter.close();
    }
}
