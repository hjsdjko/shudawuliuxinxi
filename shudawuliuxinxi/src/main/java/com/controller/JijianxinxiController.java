
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
 * 寄件信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jijianxinxi")
public class JijianxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(JijianxinxiController.class);

    @Autowired
    private JijianxinxiService jijianxinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
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
        PageUtils page = jijianxinxiService.queryPage(params);

        //字典表数据转换
        List<JijianxinxiView> list =(List<JijianxinxiView>)page.getList();
        for(JijianxinxiView c:list){
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
        JijianxinxiEntity jijianxinxi = jijianxinxiService.selectById(id);
        if(jijianxinxi !=null){
            //entity转view
            JijianxinxiView view = new JijianxinxiView();
            BeanUtils.copyProperties( jijianxinxi , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(jijianxinxi.getYonghuId());
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
    public R save(@RequestBody JijianxinxiEntity jijianxinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jijianxinxi:{}",this.getClass().getName(),jijianxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jijianxinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JijianxinxiEntity> queryWrapper = new EntityWrapper<JijianxinxiEntity>()
            .eq("jijianxinxi_uuid_number", jijianxinxi.getJijianxinxiUuidNumber())
            .eq("yonghu_id", jijianxinxi.getYonghuId())
            .eq("jijianxinxi_name", jijianxinxi.getJijianxinxiName())
            .eq("jijianxinxi_phone", jijianxinxi.getJijianxinxiPhone())
            .eq("jijianxinxi_address", jijianxinxi.getJijianxinxiAddress())
            .eq("jijianxinxi_types", jijianxinxi.getJijianxinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijianxinxiEntity jijianxinxiEntity = jijianxinxiService.selectOne(queryWrapper);
        if(jijianxinxiEntity==null){
            jijianxinxi.setInsertTime(new Date());
            jijianxinxi.setCreateTime(new Date());
            jijianxinxiService.insert(jijianxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JijianxinxiEntity jijianxinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jijianxinxi:{}",this.getClass().getName(),jijianxinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jijianxinxi.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JijianxinxiEntity> queryWrapper = new EntityWrapper<JijianxinxiEntity>()
            .notIn("id",jijianxinxi.getId())
            .andNew()
            .eq("jijianxinxi_uuid_number", jijianxinxi.getJijianxinxiUuidNumber())
            .eq("yonghu_id", jijianxinxi.getYonghuId())
            .eq("jijianxinxi_name", jijianxinxi.getJijianxinxiName())
            .eq("jijianxinxi_phone", jijianxinxi.getJijianxinxiPhone())
            .eq("jijianxinxi_address", jijianxinxi.getJijianxinxiAddress())
            .eq("jijianxinxi_types", jijianxinxi.getJijianxinxiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijianxinxiEntity jijianxinxiEntity = jijianxinxiService.selectOne(queryWrapper);
        if("".equals(jijianxinxi.getJijianxinxiPhoto()) || "null".equals(jijianxinxi.getJijianxinxiPhoto())){
                jijianxinxi.setJijianxinxiPhoto(null);
        }
        if(jijianxinxiEntity==null){
            jijianxinxiService.updateById(jijianxinxi);//根据id更新
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
        jijianxinxiService.deleteBatchIds(Arrays.asList(ids));
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
            List<JijianxinxiEntity> jijianxinxiList = new ArrayList<>();//上传的东西
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
                            JijianxinxiEntity jijianxinxiEntity = new JijianxinxiEntity();
//                            jijianxinxiEntity.setJijianxinxiUuidNumber(data.get(0));                    //编号 要改的
//                            jijianxinxiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jijianxinxiEntity.setJijianxinxiName(data.get(0));                    //收件人名称 要改的
//                            jijianxinxiEntity.setJijianxinxiPhone(data.get(0));                    //联系方式 要改的
//                            jijianxinxiEntity.setJijianxinxiPhoto("");//详情和图片
//                            jijianxinxiEntity.setJijianxinxiAddress(data.get(0));                    //送件住址 要改的
//                            jijianxinxiEntity.setJijianxinxiTypes(Integer.valueOf(data.get(0)));   //物品类型 要改的
//                            jijianxinxiEntity.setJijianxinxiMoney(data.get(0));                    //价格 要改的
//                            jijianxinxiEntity.setTongchengjisongContent("");//详情和图片
//                            jijianxinxiEntity.setInsertTime(date);//时间
//                            jijianxinxiEntity.setCreateTime(date);//时间
                            jijianxinxiList.add(jijianxinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //编号
                                if(seachFields.containsKey("jijianxinxiUuidNumber")){
                                    List<String> jijianxinxiUuidNumber = seachFields.get("jijianxinxiUuidNumber");
                                    jijianxinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jijianxinxiUuidNumber = new ArrayList<>();
                                    jijianxinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jijianxinxiUuidNumber",jijianxinxiUuidNumber);
                                }
                                //联系方式
                                if(seachFields.containsKey("jijianxinxiPhone")){
                                    List<String> jijianxinxiPhone = seachFields.get("jijianxinxiPhone");
                                    jijianxinxiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jijianxinxiPhone = new ArrayList<>();
                                    jijianxinxiPhone.add(data.get(0));//要改的
                                    seachFields.put("jijianxinxiPhone",jijianxinxiPhone);
                                }
                        }

                        //查询是否重复
                         //编号
                        List<JijianxinxiEntity> jijianxinxiEntities_jijianxinxiUuidNumber = jijianxinxiService.selectList(new EntityWrapper<JijianxinxiEntity>().in("jijianxinxi_uuid_number", seachFields.get("jijianxinxiUuidNumber")));
                        if(jijianxinxiEntities_jijianxinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JijianxinxiEntity s:jijianxinxiEntities_jijianxinxiUuidNumber){
                                repeatFields.add(s.getJijianxinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<JijianxinxiEntity> jijianxinxiEntities_jijianxinxiPhone = jijianxinxiService.selectList(new EntityWrapper<JijianxinxiEntity>().in("jijianxinxi_phone", seachFields.get("jijianxinxiPhone")));
                        if(jijianxinxiEntities_jijianxinxiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JijianxinxiEntity s:jijianxinxiEntities_jijianxinxiPhone){
                                repeatFields.add(s.getJijianxinxiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jijianxinxiService.insertBatch(jijianxinxiList);
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
        PageUtils page = jijianxinxiService.queryPage(params);

        //字典表数据转换
        List<JijianxinxiView> list =(List<JijianxinxiView>)page.getList();
        for(JijianxinxiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JijianxinxiEntity jijianxinxi = jijianxinxiService.selectById(id);
            if(jijianxinxi !=null){


                //entity转view
                JijianxinxiView view = new JijianxinxiView();
                BeanUtils.copyProperties( jijianxinxi , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jijianxinxi.getYonghuId());
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
    public R add(@RequestBody JijianxinxiEntity jijianxinxi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jijianxinxi:{}",this.getClass().getName(),jijianxinxi.toString());
        Wrapper<JijianxinxiEntity> queryWrapper = new EntityWrapper<JijianxinxiEntity>()
            .eq("jijianxinxi_uuid_number", jijianxinxi.getJijianxinxiUuidNumber())
            .eq("yonghu_id", jijianxinxi.getYonghuId())
            .eq("jijianxinxi_name", jijianxinxi.getJijianxinxiName())
            .eq("jijianxinxi_phone", jijianxinxi.getJijianxinxiPhone())
            .eq("jijianxinxi_address", jijianxinxi.getJijianxinxiAddress())
            .eq("jijianxinxi_types", jijianxinxi.getJijianxinxiTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JijianxinxiEntity jijianxinxiEntity = jijianxinxiService.selectOne(queryWrapper);
        if(jijianxinxiEntity==null){
            jijianxinxi.setInsertTime(new Date());
            jijianxinxi.setCreateTime(new Date());
        jijianxinxiService.insert(jijianxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
