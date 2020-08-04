package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentExample;
import com.xiaoshu.entity.ContentVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper extends BaseMapper<Content> {
    long countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    List<Content> selectByExample(ContentExample example);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

	List<ContentVo> findPage(ContentVo contentVo);
}