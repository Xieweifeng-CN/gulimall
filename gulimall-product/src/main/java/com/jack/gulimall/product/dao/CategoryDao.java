package com.jack.gulimall.product.dao;

import com.jack.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author jack
 * @email ${email}
 * @date 2022-10-06 19:07:27
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
