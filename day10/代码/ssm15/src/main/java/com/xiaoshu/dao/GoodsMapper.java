package com.xiaoshu.dao;

import com.xiaoshu.base.dao.BaseMapper;
import com.xiaoshu.entity.Goods;
import com.xiaoshu.entity.GoodsExample;
import com.xiaoshu.entity.GoodsVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper extends BaseMapper<Goods> {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

	List<GoodsVo> findPage(GoodsVo goodsVo);

	List<GoodsVo> getEcharts();
}