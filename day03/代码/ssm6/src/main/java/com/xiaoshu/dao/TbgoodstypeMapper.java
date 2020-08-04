package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Tbgoodstype;
import com.xiaoshu.entity.TbgoodstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbgoodstypeMapper extends BaseMapper<Tbgoodstype> {
    long countByExample(TbgoodstypeExample example);

    int deleteByExample(TbgoodstypeExample example);

    List<Tbgoodstype> selectByExample(TbgoodstypeExample example);

    int updateByExampleSelective(@Param("record") Tbgoodstype record, @Param("example") TbgoodstypeExample example);

    int updateByExample(@Param("record") Tbgoodstype record, @Param("example") TbgoodstypeExample example);

	List<Tbgoodstype> getEcharts();
}