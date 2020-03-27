package ir.javaland.projects.location.servlet;

import ir.javaland.projects.location.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

//    static Map<String, User> userMap = new ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String firstName = req.getParameter("first_name");
        String lastName = req.getParameter("last_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (firstName == null || lastName == null) {
            firstName = "";
            lastName = "";
        }

        if (username == null || username.trim().equals("")
                || password == null || password.trim().equals("")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            User user = new User(firstName, lastName, username, password);
            //todo implement authentication
            HttpSession session = req.getSession(true);
            session.setAttribute("sec_data", user);
//            session.setMaxInactiveInterval(30);
            resp.sendRedirect("/HrProject_war/secured/location");
        }
    }
}
