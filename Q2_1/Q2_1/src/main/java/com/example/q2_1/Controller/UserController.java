package com.example.q2_1.Controller;


import com.example.q2_1.API.ApiResponse;
import com.example.q2_1.Model.Book;
import com.example.q2_1.Model.User;
import com.example.q2_1.Service.BookService;
import com.example.q2_1.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser()
    {
        ArrayList<User> result = userService.getAllUser();

        if (result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No User"));

        }
        return ResponseEntity.status(200).body(result);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }


        userService.addUser(user);

        return ResponseEntity.status(200).body(new ApiResponse("The User is add Successful"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> upDateUser(@PathVariable String id , @Valid @RequestBody User user , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }        boolean isupdate = userService.upDateUser(id ,user);

        if(isupdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The upDate is successful"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("The User Id is not found "));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id)
    {
        boolean isDelete= userService.deleteUser(id);

        if(isDelete)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The User is delete successfully"));

        }

        return ResponseEntity.status(400).body(new ApiResponse("The book is not found"));


    }



    @GetMapping("/getAllBalance/{balance}")
    public ResponseEntity<?> getAllBalance(@PathVariable double balance)
    {
        ArrayList<User> result = userService.getAllBalance(balance);

        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("There no Balance Like That"));

        }

        return ResponseEntity.status(200).body(result);
    }


    @GetMapping("/getAllAge/{age}")
    public ResponseEntity<?> getAllAge(@PathVariable int age) {
        ArrayList<User> result = userService.getAllAge(age);

        if (result.isEmpty()) {
            return ResponseEntity.status(200).body(new ApiResponse("There no Ages Like That"));

        }

        return ResponseEntity.status(200).body(result);
    }

}
