package org.myapp.proxy;

import org.myapp.bean.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /*
     四大原则
     1. 接口方法名 == mapper.xml文件中的id名一致
     2. 接口方法返回类型 == mapper.xml返回类型一致
     3. 接口方法入参类型 == mapper.xml入参类型一致
     4. 命名空间要绑定此接口
      */
    // 通过Map添加用户---------测试trim
    void insertUserByMap(Map map);
    // 通过Map更新用户---------测试set
    void updateUserByMap(Map map);
    // 通过ID删除用户（测试foreach标签）
    void deleteUserByIDList(List list);

}
