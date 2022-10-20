package com.jack.gulimall.member.dao;

import com.jack.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author jack
 * @email ${email}
 * @date 2022-10-18 18:48:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
