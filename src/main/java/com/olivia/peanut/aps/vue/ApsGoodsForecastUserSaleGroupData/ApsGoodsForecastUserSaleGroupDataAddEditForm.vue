<script setup lang="ts">
import {onMounted, ref} from "vue"
import {type ApsGoodsForecastUserSaleGroupData} from "./ApsGoodsForecastUserSaleGroupDataType.ts"
import {getById, postNoResult} from "@/common/utils/common-js.ts"
import {type FormInstance, FormRules} from "element-plus"

const props = defineProps({
  saveFun: {
    type: Function
  },
  editId: {
    type: String,
    required: false
  }
})

// 对象URL
const dtoUrl = ref<string>("/apsGoodsForecastUserSaleGroupData")
// 表单引用
const addFormRef = ref<FormInstance>()
// 表单校验规则
const checkRules = ref<FormRules>({
  //
  forecastId: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  // 销售组 [{id:,name,code}]
  saleConfigParentList: [
    {required: true, message: "请输入销售组 [{id:,name,code}]", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  // 销售配置 [{id:,name,code}]
  saleConfigList: [
    {required: true, message: "请输入销售配置 [{id:,name,code}]", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  // 年份
  year: [
    {required: true, message: "请输入年份", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month01: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month02: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month03: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month04: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month05: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month06: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month07: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month08: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month09: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month10: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month11: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  month12: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult01: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult02: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult03: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult04: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult05: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult06: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult07: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult08: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult09: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult10: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult11: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],
  //
  monthResult12: [
    {required: true, message: "请输入${column.comment}", trigger: "blur"},
    {min: 2, max: 20, message: "长度在 2 到 20 个字符", trigger: "blur"}
  ],

})


// 添加对象
const addForm = ref<ApsGoodsForecastUserSaleGroupData>({
  forecastId: "",
  saleConfigParentList: "",
  saleConfigList: "",
  year: "",
  month01: "",
  month02: "",
  month03: "",
  month04: "",
  month05: "",
  month06: "",
  month07: "",
  month08: "",
  month09: "",
  month10: "",
  month11: "",
  month12: "",
  monthResult01: "",
  monthResult02: "",
  monthResult03: "",
  monthResult04: "",
  monthResult05: "",
  monthResult06: "",
  monthResult07: "",
  monthResult08: "",
  monthResult09: "",
  monthResult10: "",
  monthResult11: "",
  monthResult12: "",
  id: ""
})

const loadById = () => {
  if (!props.editId) {
    return
  }
  console.info("props.editId ", props.editId)
  getById(`${dtoUrl.value}/queryByIdList`, props.editId).then((t) => {
    addForm.value = t
    console.info(" addForm.value ", addForm.value)
  })
}

// 保存
const saveForm = () => {
  console.info("addForm ", addForm)
  addFormRef.value?.validate((valid) => {
    if (valid) {
      // 存在ID ，调用更新
      if (props.editId) {
        postNoResult(`${dtoUrl.value}/updateById`, addForm.value, "修改成功", saveFormAfter)
      } else {
        // 调用保存
        postNoResult(`${dtoUrl.value}/insert`, addForm.value, "保存成功", saveFormAfter)
      }
    } else {
      ElMessage.error("表单校验失败，请检查必填项")
    }
  })
}

// 保存成功后，方法， 目前关闭弹窗
const saveFormAfter = () => {
  cancelForm()
}

// 取消方法
const cancelForm = () => {
  if (props.saveFun) {
    props.saveFun()
  }
}

// 页面加载事件
onMounted(() => {
  loadById()
})
</script>

<template>
  <el-form label-width="80px" :model="addForm" ref="addFormRef" :rules="checkRules">
    <el-form-item label="${column.comment}" prop="forecastId">
      <el-input v-model="addForm.forecastId" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="销售组 [{id:,name,code}]" prop="saleConfigParentList">
      <el-input v-model="addForm.saleConfigParentList" clearable
                placeholder="请输入销售组 [{id:,name,code}]"/>
    </el-form-item>
    <el-form-item label="销售配置 [{id:,name,code}]" prop="saleConfigList">
      <el-input v-model="addForm.saleConfigList" clearable
                placeholder="请输入销售配置 [{id:,name,code}]"/>
    </el-form-item>
    <el-form-item label="年份" prop="year">
      <el-input v-model="addForm.year" clearable placeholder="请输入年份"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month01">
      <el-input v-model="addForm.month01" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month02">
      <el-input v-model="addForm.month02" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month03">
      <el-input v-model="addForm.month03" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month04">
      <el-input v-model="addForm.month04" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month05">
      <el-input v-model="addForm.month05" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month06">
      <el-input v-model="addForm.month06" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month07">
      <el-input v-model="addForm.month07" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month08">
      <el-input v-model="addForm.month08" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month09">
      <el-input v-model="addForm.month09" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month10">
      <el-input v-model="addForm.month10" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month11">
      <el-input v-model="addForm.month11" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="month12">
      <el-input v-model="addForm.month12" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult01">
      <el-input v-model="addForm.monthResult01" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult02">
      <el-input v-model="addForm.monthResult02" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult03">
      <el-input v-model="addForm.monthResult03" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult04">
      <el-input v-model="addForm.monthResult04" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult05">
      <el-input v-model="addForm.monthResult05" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult06">
      <el-input v-model="addForm.monthResult06" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult07">
      <el-input v-model="addForm.monthResult07" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult08">
      <el-input v-model="addForm.monthResult08" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult09">
      <el-input v-model="addForm.monthResult09" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult10">
      <el-input v-model="addForm.monthResult10" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult11">
      <el-input v-model="addForm.monthResult11" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
    <el-form-item label="${column.comment}" prop="monthResult12">
      <el-input v-model="addForm.monthResult12" clearable placeholder="请输入${column.comment}"/>
    </el-form-item>
  </el-form>
  <el-row class="addFormBtnRow">
    <el-button @click="cancelForm" type="info" icon="close">
      取消
    </el-button>
    <el-button @click="saveForm" type="primary" icon="check">
      确定
    </el-button>
  </el-row>
</template>


<style scoped lang="scss">

</style>

