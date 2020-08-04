package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Pconpany;
import com.xiaoshu.entity.PconpanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PconpanyMapper extends BaseMapper<Pconpany> {
    long countByExample(PconpanyExample example);

    int deleteByExample(PconpanyExample example);

    List<Pconpany> selectByExample(PconpanyExample example);

    int updateByExampleSelective(@Param("record") Pconpany record, @Param("example") PconpanyExample example);

    int updateByExample(@Param("record") Pconpany record, @Param("example") PconpanyExample example);
}