package ru.akvine.servlet.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.akvine.servlet.service.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuthPage {
    private final AddPage addPage;

    public void login(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><head>");
        printWriter.write("<style>");
        printWriter.write(".login-container { width: 300px; margin: 0 auto; padding: 20px; background-color: #f9f9f9; border: 1px solid #ccc; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        printWriter.write(".login-title { font-size: 24px; margin-bottom: 20px; }");
        printWriter.write(".input-field { width: 100%; padding: 10px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 3px; }");
        printWriter.write(".login-button { width: 100%; padding: 10px; background-color: #007bff; color: #fff; border: none; border-radius: 3px; cursor: pointer; }");
        printWriter.write(".login-button:hover { background-color: #0056b3; }");
        printWriter.write("</style>");
        printWriter.write("</head><body>");
        printWriter.write("<div class=\"login-container\">");
        printWriter.write("<h2 class=\"login-title\">Login</h2>");
        printWriter.write("<form action=\"/authenticate/login.do\" method=\"post\">");
        printWriter.write("<div>");
        printWriter.write("<label for=\"username\">Username:</label>");
        printWriter.write("<input type=\"text\" class=\"input-field\" placeholder=\"Enter username\" name=\"username\" id=\"username\" required>");
        printWriter.write("<br>");
        printWriter.write("<label for=\"password\">Password:</label>");
        printWriter.write("<input type=\"password\" class=\"input-field\" placeholder=\"Enter password\" name=\"password\" id=\"password\" required>");
        printWriter.write("<br>");
        printWriter.write("<button type=\"submit\" class=\"login-button\">Login</button>");
        printWriter.write("</div>");
        printWriter.write("</form>");
        printWriter.write("</div>");
        printWriter.write("</body></html>");
        printWriter.close();
    }

    public void success(HttpServletResponse response, User user) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        if (user.getRole().equals("ADMIN")) {
            addPage.add(response);
        } else if(user.getRole().equals("SUPER_USER")){
            printWriter.write("<html>");
            printWriter.write("<style>\n" +
                    "        body {\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "            align-items: center;\n" +
                    "            height: 100vh;\n" +
                    "            margin: 0;\n" +
                    "            background-color: #f0f0f0; /* Цвет фона страницы */\n" +
                    "        }\n" +
                    "        iframe {\n" +
                    "            border: 5px solid #007BFF; /* Цвет рамки видео */\n" +
                    "            border-radius: 10px; /* Закругленные углы рамки */\n" +
                    "        }\n" +
                    "    </style>");
            printWriter.write("<body>");
            printWriter.write("<iframe width=\"720\" height=\"480\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ?autoplay=1&amp;mute=1\" frameborder=\"0\" allowfullscreen></iframe>");
            printWriter.write("</body></html>");
            printWriter.close();
        }else {
            printWriter.write("<html><body>");
            printWriter.write("<style>\n" +
                    "        body {\n" +
                    "            display: flex;\n" +
                    "            justify-content: center;\n" +
                    "            align-items: center;\n" +
                    "            height: 100vh;\n" +
                    "            margin: 0;\n" +
                    "            background-color: #007BFF;\n" +
                    "            color: #fff;\n" +
                    "        }\n" +
                    "\n" +
                    "        #clock {\n" +
                    "            font-size: 36px;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div id=\"clock\"></div>\n" +
                    "\n" +
                    "    <script>\n" +
                    "        function numberToRoman(num) {\n" +
                    "            if (num < 1 || num > 3999) return \"NULLA\";\n" +
                    "            const romanNumerals = [\"M\", \"CM\", \"D\", \"CD\", \"C\", \"XC\", \"L\", \"XL\", \"X\", \"IX\", \"V\", \"IV\", \"I\"];\n" +
                    "            const decimalValues = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];\n" +
                    "            let roman = \"\";\n" +
                    "            for (let i = 0; i < decimalValues.length; i++) {\n" +
                    "                while (num >= decimalValues[i]) {\n" +
                    "                    roman += romanNumerals[i];\n" +
                    "                    num -= decimalValues[i];\n" +
                    "                }\n" +
                    "            }\n" +
                    "            return roman;\n" +
                    "        }\n" +
                    "\n" +
                    "        function getCurrentDateTimeInRomanNumerals() {\n" +
                    "            const now = new Date();\n" +
                    "            const year = numberToRoman(now.getFullYear());\n" +
                    "            const month = numberToRoman(now.getMonth() + 1);\n" +
                    "            const day = numberToRoman(now.getDate());\n" +
                    "            const hours = numberToRoman(now.getHours());\n" +
                    "            const minutes = numberToRoman(now.getMinutes());\n" +
                    "            const seconds = numberToRoman(now.getSeconds());\n" +
                    "\n" +
                    "            return `Date: ${year}-${month}-${day}, Time: ${hours}:${minutes}:${seconds}`;\n" +
                    "        }\n" +
                    "        function updateClock() {\n" +
                    "            const clockElement = document.getElementById(\"clock\");\n" +
                    "            clockElement.textContent = getCurrentDateTimeInRomanNumerals();\n" +
                    "        }\n" +
                    "        updateClock();\n" +
                    "        setInterval(updateClock, 1000);\n" +
                    "    </script>");
            printWriter.write("</body></html>");
            printWriter.close();
        }
    }

    public void failure(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<html><body>");
        printWriter.write("<h1>Wrong credentials</h1>");
        printWriter.write("<a href=\"/greeting\">Main page</a>");
        printWriter.write("</body></html>");
        printWriter.close();
    }
}
