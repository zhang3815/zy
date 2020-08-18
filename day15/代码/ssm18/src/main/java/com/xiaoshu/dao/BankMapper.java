package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Bank;
import com.xiaoshu.entity.BankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankMapper extends BaseMapper<Bank> {
    long countByExample(BankExample example);

    int deleteByExample(BankExample example);

    List<Bank> selectByExample(BankExample example);

    int updateByExampleSelective(@Param("record") Bank record, @Param("example") BankExample example);

    int updateByExample(@Param("record") Bank record, @Param("example") BankExample example);
}