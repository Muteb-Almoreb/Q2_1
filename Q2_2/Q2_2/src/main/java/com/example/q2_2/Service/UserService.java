package com.example.q2_2.Service;

import com.example.q2_2.Model.Book;
import com.example.q2_2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {


    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUser()
    {
        return users;

    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public boolean update(String id , User user)
    {
        for (User u: users)
        {
            if(u.getId().equalsIgnoreCase(id))
            {
                users.set(users.indexOf(u) , user);
                return true;
            }

        }

        return false;

    }



    public boolean deleteUser(String id)
    {
        for (User u : users)
        {
            if(u.getId().equalsIgnoreCase(id))
            {
                users.remove(u);
                return true;
            }
        }
        return false;
    }

    //Create an endpoint that takes a balance and returns all users with this balance or above.
    //Create an endpoint that takes an age then return all Users who have this age or above.


    public ArrayList<User> getBalance(double balance)
    {
        ArrayList<User> result = new ArrayList<>();

        for (User u : users)
        {
            if(u.getBalance()>= balance)
            {
                result.add(u);
            }

        }
        return result;
    }


    public ArrayList<User> getAge(double age)
    {
        ArrayList<User> result = new ArrayList<>();

        for (User u : users)
        {
            if(u.getAge()>=age)
            {
                result.add(u);
            }

        }
        return result;
    }


    public ArrayList<User> getusers()
    {
        return users;


    }
}
