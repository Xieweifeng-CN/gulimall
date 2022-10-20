package com.jack.gulimall.coupon.dao;

import com.jack.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author jack
 * @email ${email}
 * @date 2022-10-06 21:15:42
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
