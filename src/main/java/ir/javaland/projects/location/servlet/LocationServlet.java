package ir.javaland.projects.location.servlet;

import ir.javaland.projects.location.model.Location;
import ir.javaland.projects.location.repos.LocationRepos;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "LocationServlet" , urlPatterns = "/secured/location")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Location> locationList = LocationRepos.getInstance().loadAll();
            PrintWriter writer = response.getWriter();
            writer.write("<html>" +
                    "<body>" +
                    "<h2>Location Table</h2>" +
                    "<table>" +
                    "<tr>" +
                    "<td>Country Name</td>" +
                    "<td>Province</td>" +
                    "<td>City</td>" +
                    "<td>Postal Code</td>" +
                    "<td>Address</td>" +
                    "</tr>" +
                    "</table>" +
                    "</body>" +
                    "</html>");
        }catch (HibernateException e){
            throw new ServletException(e);
        }
    }
}
