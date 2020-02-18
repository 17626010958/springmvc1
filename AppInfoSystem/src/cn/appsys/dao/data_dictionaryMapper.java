package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.data_dictionary;

public interface data_dictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(data_dictionary record);

    int insertSelective(data_dictionary record);

    data_dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(data_dictionary record);

    int updateByPrimaryKey(data_dictionary record);
    
    List<data_dictionary> findpt(@Param("typeCode")String typeCode);
    
}