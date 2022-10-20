package com.jack.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.common.utils.PageUtils;
import com.jack.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author jack
 * @email ${email}
 * @date 2022-10-06 19:07:27
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

