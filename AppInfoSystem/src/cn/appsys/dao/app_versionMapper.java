package cn.appsys.dao;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_version;

public interface app_versionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(app_version record);

    int insertSelective(app_version record);

    app_version selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(app_version record);

    int updateByPrimaryKey(app_version record);
    
    app_version findver(@Param("appId")Long id);
    
    int updateapk(@Param("id")Long id);
    
    int updatebb(app_version record);
}