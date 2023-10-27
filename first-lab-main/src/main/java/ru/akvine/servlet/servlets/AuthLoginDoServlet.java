package ru.akvine.servlet.servlets;

import lombok.RequiredArgsConstructor;
import ru.akvine.servlet.pages.AuthPage;
import ru.akvine.servlet.service.SecurityService;
import ru.akvine.servlet.service.User;
import ru.akvine.servlet.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/authenticate/login.do")
@RequiredArgsConstructor
public class AuthLoginDoServlet extends HttpServlet {
    private final UserService userService;
    private final SecurityService securityService;
    private final AuthPage authPage;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (securityService.checkAuth(req.getParameter("username"), req.getParameter("password"))) {
            User user = userService.getByUsername(req.getParameter("username"));
            authPage.success(resp, user);
        } else {
            authPage.failure(resp);
        }
    }
}
