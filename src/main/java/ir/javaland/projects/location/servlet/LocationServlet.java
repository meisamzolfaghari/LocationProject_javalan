package ir.javaland.projects.location.servlet;

import ir.javaland.projects.location.model.Location;
import ir.javaland.projects.location.repos.LocationRepos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LocationServlet" , urlPatterns = "/location")
public class LocationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Location> locationList = LocationRepos.getInstance().loadAll();

    }
}
