<script setup lang="ts">
import {ref, onMounted} from "vue"
import AddEditFormVue from "./ApsGoodsForecastUserSaleGroupDataAddEditForm.vue"
import TableBar from "@/layouts/components/TableBar/index.vue"
import {ElTable} from "element-plus";
import {HeaderInfo, postResultInfo} from "@@/utils/common-js.ts"
import {type ApsGoodsForecastUserSaleGroupData} from "./ApsGoodsForecastUserSaleGroupDataType.ts"

const dtoUrl = ref<string>("/apsGoodsForecastUserSaleGroupData")
const documentTitle = ref<string>("预测销售组数据")
const dataBatchDeleteUrl = ref<string>(`${dtoUrl.value}/deleteByIdList`)

// 查询表格
const queryForm = ref<ApsGoodsForecastUserSaleGroupData>({
  forecastId: undefined,
  saleConfigParentList: undefined,
  saleConfigList: undefined,
  year: undefined,
  month01: undefined,
  month02: undefined,
  month03: undefined,
  month04: undefined,
  month05: undefined,
  month06: undefined,
  month07: undefined,
  month08: undefined,
  month09: undefined,
  month10: undefined,
  month11: undefined,
  month12: undefined,
  monthResult01: undefined,
  monthResult02: undefined,
  monthResult03: undefined,
  monthResult04: undefined,
  monthResult05: undefined,
  monthResult06: undefined,
  monthResult07: undefined,
  monthResult08: undefined,
  monthResult09: undefined,
  monthResult10: undefined,
  monthResult11: undefined,
  monthResult12: undefined,
  id: undefined
})

// 表格
// 表格选中的id
const multipleSelection = ref<(string | undefined)[]>([])
// const dataTableRef = ref<InstanceType<typeof ElTable> | null>(null)
const dataTableRef = ref({})
// 表格操作头
const tableBarRef = ref<InstanceType<typeof TableBar> | null>(null)
// 表格相关
const dataList = ref<ApsGoodsForecastUserSaleGroupData[]>([])
const currentPageNum = ref<number>(1)
const currentPageSize = ref<number>(10)
const tableTotal = ref<number>(0)
const headerList = ref<HeaderInfo[]>([
  {fieldName: "id", showName: "序号"},
  {fieldName: "forecastId", showName: ""},
  {fieldName: "saleConfigParentList", showName: "销售组 [{id:,name,code}]"},
  {fieldName: "saleConfigList", showName: "销售配置 [{id:,name,code}]"},
  {fieldName: "year", showName: "年份"},
  {fieldName: "month01", showName: ""},
  {fieldName: "month02", showName: ""},
  {fieldName: "month03", showName: ""},
  {fieldName: "month04", showName: ""},
  {fieldName: "month05", showName: ""},
  {fieldName: "month06", showName: ""},
  {fieldName: "month07", showName: ""},
  {fieldName: "month08", showName: ""},
  {fieldName: "month09", showName: ""},
  {fieldName: "month10", showName: ""},
  {fieldName: "month11", showName: ""},
  {fieldName: "month12", showName: ""},
  {fieldName: "monthResult01", showName: ""},
  {fieldName: "monthResult02", showName: ""},
  {fieldName: "monthResult03", showName: ""},
  {fieldName: "monthResult04", showName: ""},
  {fieldName: "monthResult05", showName: ""},
  {fieldName: "monthResult06", showName: ""},
  {fieldName: "monthResult07", showName: ""},
  {fieldName: "monthResult08", showName: ""},
  {fieldName: "monthResult09", showName: ""},
  {fieldName: "monthResult10", showName: ""},
  {fieldName: "monthResult11", showName: ""},
  {fieldName: "monthResult12", showName: ""},
])

// 获取表格内数据
const getDataList = () => {
  const req = {
    pageSize: currentPageSize.value,
    pageNum: currentPageNum.value,
    data: queryForm.value
  }
  console.info("getDataList {}", req)
  postResultInfo(`${dtoUrl.value}/queryPageList`, req)
  .then((t) => {
    dataList.value = t.data.dataList
    tableTotal.value = Number.parseInt(t.data.total)
    headerList.value = t.data.headerList
  })
}

// table点击事件
const editData = (data: any) => {
  // console.info("data ", data)
  tableBarRef.value?.showEditDialog(data.id)
}
// 页面条数变更事件
const handleSizeChange = (val: number) => {
  currentPageSize.value = val
  getDataList()
}
// 页面变更事件
const handleCurrentChange = (val: number) => {
  currentPageNum.value = val
  getDataList()
}
// 表格选中事件
const handleSelectionChange = (val: ApsGoodsForecastUserSaleGroupData[]) => {
  multipleSelection.value = val.map(t => t.id)
  console.info("multipleSelection ", multipleSelection)
}

// 页面加载事件
onMounted(() => {
  getDataList()
})
</script>

<template>
  <div class="app-container">
    <el-card class="search-wrapper" shadow="never">
      <el-form v-model="queryForm" inline>
        <el-form-item label="${column.comment}" prop="forecastId">
          <el-input v-model="queryForm.forecastId" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="销售组 [{id:,name,code}]" prop="saleConfigParentList">
          <el-input v-model="queryForm.saleConfigParentList" clearable
                    placeholder="请输入销售组 [{id:,name,code}]"/>
        </el-form-item>
        <el-form-item label="销售配置 [{id:,name,code}]" prop="saleConfigList">
          <el-input v-model="queryForm.saleConfigList" clearable
                    placeholder="请输入销售配置 [{id:,name,code}]"/>
        </el-form-item>
        <el-form-item label="年份" prop="year">
          <el-input v-model="queryForm.year" clearable placeholder="请输入年份"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month01">
          <el-input v-model="queryForm.month01" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month02">
          <el-input v-model="queryForm.month02" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month03">
          <el-input v-model="queryForm.month03" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month04">
          <el-input v-model="queryForm.month04" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month05">
          <el-input v-model="queryForm.month05" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month06">
          <el-input v-model="queryForm.month06" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month07">
          <el-input v-model="queryForm.month07" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month08">
          <el-input v-model="queryForm.month08" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month09">
          <el-input v-model="queryForm.month09" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month10">
          <el-input v-model="queryForm.month10" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month11">
          <el-input v-model="queryForm.month11" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month12">
          <el-input v-model="queryForm.month12" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult01">
          <el-input v-model="queryForm.monthResult01" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult02">
          <el-input v-model="queryForm.monthResult02" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult03">
          <el-input v-model="queryForm.monthResult03" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult04">
          <el-input v-model="queryForm.monthResult04" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult05">
          <el-input v-model="queryForm.monthResult05" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult06">
          <el-input v-model="queryForm.monthResult06" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult07">
          <el-input v-model="queryForm.monthResult07" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult08">
          <el-input v-model="queryForm.monthResult08" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult09">
          <el-input v-model="queryForm.monthResult09" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult10">
          <el-input v-model="queryForm.monthResult10" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult11">
          <el-input v-model="queryForm.monthResult11" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="monthResult12">
          <el-input v-model="queryForm.monthResult12" clearable
                    placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="search" @click="getDataList">
            查询
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <el-card shadow="never">
      <TableBar
          :document-title="documentTitle"
          :add-component="AddEditFormVue"
          :refresh-list="getDataList"
          :data-table-ref="dataTableRef"
          :multiple-selection="multipleSelection"
          ref="tableBarRef"
          :data-batch-delete-url="dataBatchDeleteUrl"
      />
      <ElTable ref="dataTableRef" :data="dataList" stripe @selection-change="handleSelectionChange">
        <ElTableColumn type="selection"/>
        <ElTableColumn v-for="h in headerList" :key="h.fieldName" :label="h.showName"
                       :prop="h.fieldName"/>
        <ElTableColumn fixed="right" label="操作" width="150px">
          <template #default="scope">
            <el-button
                type="warning"
                icon="edit"
                @click="editData(scope.row)"
            >
              编辑
            </el-button>
          </template>
        </ElTableColumn>
      </ElTable>
      <el-row class="paginationDiv">
        <el-pagination
            background
            v-model:current-page="currentPageNum"
            v-model:page-size="currentPageSize"
            layout="total, sizes, prev, pager, next"
            :total="tableTotal"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
        />
      </el-row>
    </el-card>
  </div>
</template>

<style scoped lang="scss">

</style>

