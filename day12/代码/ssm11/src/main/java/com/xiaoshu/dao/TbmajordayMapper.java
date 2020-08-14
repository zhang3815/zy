package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Tbmajorday;
import com.xiaoshu.entity.TbmajordayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbmajordayMapper extends BaseMapper<Tbmajorday> {
    long countByExample(TbmajordayExample example);

    int deleteByExample(TbmajordayExample example);

    List<Tbmajorday> selectByExample(TbmajordayExample example);

    int updateByExampleSelective(@Param("record") Tbmajorday record, @Param("example") TbmajordayExample example);

    int updateByExample(@Param("record") Tbmajorday record, @Param("example") TbmajordayExample example);
}