package com.example.q2_2.Controller;

import com.example.q2_2.API.ApiResponse;
import com.example.q2_2.Model.Book;
import com.example.q2_2.Service.BookService;
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
    public ResponseEntity<?> getbook()
    {
        ArrayList<Book> result =bookService.getAllBook();

        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No Books"));

        }

        return ResponseEntity.status(200).body(result);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }
        bookService.addBook(book);


        return ResponseEntity.status(200).body(new ApiResponse("The Book is Add successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id , @Valid @RequestBody Book book , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }

        boolean isUpdate =bookService.update(id ,book);

        if(isUpdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Update is successful"));

        }

        return ResponseEntity.status(200).body(new ApiResponse("The Id Book is not found"));


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id )
    {


        boolean isUpdate =bookService.deleteBook(id);

        if(isUpdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Delete is successful"));

        }

        return ResponseEntity.status(200).body(new ApiResponse("The Id Book is not found"));


    }

    @GetMapping("getBookName/{bookName}")
    public ResponseEntity<?> getBookName(@PathVariable String bookName)
    {
        Book b1 = bookService.getBookName(bookName);
        if(b1==null)
        {
            return ResponseEntity.status(200).body("Thaer no Book Name Like "+bookName);
        }
        return ResponseEntity.status(200).body(b1);

    }


    @GetMapping("getCategory/{category}")
    public ResponseEntity<?> getCategory(@PathVariable String category)
    {
        ArrayList<Book> result = bookService.getCategory(category);
        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body("Thaer no Book With this category"+category);
        }
        return ResponseEntity.status(200).body(result);

    }

    @GetMapping("getNumperOfPages/{pages}")
    public ResponseEntity<?> getNumperOfPages(@PathVariable int pages)
    {
        ArrayList<Book> result = bookService.getNumperOfPages(pages);
        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body("Thaer no Book With this Pages "+pages);
        }
        return ResponseEntity.status(200).body(result);

    }

    @PutMapping("changeStatus/{bookId}/{userId}")
    public ResponseEntity<?> changeStatus(@PathVariable String bookId ,@PathVariable String userId)
    {
        boolean isChange = bookService.changeStatus(bookId , userId);
        if(isChange)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Book Status is Change"));

        }

        return ResponseEntity.status(200).body(new ApiResponse("The Book Status is Not Change < Must be librrian To Change Status"));
    }

}
