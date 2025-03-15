<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="订单ID" prop="schedulingId">
        <el-input v-model="queryParams.data.schedulingId" clearable placeholder="请输入订单ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="零件ID" prop="bomId">
        <el-input v-model="queryParams.data.bomId" clearable placeholder="请输入零件ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品零件ID" prop="goodsBomId">
        <el-input v-model="queryParams.data.goodsBomId" clearable placeholder="请输入商品零件ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="bom 编码" prop="bomCode">
        <el-input v-model="queryParams.data.bomCode" clearable placeholder="请输入bom 编码"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="bom 名称" prop="bomName">
        <el-input v-model="queryParams.data.bomName" clearable placeholder="请输入bom 名称"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用量" prop="bomUsage">
        <el-input v-model="queryParams.data.bomUsage" clearable placeholder="请输入使用量"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="单位" prop="bomUnit">
        <el-input v-model="queryParams.data.bomUnit" clearable placeholder="请输入单位"
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
      <el-form-item label="使用工位" prop="bomUseWorkStation">
        <el-input v-model="queryParams.data.bomUseWorkStation" clearable placeholder="请输入使用工位"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="使用时间" prop="bomUseDate">
        <el-input v-model="queryParams.data.bomUseDate" clearable placeholder="请输入使用时间"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="工厂ID" prop="factoryId">
        <el-input v-model="queryParams.data.factoryId" clearable placeholder="请输入工厂ID"
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

    <el-table v-loading="loading" :data="apsSchedulingGoodsBomTotalList" @selection-change="handleSelectionChange">
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

        <el-form-item label="订单ID" prop="schedulingId">
          <el-input v-model="form.schedulingId" clearable placeholder="请输入订单ID"/>
        </el-form-item>
        <el-form-item label="零件ID" prop="bomId">
          <el-input v-model="form.bomId" clearable placeholder="请输入零件ID"/>
        </el-form-item>
        <el-form-item label="商品零件ID" prop="goodsBomId">
          <el-input v-model="form.goodsBomId" clearable placeholder="请输入商品零件ID"/>
        </el-form-item>
        <el-form-item label="bom 编码" prop="bomCode">
          <el-input v-model="form.bomCode" clearable placeholder="请输入bom 编码"/>
        </el-form-item>
        <el-form-item label="bom 名称" prop="bomName">
          <el-input v-model="form.bomName" clearable placeholder="请输入bom 名称"/>
        </el-form-item>
        <el-form-item label="使用量" prop="bomUsage">
          <el-input v-model="form.bomUsage" clearable placeholder="请输入使用量"/>
        </el-form-item>
        <el-form-item label="单位" prop="bomUnit">
          <el-input v-model="form.bomUnit" clearable placeholder="请输入单位"/>
        </el-form-item>
        <el-form-item label="成本价" prop="bomCostPrice">
          <el-input v-model="form.bomCostPrice" clearable placeholder="请输入成本价"/>
        </el-form-item>
        <el-form-item label="单位" prop="bomCostPriceUnit">
          <el-input v-model="form.bomCostPriceUnit" clearable placeholder="请输入单位"/>
        </el-form-item>
        <el-form-item label="使用工位" prop="bomUseWorkStation">
          <el-input v-model="form.bomUseWorkStation" clearable placeholder="请输入使用工位"/>
        </el-form-item>
        <el-form-item label="使用时间" prop="bomUseDate">
          <el-input v-model="form.bomUseDate" clearable placeholder="请输入使用时间"/>
        </el-form-item>
        <el-form-item label="工厂ID" prop="factoryId">
          <el-input v-model="form.factoryId" clearable placeholder="请输入工厂ID"/>
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
      apsSchedulingGoodsBomTotalList: [],
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
        schedulingId: undefined,
        bomId: undefined,
        goodsBomId: undefined,
        bomCode: undefined,
        bomName: undefined,
        bomUsage: undefined,
        bomUnit: undefined,
        bomCostPrice: undefined,
        bomCostPriceUnit: undefined,
        bomUseWorkStation: undefined,
        bomUseDate: undefined,
        factoryId: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        schedulingId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        goodsBomId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
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
        bomUsage: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        bomUseWorkStation: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        bomUseDate: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        factoryId: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsSchedulingGoodsBomTotal'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsSchedulingGoodsBomTotalList = response.dataList
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
        schedulingId: undefined,
        bomId: undefined,
        goodsBomId: undefined,
        bomCode: undefined,
        bomName: undefined,
        bomUsage: undefined,
        bomUnit: undefined,
        bomCostPrice: undefined,
        bomCostPriceUnit: undefined,
        bomUseWorkStation: undefined,
        bomUseDate: undefined,
        factoryId: undefined,
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
      this.title = '添加订单商品零件汇总表'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改订单商品零件汇总表'
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

