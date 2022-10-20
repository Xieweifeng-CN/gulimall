package com.jack.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.common.utils.PageUtils;
import com.jack.gulimall.coupon.entity.CouponSpuCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券分类关联
 *
 * @author jack
 * @email ${email}
 * @date 2022-10-06 21:15:42
 */
public interface CouponSpuCategoryRelationService extends IService<CouponSpuCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

