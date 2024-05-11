package com.entity.model;

import com.entity.JijianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 寄件信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JijianxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String jijianxinxiUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 收件人名称
     */
    private String jijianxinxiName;


    /**
     * 联系方式
     */
    private String jijianxinxiPhone;


    /**
     * 物品图片
     */
    private String jijianxinxiPhoto;


    /**
     * 送件住址
     */
    private String jijianxinxiAddress;


    /**
     * 物品类型
     */
    private Integer jijianxinxiTypes;


    /**
     * 价格
     */
    private Double jijianxinxiMoney;


    /**
     * 备注
     */
    private String tongchengjisongContent;


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
    public String getJijianxinxiUuidNumber() {
        return jijianxinxiUuidNumber;
    }


    /**
	 * 设置：编号
	 */
    public void setJijianxinxiUuidNumber(String jijianxinxiUuidNumber) {
        this.jijianxinxiUuidNumber = jijianxinxiUuidNumber;
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
	 * 获取：收件人名称
	 */
    public String getJijianxinxiName() {
        return jijianxinxiName;
    }


    /**
	 * 设置：收件人名称
	 */
    public void setJijianxinxiName(String jijianxinxiName) {
        this.jijianxinxiName = jijianxinxiName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJijianxinxiPhone() {
        return jijianxinxiPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setJijianxinxiPhone(String jijianxinxiPhone) {
        this.jijianxinxiPhone = jijianxinxiPhone;
    }
    /**
	 * 获取：物品图片
	 */
    public String getJijianxinxiPhoto() {
        return jijianxinxiPhoto;
    }


    /**
	 * 设置：物品图片
	 */
    public void setJijianxinxiPhoto(String jijianxinxiPhoto) {
        this.jijianxinxiPhoto = jijianxinxiPhoto;
    }
    /**
	 * 获取：送件住址
	 */
    public String getJijianxinxiAddress() {
        return jijianxinxiAddress;
    }


    /**
	 * 设置：送件住址
	 */
    public void setJijianxinxiAddress(String jijianxinxiAddress) {
        this.jijianxinxiAddress = jijianxinxiAddress;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getJijianxinxiTypes() {
        return jijianxinxiTypes;
    }


    /**
	 * 设置：物品类型
	 */
    public void setJijianxinxiTypes(Integer jijianxinxiTypes) {
        this.jijianxinxiTypes = jijianxinxiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getJijianxinxiMoney() {
        return jijianxinxiMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setJijianxinxiMoney(Double jijianxinxiMoney) {
        this.jijianxinxiMoney = jijianxinxiMoney;
    }
    /**
	 * 获取：备注
	 */
    public String getTongchengjisongContent() {
        return tongchengjisongContent;
    }


    /**
	 * 设置：备注
	 */
    public void setTongchengjisongContent(String tongchengjisongContent) {
        this.tongchengjisongContent = tongchengjisongContent;
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
