package ru.akvine.servlet.servlets;

import lombok.RequiredArgsConstructor;
import ru.akvine.servlet.pages.AuthPage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
@RequiredArgsConstructor
public class AuthLoginServlet extends HttpServlet {
    private final AuthPage authPage;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        authPage.login(resp);
    }
}
