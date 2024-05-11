package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 发票申请
 *
 * @author 
 * @email
 */
@TableName("fapiaoshenqing")
public class FapiaoshenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FapiaoshenqingEntity() {

	}

	public FapiaoshenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 寄件信息
     */
    @TableField(value = "jijianxinxi_id")

    private Integer jijianxinxiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 申请状态
     */
    @TableField(value = "fapiaoshenqing_yesno_types")

    private Integer fapiaoshenqingYesnoTypes;


    /**
     * 申请备注
     */
    @TableField(value = "fapiaoshenqing_yesno_text")

    private String fapiaoshenqingYesnoText;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：寄件信息
	 */
    public Integer getJijianxinxiId() {
        return jijianxinxiId;
    }
    /**
	 * 获取：寄件信息
	 */

    public void setJijianxinxiId(Integer jijianxinxiId) {
        this.jijianxinxiId = jijianxinxiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getFapiaoshenqingYesnoTypes() {
        return fapiaoshenqingYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */

    public void setFapiaoshenqingYesnoTypes(Integer fapiaoshenqingYesnoTypes) {
        this.fapiaoshenqingYesnoTypes = fapiaoshenqingYesnoTypes;
    }
    /**
	 * 设置：申请备注
	 */
    public String getFapiaoshenqingYesnoText() {
        return fapiaoshenqingYesnoText;
    }
    /**
	 * 获取：申请备注
	 */

    public void setFapiaoshenqingYesnoText(String fapiaoshenqingYesnoText) {
        this.fapiaoshenqingYesnoText = fapiaoshenqingYesnoText;
    }
    /**
	 * 设置：发布日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fapiaoshenqing{" +
            "id=" + id +
            ", jijianxinxiId=" + jijianxinxiId +
            ", yonghuId=" + yonghuId +
            ", fapiaoshenqingYesnoTypes=" + fapiaoshenqingYesnoTypes +
            ", fapiaoshenqingYesnoText=" + fapiaoshenqingYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
