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
import java.util.List;

@WebServlet(name = "LocationServlet", urlPatterns = "/secured/location")
public class LocationServlet extends HttpServlet {

//    private static final String TD_TAG = "<td>%s</td>";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null || action.trim().equals("")) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            if (action.equals("edit")) {
                String locationId = request.getParameter("locationId");
                String city = request.getParameter("city");
                String stateProvince = request.getParameter("stateProvince");
                String postalCode = request.getParameter("postalCode");
                String streetAddress = request.getParameter("streetAddress");
                Location location = LocationRepos.getInstance().loadById(Long.parseLong(locationId));
                location.setCity(city);
                location.setStateProvince(stateProvince);
                location.setPostalCode(postalCode);
                location.setStreetAddress(streetAddress);
                LocationRepos.getInstance().update(location);
                response.sendRedirect( getServletContext().getContextPath() + "/secured/location");
            } else if (action.equals("add")) {
                String city = request.getParameter("city");
                String stateProvince = request.getParameter("stateProvince");
                String postalCode = request.getParameter("postalCode");
                String streetAddress = request.getParameter("streetAddress");
                Location location = new Location(streetAddress, postalCode, city, stateProvince);
                LocationRepos.getInstance().save(location);
                response.sendRedirect( getServletContext().getContextPath() + "/secured/location");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Location> locationList = LocationRepos.getInstance().loadAll();
            String action = request.getParameter("action");
            String loc_id = request.getParameter("loc_id");

            if (action != null) {
                if (loc_id != null && !loc_id.trim().equals("") && loc_id.matches("\\d+")) {
                    if (action.equals("delete"))
                        LocationRepos.getInstance().deleteById(Long.parseLong(loc_id));
                    else if (action.equals("edit")) {
                        Location location = LocationRepos.getInstance().loadById(Long.parseLong(loc_id));
                        request.setAttribute("location", location);
                        request.getRequestDispatcher("/edit-location.jsp").forward(request, response);
                    }
                } else if (action.equals("add"))
                    request.getRequestDispatcher("/add-location.jsp").forward(request, response);
                else
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

            request.setAttribute("LocationList", locationList);
            request.getRequestDispatcher("/location-list.jsp")
                    .forward(request, response);

//            PrintWriter writer = response.getWriter();
//            writer.write("<html>" +
//                    "<body>" +
//                    "<h2>Location Table</h2>" +
//                    "<table border=10px>" +
//                    "<tr>" +
//                    "<td>Country Name</td>" +
//                    "<td>Province</td>" +
//                    "<td>City</td>" +
//                    "<td>Postal Code</td>" +
//                    "<td>Address</td>" +
//                    "<td>Delete</td>" +
//                    "<td>Edit</td>" +
//                    "</tr>");
//            for (Location location : locationList) {
//                writer.write("<tr>");
//                writer.write(String.format(TD_TAG, location.getCountry()));
//                writer.write(String.format(TD_TAG, location.getStateProvince()));
//                writer.write(String.format(TD_TAG, location.getCity()));
//                writer.write(String.format(TD_TAG, location.getPostalCode()));
//                writer.write(String.format(TD_TAG, location.getStreetAddress()));
//                writer.write(String.format(TD_TAG, "<a href=\"/HrProject_war/secured/location?action=delete&loc_id=" +
//                        location.getId() + "\">Delete</a>"));
//                writer.write(String.format(TD_TAG, "<a href=\"/HrProject_war/secured/location?action=edit&loc_id=" +
//                        location.getId() + "\">Edit</a>"));
//                writer.write("</tr>");
//            }
//            writer.write("</table>" +
//                    "</body>" +
//                    "</html>");
        } catch (HibernateException e) {
            throw new ServletException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
