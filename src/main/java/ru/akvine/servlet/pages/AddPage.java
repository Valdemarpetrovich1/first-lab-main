package ru.akvine.servlet.pages;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class AddPage {
    public void add(HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><head>");
        printWriter.write("<style>");
        printWriter.write(".form-container {");
        printWriter.write("    max-width: 400px;");
        printWriter.write("    margin: 0 auto;");
        printWriter.write("    padding: 20px;");
        printWriter.write("    border: 1px solid #ccc;");
        printWriter.write("    background-color: #f9f9f9;");
        printWriter.write("    border-radius: 5px;");
        printWriter.write("}");
        printWriter.write(".input-field {");
        printWriter.write("    width: 100%;");
        printWriter.write("    padding: 10px;");
        printWriter.write("    margin: 5px 0;");
        printWriter.write("    border: 1px solid #ccc;");
        printWriter.write("    border-radius: 3px;");
        printWriter.write("}");
        printWriter.write(".submit-button {");
        printWriter.write("    background-color: #007BFF;");
        printWriter.write("    color: #fff;");
        printWriter.write("    padding: 10px 20px;");
        printWriter.write("    border: none;");
        printWriter.write("    border-radius: 3px;");
        printWriter.write("    cursor: pointer;");
        printWriter.write("}");
        printWriter.write(".main-link {");
        printWriter.write("    color: #007BFF;");
        printWriter.write("    text-decoration: none;");
        printWriter.write("    display: block;");
        printWriter.write("    margin-top: 10px;");
        printWriter.write("}");
        printWriter.write(".main-link:hover {");
        printWriter.write("    text-decoration: underline;");
        printWriter.write("}" +
                ".link-wrapper {\n" +
                "            text-align: center;\n" +
                "            margin-top: auto; \n" +
                "            margin-bottom: 20px; \n" +
                "        }");
        printWriter.write("</style>");
        printWriter.write("</head><body>");
        printWriter.write("<div class=\"form-container\">");
        printWriter.write("<form action=\"/add.do\" method=\"post\">");
        printWriter.write("<div>");
        printWriter.write("<label for=\"username\">Username:</label>");
        printWriter.write("<input type=\"text\" class=\"input-field\" placeholder=\"Enter username\" name=\"username\" id=\"username\" required>");
        printWriter.write("<br>");
        printWriter.write("<label for=\"password\">Password:</label>");
        printWriter.write("<input type=\"password\" class=\"input-field\" placeholder=\"Enter password\" name=\"password\" id=\"password\" required>");
        printWriter.write("<br>");
        printWriter.write("<label for=\"phone\">Phone:</label>");
        printWriter.write("<input type=\"text\" class=\"input-field\" placeholder=\"Enter phone\" name=\"phone\" id=\"phone\">");
        printWriter.write("<br>");
        printWriter.write("<label for=\"email\">Email:</label>");
        printWriter.write("<input type=\"text\" class=\"input-field\" placeholder=\"Enter email\" name=\"email\" id=\"email\">");
        printWriter.write("<button type=\"submit\" class=\"submit-button\">Add</button>");
        printWriter.write("</div>");
        printWriter.write("</form>");
        printWriter.write("</div>");
        printWriter.write("<br>");
        printWriter.write(" <div class=\"link-wrapper\">\n" +
                "        <a href=\"/login\" class=\"main-link\">Main page</a>\n" +
                "    </div>");
        printWriter.write("</body></html>");
        printWriter.close();
    }
}
