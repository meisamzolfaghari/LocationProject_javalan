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

@WebServlet(name = "LocationServlet", urlPatterns = "/secured/location")
public class LocationServlet extends HttpServlet {

    private static final String TD_TAG = "<td>%s</td>";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Location> locationList = LocationRepos.getInstance().loadAll();
            String action = request.getParameter("action");
            String loc_id = request.getParameter("loc_id");

            if (action != null) {
                if (loc_id == null || loc_id.trim().equals(""))
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                else {
                    if (loc_id.matches("\\d+"))
                        LocationRepos.getInstance().deleteById(Long.parseLong(loc_id));
                    else
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
                response.sendRedirect("/HrProject_war/secured/location");
            }
            PrintWriter writer = response.getWriter();
            writer.write("<html>" +
                    "<body>" +
                    "<h2>Location Table</h2>" +
                    "<table border=10px>" +
                    "<tr>" +
                    "<td>Country Name</td>" +
                    "<td>Province</td>" +
                    "<td>City</td>" +
                    "<td>Postal Code</td>" +
                    "<td>Address</td>" +
                    "<td>Delete</td>" +
                    "</tr>");
            for (Location location : locationList) {
                writer.write("<tr>");
                writer.write(String.format(TD_TAG, location.getCountry()));
                writer.write(String.format(TD_TAG, location.getStateProvince()));
                writer.write(String.format(TD_TAG, location.getCity()));
                writer.write(String.format(TD_TAG, location.getPostalCode()));
                writer.write(String.format(TD_TAG, location.getStreetAddress()));
                writer.write(String.format(TD_TAG, "<a href=\"/HrProject_war/secured/location?action=delete&loc_id=" +
                        location.getId() + "\">Delete</a>"));
                writer.write("</tr>");
            }
            writer.write("</table>" +
                    "</body>" +
                    "</html>");
        } catch (HibernateException e) {
            throw new ServletException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
