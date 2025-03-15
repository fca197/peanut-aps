<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="${column.comment}" prop="orderNo">
        <el-input v-model="queryParams.data.orderNo" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="orderRemark">
        <el-input v-model="queryParams.data.orderRemark" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单状态" prop="orderStatus">
        <el-input v-model="queryParams.data.orderStatus" clearable placeholder="请输入订单状态"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="成本价" prop="orderTotalPrice">
        <el-input v-model="queryParams.data.orderTotalPrice" clearable placeholder="请输入成本价"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品ID" prop="goodsId">
        <el-input v-model="queryParams.data.goodsId" clearable placeholder="请输入商品ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="总价" prop="reserveAmount">
        <el-input v-model="queryParams.data.reserveAmount" clearable placeholder="请输入总价"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="reserveDatetime">
        <el-input v-model="queryParams.data.reserveDatetime" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="总价" prop="finishPayedAmount">
        <el-input v-model="queryParams.data.finishPayedAmount" clearable placeholder="请输入总价"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="finishPayedDatetime">
        <el-input v-model="queryParams.data.finishPayedDatetime" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="makeFinishDate">
        <el-input v-model="queryParams.data.makeFinishDate" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="deliveryDate">
        <el-input v-model="queryParams.data.deliveryDate" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="工厂ID" prop="factoryId">
        <el-input v-model="queryParams.data.factoryId" clearable placeholder="请输入工厂ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="紧急度0最小,越大越紧急" prop="urgencyLevel">
        <el-input v-model="queryParams.data.urgencyLevel" clearable placeholder="请输入紧急度0最小,越大越紧急"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="排产时间" prop="schedulingDate">
        <el-input v-model="queryParams.data.schedulingDate" clearable placeholder="请输入排产时间"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="父订单号" prop="orderNoParent">
        <el-input v-model="queryParams.data.orderNoParent" clearable placeholder="请输入父订单号"
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

    <el-table v-loading="loading" :data="apsOrderList" @selection-change="handleSelectionChange">
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

        <el-form-item label="${column.comment}" prop="orderNo">
          <el-input v-model="form.orderNo" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="orderRemark">
          <el-input v-model="form.orderRemark" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="订单状态" prop="orderStatus">
          <el-input v-model="form.orderStatus" clearable placeholder="请输入订单状态"/>
        </el-form-item>
        <el-form-item label="成本价" prop="orderTotalPrice">
          <el-input v-model="form.orderTotalPrice" clearable placeholder="请输入成本价"/>
        </el-form-item>
        <el-form-item label="商品ID" prop="goodsId">
          <el-input v-model="form.goodsId" clearable placeholder="请输入商品ID"/>
        </el-form-item>
        <el-form-item label="总价" prop="reserveAmount">
          <el-input v-model="form.reserveAmount" clearable placeholder="请输入总价"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="reserveDatetime">
          <el-input v-model="form.reserveDatetime" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="总价" prop="finishPayedAmount">
          <el-input v-model="form.finishPayedAmount" clearable placeholder="请输入总价"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="finishPayedDatetime">
          <el-input v-model="form.finishPayedDatetime" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="makeFinishDate">
          <el-input v-model="form.makeFinishDate" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="deliveryDate">
          <el-input v-model="form.deliveryDate" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="工厂ID" prop="factoryId">
          <el-input v-model="form.factoryId" clearable placeholder="请输入工厂ID"/>
        </el-form-item>
        <el-form-item label="紧急度0最小,越大越紧急" prop="urgencyLevel">
          <el-input v-model="form.urgencyLevel" clearable placeholder="请输入紧急度0最小,越大越紧急"/>
        </el-form-item>
        <el-form-item label="排产时间" prop="schedulingDate">
          <el-input v-model="form.schedulingDate" clearable placeholder="请输入排产时间"/>
        </el-form-item>
        <el-form-item label="父订单号" prop="orderNoParent">
          <el-input v-model="form.orderNoParent" clearable placeholder="请输入父订单号"/>
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
      apsOrderList: [],
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
        orderNo: undefined,
        orderRemark: undefined,
        orderStatus: undefined,
        orderTotalPrice: undefined,
        goodsId: undefined,
        reserveAmount: undefined,
        reserveDatetime: undefined,
        finishPayedAmount: undefined,
        finishPayedDatetime: undefined,
        makeFinishDate: undefined,
        deliveryDate: undefined,
        factoryId: undefined,
        urgencyLevel: undefined,
        schedulingDate: undefined,
        orderNoParent: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        orderNo: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderRemark: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderStatus: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderTotalPrice: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        goodsId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        reserveAmount: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        reserveDatetime: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        finishPayedAmount: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        finishPayedDatetime: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        makeFinishDate: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        deliveryDate: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        urgencyLevel: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        schedulingDate: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderNoParent: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsOrder'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsOrderList = response.dataList
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
        orderNo: undefined,
        orderRemark: undefined,
        orderStatus: undefined,
        orderTotalPrice: undefined,
        goodsId: undefined,
        reserveAmount: undefined,
        reserveDatetime: undefined,
        finishPayedAmount: undefined,
        finishPayedDatetime: undefined,
        makeFinishDate: undefined,
        deliveryDate: undefined,
        factoryId: undefined,
        urgencyLevel: undefined,
        schedulingDate: undefined,
        orderNoParent: undefined,
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
      this.title = '添加订单表'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改订单表'
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

