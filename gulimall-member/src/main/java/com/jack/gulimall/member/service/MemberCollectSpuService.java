package com.jack.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jack.common.utils.PageUtils;
import com.jack.gulimall.member.entity.MemberCollectSpuEntity;

import java.util.Map;

/**
 * 会员收藏的商品
 *
 * @author jack
 * @email ${email}
 * @date 2022-10-18 18:48:18
 */
public interface MemberCollectSpuService extends IService<MemberCollectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

