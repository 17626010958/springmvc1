package cn.appsys.dao;

import cn.appsys.pojo.dev_user;

public interface dev_userMapper {
    int deleteByPrimaryKey(Long id);

    int insert(dev_user record);

    int insertSelective(dev_user record);

    dev_user selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(dev_user record);

    int updateByPrimaryKey(dev_user record);
    
    dev_user findUser(dev_user dev_user);
}