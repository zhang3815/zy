package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.TbVo;
import com.xiaoshu.entity.Tbstuday;
import com.xiaoshu.entity.TbstudayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbstudayMapper extends BaseMapper<Tbstuday> {
    long countByExample(TbstudayExample example);

    int deleteByExample(TbstudayExample example);

    List<Tbstuday> selectByExample(TbstudayExample example);

    int updateByExampleSelective(@Param("record") Tbstuday record, @Param("example") TbstudayExample example);

    int updateByExample(@Param("record") Tbstuday record, @Param("example") TbstudayExample example);

	List<TbVo> findPage(TbVo tbVo);

	List<TbVo> getEcharts();
}