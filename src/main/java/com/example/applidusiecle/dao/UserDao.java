package com.example.applidusiecle.dao;

import com.example.applidusiecle.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

	List<User> getAllUsers();

	void insertUser(User user);

	User getUserByEmailOrUsername(@Param("identification") String identification);

	User getUserByEmail(@Param("email") String email);

	User getUserByUsername(String username);

}