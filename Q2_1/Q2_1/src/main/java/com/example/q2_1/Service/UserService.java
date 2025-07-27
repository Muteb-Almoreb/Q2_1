package com.example.q2_1.Service;


import com.example.q2_1.Model.Book;
import com.example.q2_1.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUser() {
        return users;

    }

    public void addUser(User user) {
        users.add(user);

    }

    public boolean upDateUser(String id, User user) {
        for (User u : users) {
            if (u.getId().equalsIgnoreCase(id)) {
                users.set(users.indexOf(u), user);
                return true;

            }
        }

        return false;
    }


    public boolean deleteUser(String id) {
        for (User u : users) {
            if (u.getId().equalsIgnoreCase(id)) {
                users.remove(u);
                return true;

            }
        }
        return false;
    }

    public ArrayList<User> getAllBalance(double balance)
    {
        ArrayList<User>  usersBalance = new ArrayList<>();
        for (User u : users)
        {
            if(u.getBalance()>=balance)
            {
                usersBalance.add(u);


            }
        }
        return usersBalance;
    }


    public ArrayList<User> getAllAge(int age)
    {
        ArrayList<User>  usersAge = new ArrayList<>();
        for (User u : users)
        {
            if(u.getAge()>=age)
            {
                usersAge.add(u);


            }
        }
        return usersAge;
    }


    public ArrayList<User> getUsers()
    {
        return users;

    }




}

