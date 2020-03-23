package ir.javaland.projects.location.servlet;

import ir.javaland.projects.location.service.OnlineUserHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OnlineUserServlet", urlPatterns = "/secured/online-user")
public class OnlineUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.write("<html>" +
                "<body>" +
                "<h2>Online Users: </h2>" +
                OnlineUserHandler.getOnlineUser() +
                "<a href=\"/HrProject_war/logout\"> Logout </a>" +
                "</body>" +
                "</html>");
    }
}
