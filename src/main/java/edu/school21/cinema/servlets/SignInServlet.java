package edu.school21.cinema.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer visitCounter = (Integer) session.getAttribute("visitors");
        if (visitCounter == null)
                visitCounter = 0;
        else
            visitCounter++;
        session.setAttribute("visitors", visitCounter);
        String userName = req.getParameter("user");
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter(); //формируем ответ пользователю
        if (userName == null) {
            printWriter.write("Hello, Anonimus!");
        } else {
            printWriter.write("Hello Bro");
        }
        printWriter.write("Page visits for " + visitCounter + " times");
        printWriter.close();
    }
}
