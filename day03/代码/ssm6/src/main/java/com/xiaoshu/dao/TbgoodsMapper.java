package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.TbVo;
import com.xiaoshu.entity.Tbgoods;
import com.xiaoshu.entity.TbgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbgoodsMapper extends BaseMapper<Tbgoods> {
    long countByExample(TbgoodsExample example);

    int deleteByExample(TbgoodsExample example);

    List<Tbgoods> selectByExample(TbgoodsExample example);

    int updateByExampleSelective(@Param("record") Tbgoods record, @Param("example") TbgoodsExample example);

    int updateByExample(@Param("record") Tbgoods record, @Param("example") TbgoodsExample example);

	List<TbVo> findPage(TbVo tbVo);
}