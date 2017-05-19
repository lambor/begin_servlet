package service.app19a;

import app19a.domain.Book;
import app19a.domain.Category;

import java.util.List;

/**
 * Created by lambor on 17-5-18.
 */
public interface BookService {
    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();
}
