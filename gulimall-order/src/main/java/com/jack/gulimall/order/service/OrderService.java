package com.jack.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.common.utils.PageUtils;
import com.jack.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author jack
 * @email ${email}
 * @date 2022-10-18 18:54:03
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

