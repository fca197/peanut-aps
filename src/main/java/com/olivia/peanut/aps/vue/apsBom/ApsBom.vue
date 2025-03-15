<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="bom 编码" prop="bomCode">
        <el-input v-model="queryParams.data.bomCode" clearable placeholder="请输入bom 编码"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="bom 名称" prop="bomName">
        <el-input v-model="queryParams.data.bomName" clearable placeholder="请输入bom 名称"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="成本价" prop="bomCostPrice">
        <el-input v-model="queryParams.data.bomCostPrice" clearable placeholder="请输入成本价"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="单位" prop="bomCostPriceUnit">
        <el-input v-model="queryParams.data.bomCostPriceUnit" clearable placeholder="请输入单位"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="库存" prop="bomInventory">
        <el-input v-model="queryParams.data.bomInventory" clearable placeholder="请输入库存"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="组ID" prop="groupId">
        <el-input v-model="queryParams.data.groupId" clearable placeholder="请输入组ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="供给方式 make, buy" prop="supplyMode">
        <el-input v-model="queryParams.data.supplyMode" clearable placeholder="请输入供给方式 make, buy"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用单位" prop="useUnit">
        <el-input v-model="queryParams.data.useUnit" clearable placeholder="请输入使用单位"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="零件单位" prop="bomUnit">
        <el-input v-model="queryParams.data.bomUnit" clearable placeholder="请输入零件单位"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造路径" prop="produceProcessId">
        <el-input v-model="queryParams.data.produceProcessId" clearable placeholder="请输入制造路径"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button icon="el-icon-plus" plain size="mini" type="primary" @click="handleAdd"></el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button :disabled="multiple" icon="el-icon-delete" plain size="mini" type="danger"
                   @click="handleDelete"></el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="apsBomList" @selection-change="handleSelectionChange">
      <el-table-column align="center" label="全选" prop="id" type="selection" width="50"/>
      <el-table-column v-for="(item,index) in  tableHeaderList" :key="index" :label="item.showName"
                       :prop="item.fieldName" :width="item.width+'px'" align="center"/>
      <el-table-column align="center" class-name="small-padding fixed-width" label="操作">
        <template slot-scope="scope">
          <el-button icon="el-icon-edit" size="mini" type="text" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button icon="el-icon-delete" size="mini" type="text" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
        v-show="total>0"
        :limit.sync="queryParams.pageSize"
        :page.sync="queryParams.pageNum"
        :total="total"
        @pagination="getList"
    />

    <!-- 添加或修改参数配置对话框 -->
    <el-dialog :title="title" :visible.sync="open" append-to-body width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">

        <el-form-item label="bom 编码" prop="bomCode">
          <el-input v-model="form.bomCode" clearable placeholder="请输入bom 编码"/>
        </el-form-item>
        <el-form-item label="bom 名称" prop="bomName">
          <el-input v-model="form.bomName" clearable placeholder="请输入bom 名称"/>
        </el-form-item>
        <el-form-item label="成本价" prop="bomCostPrice">
          <el-input v-model="form.bomCostPrice" clearable placeholder="请输入成本价"/>
        </el-form-item>
        <el-form-item label="单位" prop="bomCostPriceUnit">
          <el-input v-model="form.bomCostPriceUnit" clearable placeholder="请输入单位"/>
        </el-form-item>
        <el-form-item label="库存" prop="bomInventory">
          <el-input v-model="form.bomInventory" clearable placeholder="请输入库存"/>
        </el-form-item>
        <el-form-item label="组ID" prop="groupId">
          <el-input v-model="form.groupId" clearable placeholder="请输入组ID"/>
        </el-form-item>
        <el-form-item label="供给方式 make, buy" prop="supplyMode">
          <el-input v-model="form.supplyMode" clearable placeholder="请输入供给方式 make, buy"/>
        </el-form-item>
        <el-form-item label="使用单位" prop="useUnit">
          <el-input v-model="form.useUnit" clearable placeholder="请输入使用单位"/>
        </el-form-item>
        <el-form-item label="零件单位" prop="bomUnit">
          <el-input v-model="form.bomUnit" clearable placeholder="请输入零件单位"/>
        </el-form-item>
        <el-form-item label="制造路径" prop="produceProcessId">
          <el-input v-model="form.produceProcessId" clearable placeholder="请输入制造路径"/>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>


<script>

import {deleteList, getById, insetOrUpdate, queryPageList} from '@/api/common'

export default {
  name: 'tenantName',
  data() {

    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      apsBomList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        data: {}
      },
      // 表单参数
      form: {
        bomCode: undefined,
        bomName: undefined,
        bomCostPrice: undefined,
        bomCostPriceUnit: undefined,
        bomInventory: undefined,
        groupId: undefined,
        supplyMode: undefined,
        useUnit: undefined,
        bomUnit: undefined,
        produceProcessId: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        bomCode: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomName: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomCostPrice: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomCostPriceUnit: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomInventory: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        groupId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        supplyMode: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        useUnit: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomUnit: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        produceProcessId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
      },
      tableHeaderList: []
    }
  },
  created() {
    document['pagePath'] = '/apsBom'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsBomList = response.dataList
        this.total = parseInt(response.total)
        this.loading = false
      })
    },
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      let fid = this.form.id
      this.form = {
        bomCode: undefined,
        bomName: undefined,
        bomCostPrice: undefined,
        bomCostPriceUnit: undefined,
        bomInventory: undefined,
        groupId: undefined,
        supplyMode: undefined,
        useUnit: undefined,
        bomUnit: undefined,
        produceProcessId: undefined,
        id: fid
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.title = '添加BOM 清单'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改BOM 清单'
        this.open = true
      })

    },

    /** 提交按钮 */
    submitForm: function () {
      insetOrUpdate(this);
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      deleteList(row, this.ids, this.getList());
    }
  }

}


</script>

