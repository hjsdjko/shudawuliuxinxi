package com.dao;

import com.entity.JijianxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JijianxinxiView;

/**
 * 寄件信息 Dao 接口
 *
 * @author 
 */
public interface JijianxinxiDao extends BaseMapper<JijianxinxiEntity> {

   List<JijianxinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
