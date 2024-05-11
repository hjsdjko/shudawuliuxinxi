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
 * 快件信息
 *
 * @author 
 * @email
 */
@TableName("kuaijian")
public class KuaijianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public KuaijianEntity() {

	}

	public KuaijianEntity(T t) {
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
    @TableField(value = "kuaijian_uuid_number")

    private String kuaijianUuidNumber;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 发件人名称
     */
    @TableField(value = "kuaijian_name")

    private String kuaijianName;


    /**
     * 联系方式
     */
    @TableField(value = "kuaijian_phone")

    private String kuaijianPhone;


    /**
     * 物品图片
     */
    @TableField(value = "kuaijian_photo")

    private String kuaijianPhoto;


    /**
     * 送件住址
     */
    @TableField(value = "kuaijian_address")

    private String kuaijianAddress;


    /**
     * 物品类型
     */
    @TableField(value = "jijianxinxi_types")

    private Integer jijianxinxiTypes;


    /**
     * 备注
     */
    @TableField(value = "kuaijian_content")

    private String kuaijianContent;


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
    public String getKuaijianUuidNumber() {
        return kuaijianUuidNumber;
    }
    /**
	 * 获取：编号
	 */

    public void setKuaijianUuidNumber(String kuaijianUuidNumber) {
        this.kuaijianUuidNumber = kuaijianUuidNumber;
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
	 * 设置：发件人名称
	 */
    public String getKuaijianName() {
        return kuaijianName;
    }
    /**
	 * 获取：发件人名称
	 */

    public void setKuaijianName(String kuaijianName) {
        this.kuaijianName = kuaijianName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getKuaijianPhone() {
        return kuaijianPhone;
    }
    /**
	 * 获取：联系方式
	 */

    public void setKuaijianPhone(String kuaijianPhone) {
        this.kuaijianPhone = kuaijianPhone;
    }
    /**
	 * 设置：物品图片
	 */
    public String getKuaijianPhoto() {
        return kuaijianPhoto;
    }
    /**
	 * 获取：物品图片
	 */

    public void setKuaijianPhoto(String kuaijianPhoto) {
        this.kuaijianPhoto = kuaijianPhoto;
    }
    /**
	 * 设置：送件住址
	 */
    public String getKuaijianAddress() {
        return kuaijianAddress;
    }
    /**
	 * 获取：送件住址
	 */

    public void setKuaijianAddress(String kuaijianAddress) {
        this.kuaijianAddress = kuaijianAddress;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getJijianxinxiTypes() {
        return jijianxinxiTypes;
    }
    /**
	 * 获取：物品类型
	 */

    public void setJijianxinxiTypes(Integer jijianxinxiTypes) {
        this.jijianxinxiTypes = jijianxinxiTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getKuaijianContent() {
        return kuaijianContent;
    }
    /**
	 * 获取：备注
	 */

    public void setKuaijianContent(String kuaijianContent) {
        this.kuaijianContent = kuaijianContent;
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
        return "Kuaijian{" +
            "id=" + id +
            ", kuaijianUuidNumber=" + kuaijianUuidNumber +
            ", yonghuId=" + yonghuId +
            ", kuaijianName=" + kuaijianName +
            ", kuaijianPhone=" + kuaijianPhone +
            ", kuaijianPhoto=" + kuaijianPhoto +
            ", kuaijianAddress=" + kuaijianAddress +
            ", jijianxinxiTypes=" + jijianxinxiTypes +
            ", kuaijianContent=" + kuaijianContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
