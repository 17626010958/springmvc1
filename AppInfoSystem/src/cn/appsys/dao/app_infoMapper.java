package cn.appsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.app_info;
import cn.appsys.pojo.app_version;

public interface app_infoMapper {
	int deleteByPrimaryKey(Long id);

	int insert(app_info record);

	int insertSelective(app_info record);

	app_info selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(app_info record);

	int updateByPrimaryKey(app_info record);

	List<app_info> findAppList(app_info app_info);
	
	List<app_info> findlist(app_info app_info);
    
	app_info findById(@Param("id")Long id);
	
	app_version findbanben(@Param("id")Long id);
	
	List<app_version> findban(@Param("id")Long id);
	
	int shenhe(@Param("id")Long id,@Param("status")Long status);
	
	int findName(@Param("APKName")String APKName);
	
	int dellogo(@Param("id")Long id);
	
	int sxjia(@Param("id")Long id,@Param("status")Long status);
}