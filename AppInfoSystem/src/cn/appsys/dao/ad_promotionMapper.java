package cn.appsys.dao;

import cn.appsys.pojo.ad_promotion;

public interface ad_promotionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ad_promotion record);

    int insertSelective(ad_promotion record);

    ad_promotion selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ad_promotion record);

    int updateByPrimaryKey(ad_promotion record);
}