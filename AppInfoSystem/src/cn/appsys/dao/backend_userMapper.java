package cn.appsys.dao;

import cn.appsys.pojo.backend_user;

public interface backend_userMapper {
    int deleteByPrimaryKey(Long id);

    int insert(backend_user record);

    int insertSelective(backend_user record);

    backend_user selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(backend_user record);

    int updateByPrimaryKey(backend_user record);
    
    backend_user findUser(backend_user backend_user);
}