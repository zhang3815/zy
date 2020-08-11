package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Goodstype;
import com.xiaoshu.entity.GoodstypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodstypeMapper extends BaseMapper<Goodstype> {
    long countByExample(GoodstypeExample example);

    int deleteByExample(GoodstypeExample example);

    List<Goodstype> selectByExample(GoodstypeExample example);

    int updateByExampleSelective(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);

    int updateByExample(@Param("record") Goodstype record, @Param("example") GoodstypeExample example);
}