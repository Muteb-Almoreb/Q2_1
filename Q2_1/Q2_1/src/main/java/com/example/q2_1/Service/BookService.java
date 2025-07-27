package com.example.q2_1.Service;

import com.example.q2_1.Model.Book;
import com.example.q2_1.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BookService {


    private final UserService userService;

    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getAllBook() {
        return books;

    }

    public void addBook(Book book) {
        books.add(book);

    }

    public boolean upDateBook(String id, Book book) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                books.set(books.indexOf(b), book);
                return true;

            }
        }

        return false;
    }


    public boolean deleteBook(String id) {
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id)) {
                books.remove(b);
                return true;

            }
        }
        return false;
    }

    public Book getBookname(String bookName)
    {

        for (Book b : books)
        {
            if(b.getName().equalsIgnoreCase(bookName))
            {
                return b;

            }
        }
        return null;
    }

    public ArrayList<Book> getAllBookCategory(String category)
    {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : books)
        {
            if(b.getCategory().equalsIgnoreCase(category))
            {
                result.add(b);

            }
        }
        return result;
    }

    public ArrayList<Book> getBookpages(int pages)
    {
        ArrayList<Book> result = new ArrayList<>();
        for (Book b : books)
        {
            if(b.getNumber_of_pages()>=pages)
            {
                result.add(b);

            }
        }
        return result;


    }

    public boolean ChangStatusOfBook(String idBook ,String idUser )
    {
        ArrayList<User> users = userService.getUsers();
        for (User u : users )
        {
            if(u.getId().equalsIgnoreCase(idUser))
            {
                if(u.getRole().equalsIgnoreCase("librarian"))
                {
                    for (Book b : books)
                    {
                        if (b.getId().equalsIgnoreCase(idBook))
                        {
                            if(b.isAvailable())
                            {
                                b.setAvailable(false);
                                return true;
                            }
                            else
                                b.setAvailable(true);
                            return true;

                        }
                    }
                }

            }

        }
        return false;
    }


}

