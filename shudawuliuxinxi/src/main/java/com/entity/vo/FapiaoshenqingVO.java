package com.entity.vo;

import com.entity.FapiaoshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 发票申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fapiaoshenqing")
public class FapiaoshenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show2 photoShow
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
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
