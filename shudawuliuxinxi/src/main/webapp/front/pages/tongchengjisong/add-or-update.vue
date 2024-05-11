<template>
	<view class="content">
		<form class="app-update-pv">
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}' class="title">
					编号</view>
				<input disabled
					:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					:disabled="ro.tongchengjisongUuidNumber" type="text" v-model="ruleForm.tongchengjisongUuidNumber"
					placeholder="编号"></input>
			</view>
			<view  @click="chooseLocation"
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}' class="title">
					位置</view>
				<input disabled
					:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					disabled 
					type="text" v-model="ruleForm.tongchengjisongName"
					placeholder="位置"></input>
			</view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}' class="title">
					任务类型</view>
				<picker @change="tongchengjisongTypesChange" :value="tongchengjisongTypesIndex"
					:range="tongchengjisongTypesOptions" range-key="indexName">
					<view
						:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
						class="uni-input">{{ruleForm.tongchengjisongTypes?ruleForm.tongchengjisongValue:"请选择任务类型"}}
					</view>
				</picker>
			</view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}' class="title">
					价格</view>
				<input disabled
					:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					:disabled="ro.tongchengjisongMoney" type="number" v-model="ruleForm.tongchengjisongMoney"
					placeholder="价格"></input>
			</view>
			<!-- text后缀 -->
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}' class="title">
					任务详情</view>
				<textarea
					:style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
					:disabled="ro.tongchengjisongText" v-model="ruleForm.tongchengjisongText" placeholder="任务详情" />
			</view>

			<view class="btn">
				<button
					:style='{"boxShadow":"0 0 16rpx rgba(0,0,0,0) inset","backgroundColor":"#f06f4f","borderColor":"#409EFF","borderRadius":"8rpx","color":"rgba(255, 255, 255, 1)","borderWidth":"0","width":"70%","fontSize":"32rpx","borderStyle":"solid","height":"80rpx"}'
					@tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="insertTimeConfirm"
			ref="insertTime" themeColor="#333333"></w-picker>
		<w-picker mode="dateTime" step="1" :current="false" :hasSecond="false" @confirm="createTimeConfirm"
			ref="createTime" themeColor="#333333"></w-picker>


	</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";

	export default {
		data() {
			return {
				cross: '',
				ro: {
					tongchengjisongUuidNumber: true,
					yonghuId: false,
					tongchengjisongName: false,
					tongchengjisongTypes: false,
					tongchengjisongMoney: false,
					tongchengjisongText: false,
					insertTime: false,
					createTime: false,
				},
				ruleForm: {
					tongchengjisongUuidNumber: this.getUUID(), //数字
					yonghuId: '',
					tongchengjisongName: '',
					tongchengjisongTypes: '', //数字
					tongchengjisongValue: '', //数字对应的值
					tongchengjisongMoney: '',
					tongchengjisongText: '',
					insertTime: '',
					createTime: '',
				},
				// 登陆用户信息
				user: {},
				tongchengjisongTypesOptions: [],
				tongchengjisongTypesIndex: 0,

			}
		},
		components: {
			wPicker
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
		},
		async onLoad(options) {

			/*下拉框*/
			let tongchengjisongTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'tongchengjisong_types',
			}
			let tongchengjisongTypes = await this.$api.page(`dictionary`, tongchengjisongTypesParams);
			this.tongchengjisongTypesOptions = tongchengjisongTypes.data.list


			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				let res = await this.$api.info(`tongchengjisong`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			if (options.tongchengjisongId) {
				this.ruleForm.tongchengjisongId = options.tongchengjisongId;
			}
			// 跨表
			// this.styleChange()
		},
		methods: {
			//地图选择地址
			chooseLocation() {
				let _this = this
				uni.chooseLocation({
					success: (data) => {
						_this.ruleForm.tongchengjisongName = data.address+data.name;
					}
				})
			},
			// 下拉变化
			tongchengjisongTypesChange(e) {
				this.tongchengjisongTypesIndex = e.target.value
				this.ruleForm.tongchengjisongValue = this.tongchengjisongTypesOptions[this.tongchengjisongTypesIndex]
					.indexName
				this.ruleForm.tongchengjisongTypes = this.tongchengjisongTypesOptions[this.tongchengjisongTypesIndex]
					.codeIndex
			},


			// styleChange() {
			// 	this.$nextTick(() => {
			// 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
			// 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
			// 		// })
			// 	})
			// },


			// 日期控件
			insertTimeConfirm(val) {
				console.log(val)
				this.ruleForm.insertTime = val.result;
				this.$forceUpdate();
			},
			// 日期控件
			createTimeConfirm(val) {
				console.log(val)
				this.ruleForm.createTime = val.result;
				this.$forceUpdate();
			},




			getUUID() {
				return new Date().getTime();
			},
			async onSubmitTap() {
				if ((!this.ruleForm.tongchengjisongUuidNumber)) {
					this.$utils.msg(`编号不能为空`);
					return
				}
				if ((!this.ruleForm.tongchengjisongName)) {
					this.$utils.msg(`位置不能为空`);
					return
				}
				if ((!this.ruleForm.tongchengjisongMoney) && (!this.$validate.isNumber(this.ruleForm
						.tongchengjisongMoney)) && this.ruleForm.tongchengjisongMoney > 0) {
					this.$utils.msg(`价格不能为空，不能小于0 格式为数字或小数`);
					return
				}
				if ((!this.ruleForm.tongchengjisongText)) {
					this.$utils.msg(`任务详情不能为空`);
					return
				}
				if (this.ruleForm.id) {
					await this.$api.update(`tongchengjisong`, this.ruleForm);
				} else {
					await this.$api.save(`tongchengjisong`, this.ruleForm);
				}
				uni.setStorageSync('pingluenStateState', true);
				this.$utils.msgBack('提交成功');
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.container {
		padding: 20upx;
	}

	.content:after {
		position: fixed;
		top: 0;
		right: 0;
		left: 0;
		bottom: 0;
		content: '';
		background-attachment: fixed;
		background-size: cover;
		background-position: center;
	}

	textarea {
		border: 1upx solid #EEEEEE;
		border-radius: 20upx;
		padding: 20upx;
	}

	.title {
		width: 180upx;
	}

	.avator {
		width: 150upx;
		height: 60upx;
	}

	.right-input {
		flex: 1;
		text-align: left;
		padding: 0 24upx;
	}

	.cu-form-group.active {
		justify-content: space-between;
	}

	.btn {
		display: flex;
		align-items: center;
		justify-content: center;
		flex-wrap: wrap;
		padding: 20upx 0;
	}

	.cu-form-group {
		padding: 0 24upx;
		background-color: transparent;
		min-height: inherit;
	}

	.cu-form-group+.cu-form-group {
		border: 0;
	}

	.cu-form-group uni-input {
		padding: 0 30upx;
	}

	.uni-input {
		padding: 0 30upx;
	}

	.cu-form-group uni-textarea {
		padding: 30upx;
		margin: 0;
	}

	.cu-form-group uni-picker::after {
		line-height: 68rpx;
	}

	.select .uni-input {
		line-height: 68rpx;
	}

	.input .right-input {
		line-height: 68rpx;
	}
</style>
