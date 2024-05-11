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
 * 同城急送
 *
 * @author 
 * @email
 */
@TableName("tongchengjisong")
public class TongchengjisongEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TongchengjisongEntity() {

	}

	public TongchengjisongEntity(T t) {
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
     * 编号
     */
    @TableField(value = "tongchengjisong_uuid_number")

    private String tongchengjisongUuidNumber;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 位置
     */
    @TableField(value = "tongchengjisong_name")

    private String tongchengjisongName;


    /**
     * 任务类型
     */
    @TableField(value = "tongchengjisong_types")

    private Integer tongchengjisongTypes;


    /**
     * 价格
     */
    @TableField(value = "tongchengjisong_money")

    private Double tongchengjisongMoney;


    /**
     * 任务详情
     */
    @TableField(value = "tongchengjisong_text")

    private String tongchengjisongText;


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
	 * 设置：编号
	 */
    public String getTongchengjisongUuidNumber() {
        return tongchengjisongUuidNumber;
    }
    /**
	 * 获取：编号
	 */

    public void setTongchengjisongUuidNumber(String tongchengjisongUuidNumber) {
        this.tongchengjisongUuidNumber = tongchengjisongUuidNumber;
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
	 * 设置：位置
	 */
    public String getTongchengjisongName() {
        return tongchengjisongName;
    }
    /**
	 * 获取：位置
	 */

    public void setTongchengjisongName(String tongchengjisongName) {
        this.tongchengjisongName = tongchengjisongName;
    }
    /**
	 * 设置：任务类型
	 */
    public Integer getTongchengjisongTypes() {
        return tongchengjisongTypes;
    }
    /**
	 * 获取：任务类型
	 */

    public void setTongchengjisongTypes(Integer tongchengjisongTypes) {
        this.tongchengjisongTypes = tongchengjisongTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getTongchengjisongMoney() {
        return tongchengjisongMoney;
    }
    /**
	 * 获取：价格
	 */

    public void setTongchengjisongMoney(Double tongchengjisongMoney) {
        this.tongchengjisongMoney = tongchengjisongMoney;
    }
    /**
	 * 设置：任务详情
	 */
    public String getTongchengjisongText() {
        return tongchengjisongText;
    }
    /**
	 * 获取：任务详情
	 */

    public void setTongchengjisongText(String tongchengjisongText) {
        this.tongchengjisongText = tongchengjisongText;
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
        return "Tongchengjisong{" +
            "id=" + id +
            ", tongchengjisongUuidNumber=" + tongchengjisongUuidNumber +
            ", yonghuId=" + yonghuId +
            ", tongchengjisongName=" + tongchengjisongName +
            ", tongchengjisongTypes=" + tongchengjisongTypes +
            ", tongchengjisongMoney=" + tongchengjisongMoney +
            ", tongchengjisongText=" + tongchengjisongText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
