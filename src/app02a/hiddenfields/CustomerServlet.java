package app02a.hiddenfields;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-4-24.
 */
@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer","/editCustomer","/updateCustomer"})
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private List<Customer> customers = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donald D.");
        customer1.setCity("Miami");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey M.");
        customer2.setCity("Orlando");
        customers.add(customer2);
    }

    private void sendCustomerList(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Customers</title></head>" +
                "<body><h2>Customers</h2>");
        writer.println("<ul>");
        for(Customer customer:customers) {
            writer.println("<li>"+customer.getName()+"("+customer.getName()+") ("+
                    "<a href='editCustomer?id="+customer.getId()+"'>edit</a>)");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }

    private Customer getCustomer(int customerId) {
        for(Customer customer:customers) {
            if(customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    private void sendEditCustomerForm(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int customerId = 0;
        try {
            customerId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {

        }
        Customer customer = getCustomer(customerId);
        if(customer != null) {
            writer.print("<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "\n" +
                    "<style type=\"text/css\">\n" +
                    "    .tg  {border-collapse:collapse;border-spacing:0;}\n" +
                    "    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    "    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    "    .tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<h2>Edit Customer</h2>\n" +
                    "<form method=\"post\" action=\"updateCustomer\">\n" +
                    "    <input type=\"hidden\" name=\"id\" value=\""+customerId+"\"/>\n" +
                    "\n" +
                    "<table class=\"tg\">\n" +
                    "    <tr>\n" +
                    "        <th class=\"tg-031e\">name:</th>\n" +
                    "        <th class=\"tg-yw4l\"><input name=\"name\" value=\""+customer.getName()+"\"></th>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td class=\"tg-yw4l\">address:</td>\n" +
                    "        <td class=\"tg-yw4l\"><input name=\"city\" value=\""+customer.getCity()+"\"></td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td class=\"tg-yw4l\"></td>\n" +
                    "        <td class=\"tg-yw4l\" style=\"text-align: right\"><input type=\"submit\" value=\"Update\"></td>\n" +
                    "    </tr>\n" +
                    "    <tr>\n" +
                    "        <td class=\"tg-yw4l\"><a href=\"customer\">Customer List</a></td>\n" +
                    "        <td class=\"tg-yw4l\"></td>\n" +
                    "    </tr>\n" +
                    "</table>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.endsWith("/customer")) {
            sendCustomerList(resp);
        } else if(uri.endsWith("/editCustomer")) {
            sendEditCustomerForm(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = 0;
        try {
            customerId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {

        }
        Customer customer = getCustomer(customerId);
        if(customer != null) {
            customer.setName(req.getParameter("name"));
            customer.setCity(req.getParameter("city"));
        }
        sendCustomerList(resp);
    }
}
