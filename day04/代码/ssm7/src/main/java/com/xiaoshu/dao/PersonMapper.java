package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.PVo;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends BaseMapper<Person> {
    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    List<Person> selectByExample(PersonExample example);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

	List<PVo> findPage(PVo pVo);
}