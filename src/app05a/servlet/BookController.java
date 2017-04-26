package app05a.servlet;

import app05a.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-4-26.
 */
@WebServlet(urlPatterns = {"/books"})
public class BookController extends HttpServlet {
    private static final long serialVersionUID = -234237L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("978-0980839616","Java7",45.00);
        Book book2 = new Book("978-0980331608","Struts2",49.95);
        Book book3 = new Book("978-0975212820","MySQL",39.95);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        req.setAttribute("books",books);
        RequestDispatcher rd = req.getRequestDispatcher("/app05a/books.jsp");
        rd.forward(req,resp);
    }
}
