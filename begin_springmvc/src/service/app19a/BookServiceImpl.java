package service.app19a;

import app19a.domain.Book;
import app19a.domain.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lambor on 17-5-18.
 */
@Service
public class BookServiceImpl implements BookService {

    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        categories = new ArrayList<>();
        Category category1 = new Category(1,"Computing");
        Category category2 = new Category(2,"Travel");
        Category category3 = new Category(3,"Health");
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        books = new ArrayList<>();
        books.add(new Book(1L,"9780980839623","Servlet & JSP: A Tutorial",category1,"Budi"));
        books.add(new Book(2L,"9780980839630","C#: A Beginner's Tutorial",category1,"Jayden"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        for(Category category:categories) {
            if(category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for(int i=0;i<bookCount;i++) {
            if(books.get(i).getId() == book.getId()) {
                books.set(i,book);
                return book;
            }
        }
        return null;
    }

    @Override
    public Book get(long id) {
        for(Book book:books) {
            if(book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public long getNextId() {
        long id = 0L;
        for(Book book:books) {
            if(book.getId() > id) {
                id = book.getId();
            }
        }
        return id+1;
    }
}
