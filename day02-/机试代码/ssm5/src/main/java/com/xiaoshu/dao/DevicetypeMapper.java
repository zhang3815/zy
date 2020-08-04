package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Devicetype;
import com.xiaoshu.entity.DevicetypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DevicetypeMapper extends BaseMapper<Devicetype> {
    long countByExample(DevicetypeExample example);

    int deleteByExample(DevicetypeExample example);

    List<Devicetype> selectByExample(DevicetypeExample example);

    int updateByExampleSelective(@Param("record") Devicetype record, @Param("example") DevicetypeExample example);

    int updateByExample(@Param("record") Devicetype record, @Param("example") DevicetypeExample example);
}