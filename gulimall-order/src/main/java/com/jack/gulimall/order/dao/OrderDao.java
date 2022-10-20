package com.jack.gulimall.order.dao;

import com.jack.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author jack
 * @email ${email}
 * @date 2022-10-18 18:54:03
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
