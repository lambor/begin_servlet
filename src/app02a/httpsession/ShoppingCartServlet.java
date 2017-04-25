package app02a.httpsession;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by lambor on 17-4-25.
 */
@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/products","/viewProductDetails","/addToCart","/viewCart"})
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = -20L;
    private static final String CART_ATTRIBUTE = "cart";

    private List<Product> products = new ArrayList<>();
    private NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    @Override
    public void init() throws ServletException {
        products.add(new Product(1,"HDTV","Low-cost HDTV",159.95F));
        products.add(new Product(2,"BlueRay Player","High quality",99.95F));
        products.add(new Product(3,"Stero System","5 speaker hifi system with ipod player",129.95F));
        products.add(new Product(4,"iPod Player","iPod plug-in",39.95F));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.endsWith("/products")) {
            sendProductList(resp);
        } else if(uri.endsWith("/viewProductDetails")) {
            sendProductDetails(req,resp);
        } else if(uri.endsWith("/viewCart")) {
            showCart(req,resp);
        }
    }

    private Product getProduct(int productId) {
        for(Product product:products) {
            if(product.getId() == productId)
                return product;
        }
        return null;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = 0;
        int quantity = 0;
        try {
            productId = Integer.parseInt(req.getParameter("id"));
            quantity = Integer.parseInt(req.getParameter("quantity"));
        } catch (NumberFormatException e) {

        }

        Product product = getProduct(productId);
        if(product != null && quantity >= 0) {
            ShoppingItem shoppingItem = new ShoppingItem(product,quantity);
            HttpSession session = req.getSession();
            List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
            if(cart == null) {
                cart = new ArrayList<>();
                session.setAttribute(CART_ATTRIBUTE,cart);
            }
            cart.add(shoppingItem);
        }
        sendProductList(resp);
    }

    private void sendProductList(HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Products</title>" + "</head><body><h2>Products</h2>");
        writer.println("<ul>");
        for(Product product:products) {
            writer.println("<li>" + product.getName() +
                    "(" + currencyFormat.format(product.getPrice()) + ") (" + "<a href='viewProductDetails?id="
                    + product.getId() + "'>Details</a>");
        }
        writer.println("</ul>");
        writer.println("<a href='viewCart'>View Cart</a>");
        writer.println("</body></html>");
    }

    private void sendProductDetails(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer  = resp.getWriter();
        int productId = 0;
        try {
            productId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
        }

        Product product = getProduct(productId);
        if(product != null) {
            writer.println("<html><head>" + "<title>Product Details</title></head>" +
                    "<body><h2>Product Details</h2>" + "<form method='post' action='addToCart'>");
            writer.println("<input type='hidden' name='id' " + "value='" + productId + "'/>");
            writer.println("<style type=\"text/css\">\n" +
                    ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                    ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    ".tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<table class=\"tg\">\n" +
                    "  <tr>\n" +
                    "    <th class=\"tg-031e\">Name:</th>\n" +
                    "    <th class=\"tg-yw4l\">"+ product.getName() +"</th>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-yw4l\">Description:</td>\n" +
                    "    <td class=\"tg-yw4l\">"+ product.getDescription() +"</td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-yw4l\"><input name='quantity'/></td>\n" +
                    "    <td class=\"tg-yw4l\"><input type='submit' value='Buy'/></td>\n" +
                    "  </tr>\n" +
                    "  <tr>\n" +
                    "    <td class=\"tg-yw4l\"><a href='products'>Product List</a></td>\n" +
                    "    <td class=\"tg-yw4l\"></td>\n" +
                    "  </tr>\n" +
                    "</table>");
            writer.println("</form></body>");
        } else {
            writer.println("No product found");
        }
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer  = resp.getWriter();
        writer.println("<html><head><title>Shopping Cart</title></head>");
        writer.println("<body><a href='products'>" + "Product List</a>");
        HttpSession session = req.getSession();
        List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
        if(cart != null) {
            writer.println("<table>");
            writer.println("<style type=\"text/css\">\n" +
                    ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                    ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 20px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                    ".tg .tg-yw4l{vertical-align:top}\n" +
                    "</style>\n" +
                    "<table class=\"tg\">\n" +
                    "  <tr>\n" +
                    "    <th class=\"tg-031e\">Quantity</th>\n" +
                    "    <th class=\"tg-yw4l\">Product</th>\n" +
                    "    <th class=\"tg-yw4l\">Price</th>\n" +
                    "    <th class=\"tg-yw4l\">Amount</th>\n" +
                    "  </tr>\n"
                    );
            double total = 0.0;
            for(ShoppingItem shoppingItem:cart) {
                Product product = shoppingItem.getProduct();
                int quantity = shoppingItem.getQuantity();
                if(quantity != 0) {
                    float price = product.getPrice();
                    double subtotal = price * quantity;
                    total += subtotal;
                    writer.println("  <tr>\n" +
                            "    <td class=\"tg-yw4l\">"+quantity+"</td>\n" +
                            "    <td class=\"tg-yw4l\">"+product.getName()+"</td>\n" +
                            "    <td class=\"tg-yw4l\">"+currencyFormat.format(price)+"</td>\n" +
                            "    <td class=\"tg-yw4l\">"+currencyFormat.format(subtotal)+"</td>\n" +
                            "  </tr>\n");
                }
            }
            writer.println("<tr><td class=\"tg-yw4l\" colspan='4' style='text-align:right'>Total:"+currencyFormat.format(total)+"</td></tr>");

            writer.println("</table>");
        }
        writer.println("</table></body></html>");
    }
}
