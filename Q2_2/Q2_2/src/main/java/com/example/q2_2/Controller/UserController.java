package com.example.q2_2.Controller;


import com.example.q2_2.API.ApiResponse;
import com.example.q2_2.Model.Book;
import com.example.q2_2.Model.User;
import com.example.q2_2.Service.UserService;
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
    public ResponseEntity<?> getUser()
    {
        ArrayList<User> result = userService.getAllUser();

        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("Thare No User"));

        }

        return ResponseEntity.status(200).body(result);
    }


    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody @Valid User user , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }
        userService.addUser(user);


        return ResponseEntity.status(200).body(new ApiResponse("The User is Add successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id , @Valid @RequestBody User user , Errors errors)
    {
        if(errors.hasErrors())
        {
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));

        }

        boolean isUpdate = userService.update(id , user);

        if(isUpdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Update is successful"));

        }

        return ResponseEntity.status(200).body(new ApiResponse("The Id User is not found"));


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id )
    {


        boolean isUpdate = userService.deleteUser(id);

        if(isUpdate)
        {
            return ResponseEntity.status(200).body(new ApiResponse("The Delete is successful"));

        }

        return ResponseEntity.status(200).body(new ApiResponse("The Id User is not found"));


    }

    @GetMapping("/getBalance/{balance}")
    public ResponseEntity<?> getBalance(@PathVariable double balance)
    {
        ArrayList<User> result = userService.getBalance(balance);

        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("There no balance like "+balance+" Or Above"));

        }

        return ResponseEntity.status(200).body(result);

    }


    @GetMapping("/getAge/{age}")
    public ResponseEntity<?> getAge(@PathVariable int age)
    {
        ArrayList<User> result = userService.getAge(age);

        if(result.isEmpty())
        {
            return ResponseEntity.status(200).body(new ApiResponse("There no age like "+age+" Or Above"));

        }

        return ResponseEntity.status(200).body(result);

    }


}
