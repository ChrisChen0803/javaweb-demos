package com.chris.mapper;

import com.chris.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();
}
