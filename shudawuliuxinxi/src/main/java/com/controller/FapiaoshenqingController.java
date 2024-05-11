
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 发票申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fapiaoshenqing")
public class FapiaoshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(FapiaoshenqingController.class);

    @Autowired
    private FapiaoshenqingService fapiaoshenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private JijianxinxiService jijianxinxiService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fapiaoshenqingService.queryPage(params);

        //字典表数据转换
        List<FapiaoshenqingView> list =(List<FapiaoshenqingView>)page.getList();
        for(FapiaoshenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FapiaoshenqingEntity fapiaoshenqing = fapiaoshenqingService.selectById(id);
        if(fapiaoshenqing !=null){
            //entity转view
            FapiaoshenqingView view = new FapiaoshenqingView();
            BeanUtils.copyProperties( fapiaoshenqing , view );//把实体数据重构到view中

                //级联表
                JijianxinxiEntity jijianxinxi = jijianxinxiService.selectById(fapiaoshenqing.getJijianxinxiId());
                if(jijianxinxi != null){
                    BeanUtils.copyProperties( jijianxinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJijianxinxiId(jijianxinxi.getId());
                    view.setJijianxinxiYonghuId(jijianxinxi.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fapiaoshenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FapiaoshenqingEntity fapiaoshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fapiaoshenqing:{}",this.getClass().getName(),fapiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fapiaoshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FapiaoshenqingEntity> queryWrapper = new EntityWrapper<FapiaoshenqingEntity>()
            .eq("jijianxinxi_id", fapiaoshenqing.getJijianxinxiId())
            .eq("yonghu_id", fapiaoshenqing.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FapiaoshenqingEntity fapiaoshenqingEntity = fapiaoshenqingService.selectOne(queryWrapper);
        if(fapiaoshenqingEntity==null){
            fapiaoshenqing.setFapiaoshenqingYesnoTypes(1);
            fapiaoshenqing.setInsertTime(new Date());
            fapiaoshenqing.setCreateTime(new Date());
            fapiaoshenqingService.insert(fapiaoshenqing);
            return R.ok();
        }else {
            return R.error(511,"请不要重复申请");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FapiaoshenqingEntity fapiaoshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fapiaoshenqing:{}",this.getClass().getName(),fapiaoshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fapiaoshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FapiaoshenqingEntity> queryWrapper = new EntityWrapper<FapiaoshenqingEntity>()
            .notIn("id",fapiaoshenqing.getId())
            .andNew()
            .eq("jijianxinxi_id", fapiaoshenqing.getJijianxinxiId())
            .eq("yonghu_id", fapiaoshenqing.getYonghuId())
            .eq("fapiaoshenqing_yesno_types", fapiaoshenqing.getFapiaoshenqingYesnoTypes())
            .eq("fapiaoshenqing_yesno_text", fapiaoshenqing.getFapiaoshenqingYesnoText())
            .eq("insert_time", fapiaoshenqing.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FapiaoshenqingEntity fapiaoshenqingEntity = fapiaoshenqingService.selectOne(queryWrapper);
        if(fapiaoshenqingEntity==null){
            fapiaoshenqingService.updateById(fapiaoshenqing);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fapiaoshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FapiaoshenqingEntity> fapiaoshenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FapiaoshenqingEntity fapiaoshenqingEntity = new FapiaoshenqingEntity();
//                            fapiaoshenqingEntity.setJijianxinxiId(Integer.valueOf(data.get(0)));   //寄件信息 要改的
//                            fapiaoshenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fapiaoshenqingEntity.setFapiaoshenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            fapiaoshenqingEntity.setFapiaoshenqingYesnoText(data.get(0));                    //申请备注 要改的
//                            fapiaoshenqingEntity.setInsertTime(date);//时间
//                            fapiaoshenqingEntity.setCreateTime(date);//时间
                            fapiaoshenqingList.add(fapiaoshenqingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fapiaoshenqingService.insertBatch(fapiaoshenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fapiaoshenqingService.queryPage(params);

        //字典表数据转换
        List<FapiaoshenqingView> list =(List<FapiaoshenqingView>)page.getList();
        for(FapiaoshenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FapiaoshenqingEntity fapiaoshenqing = fapiaoshenqingService.selectById(id);
            if(fapiaoshenqing !=null){


                //entity转view
                FapiaoshenqingView view = new FapiaoshenqingView();
                BeanUtils.copyProperties( fapiaoshenqing , view );//把实体数据重构到view中

                //级联表
                    JijianxinxiEntity jijianxinxi = jijianxinxiService.selectById(fapiaoshenqing.getJijianxinxiId());
                if(jijianxinxi != null){
                    BeanUtils.copyProperties( jijianxinxi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJijianxinxiId(jijianxinxi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fapiaoshenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FapiaoshenqingEntity fapiaoshenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fapiaoshenqing:{}",this.getClass().getName(),fapiaoshenqing.toString());
        Wrapper<FapiaoshenqingEntity> queryWrapper = new EntityWrapper<FapiaoshenqingEntity>()
            .eq("jijianxinxi_id", fapiaoshenqing.getJijianxinxiId())
            .eq("yonghu_id", fapiaoshenqing.getYonghuId())
            .eq("fapiaoshenqing_yesno_types", fapiaoshenqing.getFapiaoshenqingYesnoTypes())
            .eq("fapiaoshenqing_yesno_text", fapiaoshenqing.getFapiaoshenqingYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FapiaoshenqingEntity fapiaoshenqingEntity = fapiaoshenqingService.selectOne(queryWrapper);
        if(fapiaoshenqingEntity==null){
            fapiaoshenqing.setFapiaoshenqingYesnoTypes(1);
            fapiaoshenqing.setInsertTime(new Date());
            fapiaoshenqing.setCreateTime(new Date());
        fapiaoshenqingService.insert(fapiaoshenqing);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
