package com.entity.vo;

import com.entity.JijianxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 寄件信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jijianxinxi")
public class JijianxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "jijianxinxi_uuid_number")
    private String jijianxinxiUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 收件人名称
     */

    @TableField(value = "jijianxinxi_name")
    private String jijianxinxiName;


    /**
     * 联系方式
     */

    @TableField(value = "jijianxinxi_phone")
    private String jijianxinxiPhone;


    /**
     * 物品图片
     */

    @TableField(value = "jijianxinxi_photo")
    private String jijianxinxiPhoto;


    /**
     * 送件住址
     */

    @TableField(value = "jijianxinxi_address")
    private String jijianxinxiAddress;


    /**
     * 物品类型
     */

    @TableField(value = "jijianxinxi_types")
    private Integer jijianxinxiTypes;


    /**
     * 价格
     */

    @TableField(value = "jijianxinxi_money")
    private Double jijianxinxiMoney;


    /**
     * 备注
     */

    @TableField(value = "tongchengjisong_content")
    private String tongchengjisongContent;


    /**
     * 发布日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
    public String getJijianxinxiUuidNumber() {
        return jijianxinxiUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setJijianxinxiUuidNumber(String jijianxinxiUuidNumber) {
        this.jijianxinxiUuidNumber = jijianxinxiUuidNumber;
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
	 * 设置：收件人名称
	 */
    public String getJijianxinxiName() {
        return jijianxinxiName;
    }


    /**
	 * 获取：收件人名称
	 */

    public void setJijianxinxiName(String jijianxinxiName) {
        this.jijianxinxiName = jijianxinxiName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJijianxinxiPhone() {
        return jijianxinxiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setJijianxinxiPhone(String jijianxinxiPhone) {
        this.jijianxinxiPhone = jijianxinxiPhone;
    }
    /**
	 * 设置：物品图片
	 */
    public String getJijianxinxiPhoto() {
        return jijianxinxiPhoto;
    }


    /**
	 * 获取：物品图片
	 */

    public void setJijianxinxiPhoto(String jijianxinxiPhoto) {
        this.jijianxinxiPhoto = jijianxinxiPhoto;
    }
    /**
	 * 设置：送件住址
	 */
    public String getJijianxinxiAddress() {
        return jijianxinxiAddress;
    }


    /**
	 * 获取：送件住址
	 */

    public void setJijianxinxiAddress(String jijianxinxiAddress) {
        this.jijianxinxiAddress = jijianxinxiAddress;
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
	 * 设置：价格
	 */
    public Double getJijianxinxiMoney() {
        return jijianxinxiMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setJijianxinxiMoney(Double jijianxinxiMoney) {
        this.jijianxinxiMoney = jijianxinxiMoney;
    }
    /**
	 * 设置：备注
	 */
    public String getTongchengjisongContent() {
        return tongchengjisongContent;
    }


    /**
	 * 获取：备注
	 */

    public void setTongchengjisongContent(String tongchengjisongContent) {
        this.tongchengjisongContent = tongchengjisongContent;
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
