package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_category;

public interface app_categoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(app_category record);

    int insertSelective(app_category record);

    app_category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(app_category record);

    int updateByPrimaryKey(app_category record);
    
    List<app_category> yiji(@Param("parentId")Integer parentId);
}