package com.softusing.jiaokaibo.service;

import com.softusing.jiaokaibo.domain.Book;
import com.softusing.jiaokaibo.domain.User;
import com.softusing.jiaokaibo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImps{
    @Autowired
    private UserMapper userMapper;

    public int save(User user) {
        return userMapper.insert(user);
    }
    public boolean login(User user) {
        String name = user.getUsername();
        String password = user.getPassword();
        List<User> userList = userMapper.selectByUsername(name);
        if (userList == null) {
            return false;
        } else {
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}


