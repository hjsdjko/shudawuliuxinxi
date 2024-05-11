package com.entity.view;

import com.entity.FapiaoshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 发票申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fapiaoshenqing")
public class FapiaoshenqingView extends FapiaoshenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请状态的值
		*/
		private String fapiaoshenqingYesnoValue;



		//级联表 jijianxinxi
			/**
			* 编号
			*/
			private String jijianxinxiUuidNumber;
			/**
			* 寄件信息 的 用户
			*/
			private Integer jijianxinxiYonghuId;
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
				* 物品类型的值
				*/
				private String jijianxinxiValue;
			/**
			* 价格
			*/
			private Double jijianxinxiMoney;
			/**
			* 备注
			*/
			private String tongchengjisongContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 手机号
			*/
			private String yonghuPhone;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FapiaoshenqingView() {

	}

	public FapiaoshenqingView(FapiaoshenqingEntity fapiaoshenqingEntity) {
		try {
			BeanUtils.copyProperties(this, fapiaoshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请状态的值
			*/
			public String getFapiaoshenqingYesnoValue() {
				return fapiaoshenqingYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setFapiaoshenqingYesnoValue(String fapiaoshenqingYesnoValue) {
				this.fapiaoshenqingYesnoValue = fapiaoshenqingYesnoValue;
			}
















				//级联表的get和set jijianxinxi

					/**
					* 获取： 编号
					*/
					public String getJijianxinxiUuidNumber() {
						return jijianxinxiUuidNumber;
					}
					/**
					* 设置： 编号
					*/
					public void setJijianxinxiUuidNumber(String jijianxinxiUuidNumber) {
						this.jijianxinxiUuidNumber = jijianxinxiUuidNumber;
					}

					/**
					* 获取：寄件信息 的 用户
					*/
					public Integer getJijianxinxiYonghuId() {
						return jijianxinxiYonghuId;
					}
					/**
					* 设置：寄件信息 的 用户
					*/
					public void setJijianxinxiYonghuId(Integer jijianxinxiYonghuId) {
						this.jijianxinxiYonghuId = jijianxinxiYonghuId;
					}


					/**
					* 获取： 收件人名称
					*/
					public String getJijianxinxiName() {
						return jijianxinxiName;
					}
					/**
					* 设置： 收件人名称
					*/
					public void setJijianxinxiName(String jijianxinxiName) {
						this.jijianxinxiName = jijianxinxiName;
					}

					/**
					* 获取： 联系方式
					*/
					public String getJijianxinxiPhone() {
						return jijianxinxiPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setJijianxinxiPhone(String jijianxinxiPhone) {
						this.jijianxinxiPhone = jijianxinxiPhone;
					}

					/**
					* 获取： 物品图片
					*/
					public String getJijianxinxiPhoto() {
						return jijianxinxiPhoto;
					}
					/**
					* 设置： 物品图片
					*/
					public void setJijianxinxiPhoto(String jijianxinxiPhoto) {
						this.jijianxinxiPhoto = jijianxinxiPhoto;
					}

					/**
					* 获取： 送件住址
					*/
					public String getJijianxinxiAddress() {
						return jijianxinxiAddress;
					}
					/**
					* 设置： 送件住址
					*/
					public void setJijianxinxiAddress(String jijianxinxiAddress) {
						this.jijianxinxiAddress = jijianxinxiAddress;
					}

					/**
					* 获取： 物品类型
					*/
					public Integer getJijianxinxiTypes() {
						return jijianxinxiTypes;
					}
					/**
					* 设置： 物品类型
					*/
					public void setJijianxinxiTypes(Integer jijianxinxiTypes) {
						this.jijianxinxiTypes = jijianxinxiTypes;
					}


						/**
						* 获取： 物品类型的值
						*/
						public String getJijianxinxiValue() {
							return jijianxinxiValue;
						}
						/**
						* 设置： 物品类型的值
						*/
						public void setJijianxinxiValue(String jijianxinxiValue) {
							this.jijianxinxiValue = jijianxinxiValue;
						}

					/**
					* 获取： 价格
					*/
					public Double getJijianxinxiMoney() {
						return jijianxinxiMoney;
					}
					/**
					* 设置： 价格
					*/
					public void setJijianxinxiMoney(Double jijianxinxiMoney) {
						this.jijianxinxiMoney = jijianxinxiMoney;
					}

					/**
					* 获取： 备注
					*/
					public String getTongchengjisongContent() {
						return tongchengjisongContent;
					}
					/**
					* 设置： 备注
					*/
					public void setTongchengjisongContent(String tongchengjisongContent) {
						this.tongchengjisongContent = tongchengjisongContent;
					}













				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
