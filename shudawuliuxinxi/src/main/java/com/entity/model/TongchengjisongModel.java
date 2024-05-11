package com.entity.model;

import com.entity.TongchengjisongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 同城急送
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TongchengjisongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String tongchengjisongUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 位置
     */
    private String tongchengjisongName;


    /**
     * 任务类型
     */
    private Integer tongchengjisongTypes;


    /**
     * 价格
     */
    private Double tongchengjisongMoney;


    /**
     * 任务详情
     */
    private String tongchengjisongText;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：编号
	 */
    public String getTongchengjisongUuidNumber() {
        return tongchengjisongUuidNumber;
    }


    /**
	 * 设置：编号
	 */
    public void setTongchengjisongUuidNumber(String tongchengjisongUuidNumber) {
        this.tongchengjisongUuidNumber = tongchengjisongUuidNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：位置
	 */
    public String getTongchengjisongName() {
        return tongchengjisongName;
    }


    /**
	 * 设置：位置
	 */
    public void setTongchengjisongName(String tongchengjisongName) {
        this.tongchengjisongName = tongchengjisongName;
    }
    /**
	 * 获取：任务类型
	 */
    public Integer getTongchengjisongTypes() {
        return tongchengjisongTypes;
    }


    /**
	 * 设置：任务类型
	 */
    public void setTongchengjisongTypes(Integer tongchengjisongTypes) {
        this.tongchengjisongTypes = tongchengjisongTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getTongchengjisongMoney() {
        return tongchengjisongMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setTongchengjisongMoney(Double tongchengjisongMoney) {
        this.tongchengjisongMoney = tongchengjisongMoney;
    }
    /**
	 * 获取：任务详情
	 */
    public String getTongchengjisongText() {
        return tongchengjisongText;
    }


    /**
	 * 设置：任务详情
	 */
    public void setTongchengjisongText(String tongchengjisongText) {
        this.tongchengjisongText = tongchengjisongText;
    }
    /**
	 * 获取：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布日期
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
