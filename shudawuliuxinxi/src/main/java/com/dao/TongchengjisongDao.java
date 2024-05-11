package com.dao;

import com.entity.TongchengjisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TongchengjisongView;

/**
 * 同城急送 Dao 接口
 *
 * @author 
 */
public interface TongchengjisongDao extends BaseMapper<TongchengjisongEntity> {

   List<TongchengjisongView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
