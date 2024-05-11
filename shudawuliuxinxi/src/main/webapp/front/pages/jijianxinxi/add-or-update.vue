
<template>
    <view class="content">
        <form class="app-update-pv">
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                      class="title">编号</view>
                <input   disabled
                         :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.jijianxinxiUuidNumber" type="text" v-model="ruleForm.jijianxinxiUuidNumber" placeholder="编号"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                      class="title">收件人名称</view>
                <input   disabled
                         :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.jijianxinxiName" type="text" v-model="ruleForm.jijianxinxiName" placeholder="收件人名称"></input>
            </view>
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                      class="title">联系方式</view>
                <input   disabled
                         :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.jijianxinxiPhone" type="text" v-model="ruleForm.jijianxinxiPhone" placeholder="联系方式"></input>
            </view>
                <view
                        :style='{"boxShadow":"0 0 0px rgba(0,0,0,.3)","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(218, 220, 219, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"108rpx"}'
                        class="cu-form-group" @tap="jijianxinxiPhotoTap">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                          class="title">物品图片</view>
                    <view class="right-input" style="padding:0;textAlign:left">
                        <image
                                :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-if="ruleForm.jijianxinxiPhoto" :src="ruleForm.jijianxinxiPhoto" mode="aspectFill">
                        </image>
                        <image  :style='{"width":"68rpx","boxShadow":"0 0 0px rgba(0,0,0,.3)","borderRadius":"100%","textAlign":"left","height":"68rpx"}'
                                class="avator" v-else src="../../static/gen/upload.png" mode="aspectFill"></image>
                    </view>
                </view>
					            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                      class="title">送件住址</view>
                <input   disabled
                         :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                         :disabled="ro.jijianxinxiAddress" type="text" v-model="ruleForm.jijianxinxiAddress" placeholder="送件住址"></input>
            </view>
                <view :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                      class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                          class="title">物品类型</view>
                    <picker @change="jijianxinxiTypesChange" :value="jijianxinxiTypesIndex" :range="jijianxinxiTypesOptions" range-key="indexName">
                        <view
                                :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                                class="uni-input">{{ruleForm.jijianxinxiTypes?ruleForm.jijianxinxiValue:"请选择物品类型"}}</view>
                    </picker>
                </view>
                <view
                        :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"88rpx"}'
                        class="cu-form-group">
                    <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                          class="title">价格</view>
                    <input   disabled
                             :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
                             :disabled="ro.jijianxinxiMoney" type="number" v-model="ruleForm.jijianxinxiMoney" placeholder="价格"></input>
                </view>
<!-- text后缀 -->
            <view
                    :style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"210rpx"}'
                    class="cu-form-group">
                <view :style='{"width":"160rpx","fontSize":"28rpx","color":"#f06f4f","textAlign":"left"}'
                      class="title">备注</view>
                <textarea :style='{"boxShadow":"0 0 0px rgba(0,0,0,.6) inset","backgroundColor":"rgba(255, 255, 255, 1)","borderColor":"#f06f4f","borderRadius":"0px","color":"#f06f4f","textAlign":"left","borderWidth":"0 0 6rpx","fontSize":"24rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx","height":"200rpx"}'
                          :disabled="ro.tongchengjisongContent" v-model="ruleForm.tongchengjisongContent" placeholder="备注"/>
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
                ro:{
					jijianxinxiUuidNumber: true,
					yonghuId: false,
					jijianxinxiName: false,
					jijianxinxiPhone: false,
					jijianxinxiPhoto: false,
					jijianxinxiAddress: false,
					jijianxinxiTypes: false,
					jijianxinxiMoney: false,
					tongchengjisongContent: false,
					insertTime: false,
					createTime: false,
        },
            ruleForm: {
					jijianxinxiUuidNumber: this.getUUID(),//数字
					yonghuId: '',
					jijianxinxiName: '',
					jijianxinxiPhone: '',
					jijianxinxiPhoto: '',
					jijianxinxiAddress: '',
					jijianxinxiTypes: '',//数字
					jijianxinxiValue: '',//数字对应的值
					jijianxinxiMoney: '',
					tongchengjisongContent: '',
					insertTime: '',
					createTime: '',
            },
            // 登陆用户信息
            user: {},
				jijianxinxiTypesOptions: [],
							jijianxinxiTypesIndex : 0,

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
			let jijianxinxiTypesParams = {
                page: 1,
                limit: 100,
                dicCode: 'jijianxinxi_types',
            }
			let jijianxinxiTypes = await this.$api.page(`dictionary`, jijianxinxiTypesParams);
			this.jijianxinxiTypesOptions = jijianxinxiTypes.data.list


            // 如果是更新操作
            if (options.id) {
                this.ruleForm.id = options.id;
                // 获取信息
                let res = await this.$api.info(`jijianxinxi`, this.ruleForm.id);
                this.ruleForm = res.data;
            }
            if(options.jijianxinxiId){
                this.ruleForm.jijianxinxiId = options.jijianxinxiId;
            }
            // 跨表
            // this.styleChange()
        },
        methods: {
            // 下拉变化
            jijianxinxiTypesChange(e) {
                this.jijianxinxiTypesIndex = e.target.value
                this.ruleForm.jijianxinxiValue = this.jijianxinxiTypesOptions[this.jijianxinxiTypesIndex].indexName
                this.ruleForm.jijianxinxiTypes = this.jijianxinxiTypesOptions[this.jijianxinxiTypesIndex].codeIndex
            },


            // styleChange() {
            // 	this.$nextTick(() => {
            // 		// document.querySelectorAll('.app-update-pv .cu-form-group .uni-yaoxianStyle-yaoxianStyle').forEach(el=>{
            // 		//   el.style.backgroundColor = this.addUpdateForm.yaoxianStyle.content.backgroundColor
            // 		// })
            // 	})
            // },


			jijianxinxiPhotoTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.jijianxinxiPhoto = _this.$base.url + 'upload/' + res.file;
                    _this.$forceUpdate();
                    _this.$nextTick(() => {
                        // _this.styleChange()
                    })
                });
            },
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
				if ((!this.ruleForm.jijianxinxiUuidNumber)) {
                    this.$utils.msg(`编号不能为空`);
                    return
                }
				if ((!this.ruleForm.jijianxinxiName)) {
                    this.$utils.msg(`收件人名称不能为空`);
                    return
                }
				if ((!this.ruleForm.jijianxinxiPhone) && (!this.$validate.isMobile(this.ruleForm.jijianxinxiPhone))) {
                    this.$utils.msg(`联系方式不能为空并且需要输入正确格式`);
                    return
                }
				if ((!this.ruleForm.jijianxinxiPhoto)) {
                    this.$utils.msg(`物品图片不能为空`);
                    return
                }
				if ((!this.ruleForm.jijianxinxiAddress)) {
                    this.$utils.msg(`送件住址不能为空`);
                    return
                }
				if ((!this.ruleForm.jijianxinxiMoney) && (!this.$validate.isNumber(this.ruleForm.jijianxinxiMoney)) && this.ruleForm.jijianxinxiMoney >0) {
                    this.$utils.msg(`价格不能为空，不能小于0 格式为数字或小数`);
                    return
                }
                if (this.ruleForm.id) {
                    await this.$api.update(`jijianxinxi`, this.ruleForm);
                } else {
                    await this.$api.save(`jijianxinxi`, this.ruleForm);
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