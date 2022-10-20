package com.jack.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.common.utils.PageUtils;
import com.jack.gulimall.order.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author jack
 * @email ${email}
 * @date 2022-10-18 18:54:03
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

