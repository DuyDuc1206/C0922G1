package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static List<User> userList = new ArrayList<>();
    static {
        userList.add(new User("DucNguyen","12345","Duc","duc@gmail.com",28));
        userList.add(new User("HuuNhu","12345","Nhu","nhu@gmail.com",26));
        userList.add(new User("MyLinh","12345","Linh","linh@gmail.com",24));
    }
    public static User checkLogin(Login login){
        for(User user:userList){
            if (user.getAccount().equals(login.getAccount()) && (user.getPassword().equals(login.getPassword()))){
                return user;
            }
        }
        return null;
    }
}
