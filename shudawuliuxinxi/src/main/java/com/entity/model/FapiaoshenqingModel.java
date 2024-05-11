package com.entity.model;

import com.entity.FapiaoshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 发票申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FapiaoshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 寄件信息
     */
    private Integer jijianxinxiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 申请状态
     */
    private Integer fapiaoshenqingYesnoTypes;


    /**
     * 申请备注
     */
    private String fapiaoshenqingYesnoText;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show2 photoShow
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
	 * 获取：寄件信息
	 */
    public Integer getJijianxinxiId() {
        return jijianxinxiId;
    }


    /**
	 * 设置：寄件信息
	 */
    public void setJijianxinxiId(Integer jijianxinxiId) {
        this.jijianxinxiId = jijianxinxiId;
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
	 * 获取：申请状态
	 */
    public Integer getFapiaoshenqingYesnoTypes() {
        return fapiaoshenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setFapiaoshenqingYesnoTypes(Integer fapiaoshenqingYesnoTypes) {
        this.fapiaoshenqingYesnoTypes = fapiaoshenqingYesnoTypes;
    }
    /**
	 * 获取：申请备注
	 */
    public String getFapiaoshenqingYesnoText() {
        return fapiaoshenqingYesnoText;
    }


    /**
	 * 设置：申请备注
	 */
    public void setFapiaoshenqingYesnoText(String fapiaoshenqingYesnoText) {
        this.fapiaoshenqingYesnoText = fapiaoshenqingYesnoText;
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
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
