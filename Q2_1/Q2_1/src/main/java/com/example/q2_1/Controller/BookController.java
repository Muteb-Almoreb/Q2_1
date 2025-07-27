package com.example.q2_1.Controller;

import com.example.q2_1.API.ApiResponse;
import com.example.q2_1.Model.Book;
import com.example.q2_1.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/getAllBook")
    public ResponseEntity<?> getAllBook()
    {
        ArrayList<Book> result = bookService.getAllBook();

        if (result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No Books"));

        }
        return ResponseEntity.status(200).body(result);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }


                bookService.addBook(book);

        return ResponseEntity.status(200).body(new ApiResponse("The book is add S"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDatebook(@PathVariable String id ,@Valid @RequestBody Book book , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }        boolean isupdate = bookService.upDateBook(id , book);

        if(isupdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The upDate is successful"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("The Book Id is not found "));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable String id)
    {
        boolean isDelete= bookService.deleteBook(id);

        if(isDelete)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The book is delete successfully"));

        }

        return ResponseEntity.status(400).body(new ApiResponse("The book is not found"));


    }

    @GetMapping("/getbookname/{bookname}")
    public ResponseEntity getBookName(@PathVariable String bookname)
    {

                Book book= bookService.getBookname(bookname);
                if(book==null)
                {
                    return ResponseEntity.status(400).body(new ApiResponse("Thaer No books name Like "+bookname));

                }
                return ResponseEntity.status(200).body(book);

    }

    @GetMapping("/getBooksCategory/{category}")
    public ResponseEntity<?> getAllBookCategory(@PathVariable String category)
    {
        ArrayList<Book> result = bookService.getAllBookCategory(category);

        if (result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No book Like This Category"));

        }

        return ResponseEntity.status(200).body(result);
    }


    @GetMapping("/getBookpages/{pages}")
    public ResponseEntity<?> getBookpages(@PathVariable int pages)
    {
        ArrayList<Book> result = bookService.getBookpages(pages);

        if (result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No book Like This Pages or above"));

        }

        return ResponseEntity.status(200).body(result);
    }


    @PutMapping("/ChangStatusOfBook/{idBook}/{idUser}")
    public ResponseEntity<?> ChangStatusOfBook(@PathVariable String idBook ,@PathVariable String idUser)
    {
        boolean isChange = bookService.ChangStatusOfBook(idBook,idUser);

        if (isChange)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Book Status is change"));

        }

        return ResponseEntity.status(400).body(new ApiResponse("The Book status is Not Change , must be the user is librarian"));
    }




}
