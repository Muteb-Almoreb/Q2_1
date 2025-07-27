package com.example.q2_2.Service;

import com.example.q2_2.Model.Book;
import com.example.q2_2.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class BookService {

    private final UserService userService;

    ArrayList<Book> books= new ArrayList<>();

    public ArrayList<Book> getAllBook()
    {
        return books;

    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public boolean update(String id , Book book)
    {
        for (Book b: books)
        {
            if(b.getId().equalsIgnoreCase(id))
            {
                books.set(books.indexOf(b) , book);
                    return true;
            }

        }

        return false;

    }



    public boolean deleteBook(String id)
    {
        for (Book b : books)
        {
            if(b.getId().equalsIgnoreCase(id))
            {
                books.remove(b);
                    return true;
            }
        }
        return false;
    }

//Create an endpoint that takes a Book name and then returns one Book.
//Create an endpoint that takes a category then return all books with this category.
//Create an endpoint that takes a number of pages and returns all Books with this number of pages or above.


    public Book getBookName(String bookName)
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

    public ArrayList<Book> getCategory(String category)
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


    public ArrayList<Book> getNumperOfPages(int pages)
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

    //Create an endpoint that changes a book's status to unavailable (Only the librarian can change the status of the book)

    public boolean changeStatus(String idBook , String idUser)
    {
        ArrayList<User> users = userService.getusers();

        for (User u : users)
        {
            if(u.getId().equalsIgnoreCase(idUser))
            {
                if(u.getRole().equalsIgnoreCase("librarian"))
                {
                    for (Book b: books)
                    {
                        if(b.getId().equalsIgnoreCase(idBook))
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
