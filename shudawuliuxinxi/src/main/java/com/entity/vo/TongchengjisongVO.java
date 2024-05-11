package com.entity.vo;

import com.entity.TongchengjisongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 同城急送
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tongchengjisong")
public class TongchengjisongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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
