package org.myapp.mapper;

import org.myapp.bean.User;

public interface UserMapper {

  User queryUserById(Integer id);
}
