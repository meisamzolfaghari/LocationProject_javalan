package ir.javaland.projects.location.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ExceptionHandlerServlet", urlPatterns = "/error-handler")
public class ExceptionHandlerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<html><head><title>Exception/Error Details</title></head><body>" +
                "<h3>Exception Details</h3>" +
                "<ul><li>Servlet Name:" + servletName + "</li>" +
                "<ul><li>Status Code:" + statusCode + "</li>" +
                "<li>Exception Name:" + throwable.getClass().getName() + "</li>" +
                "<li>Requested Uri:" + requestUri + "</li>" +
                "<li>Exception Message:" + throwable.getMessage() + "</li>" +
                "</ul>" +
                "<br><br>" +
                "<a href=\"/HrProject_war/login.html\">Back to Login Page</a>" +
                "</body></html>");
    }
}
