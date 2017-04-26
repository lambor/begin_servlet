package app04a.servlet;

import app04a.model.Address;
import app04a.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lambor on 17-4-26.
 */
@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = -5392874L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Address address = new Address();
        address.setStreetName("Rue D'Anjou");
        address.setStreetNumber("5090B");
        address.setCity("Brossard");
        address.setState("Quebec");
        address.setZipCode("A1A B2B");
        address.setCountry("Cananda");

        Employee employee = new Employee();
        employee.setId(1099);
        employee.setName("Charles Unjeye");
        employee.setAddress(address);
        req.setAttribute("employee",employee);

        Map<String,String> capitals = new HashMap<>();
        capitals.put("China","Beijing");
        capitals.put("Austria","Vienna");
        capitals.put("Australia","Canberra");
        capitals.put("Canada","Ottawa");
        req.setAttribute("capitals",capitals);

        RequestDispatcher rd = req.getRequestDispatcher("/app04a/employee.jsp");
        rd.forward(req,resp);
    }
}
