package ru.akvine.servlet.servlets;

import lombok.RequiredArgsConstructor;
import ru.akvine.servlet.pages.AddPage;
import ru.akvine.servlet.service.User;
import ru.akvine.servlet.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add.do")
@RequiredArgsConstructor
public class AddDoServlet extends HttpServlet {
    private final UserService userService;
    private final AddPage addPage;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = new User()
                .setUsername(req.getParameter("username"))
                .setPassword(req.getParameter("password"))
                .setEmail(req.getParameter("email"))
                .setPhone(req.getParameter("phone"))
                .setRole("USER");

        userService.save(user);
        addPage.add(resp);
    }
}
