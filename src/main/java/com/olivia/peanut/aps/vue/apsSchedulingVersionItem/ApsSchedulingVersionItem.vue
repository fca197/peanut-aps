<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="${column.comment}" prop="schedulingVersionId">
        <el-input v-model="queryParams.data.schedulingVersionId" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="orderId">
        <el-input v-model="queryParams.data.orderId" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单号" prop="orderNo">
        <el-input v-model="queryParams.data.orderNo" clearable placeholder="请输入订单号"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品ID" prop="goodsId">
        <el-input v-model="queryParams.data.goodsId" clearable placeholder="请输入商品ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field0">
        <el-input v-model="queryParams.data.field0" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field1">
        <el-input v-model="queryParams.data.field1" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field2">
        <el-input v-model="queryParams.data.field2" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field3">
        <el-input v-model="queryParams.data.field3" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field4">
        <el-input v-model="queryParams.data.field4" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field5">
        <el-input v-model="queryParams.data.field5" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field6">
        <el-input v-model="queryParams.data.field6" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field7">
        <el-input v-model="queryParams.data.field7" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field8">
        <el-input v-model="queryParams.data.field8" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field9">
        <el-input v-model="queryParams.data.field9" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field10">
        <el-input v-model="queryParams.data.field10" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field11">
        <el-input v-model="queryParams.data.field11" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field12">
        <el-input v-model="queryParams.data.field12" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field13">
        <el-input v-model="queryParams.data.field13" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field14">
        <el-input v-model="queryParams.data.field14" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field15">
        <el-input v-model="queryParams.data.field15" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field16">
        <el-input v-model="queryParams.data.field16" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field17">
        <el-input v-model="queryParams.data.field17" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field18">
        <el-input v-model="queryParams.data.field18" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field19">
        <el-input v-model="queryParams.data.field19" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="field20">
        <el-input v-model="queryParams.data.field20" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="resultType">
        <el-input v-model="queryParams.data.resultType" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="numberIndex">
        <el-input v-model="queryParams.data.numberIndex" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="factoryId">
        <el-input v-model="queryParams.data.factoryId" clearable placeholder="请输入${column.comment}"
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

    <el-table v-loading="loading" :data="apsSchedulingVersionItemList" @selection-change="handleSelectionChange">
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

        <el-form-item label="${column.comment}" prop="schedulingVersionId">
          <el-input v-model="form.schedulingVersionId" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="orderId">
          <el-input v-model="form.orderId" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="订单号" prop="orderNo">
          <el-input v-model="form.orderNo" clearable placeholder="请输入订单号"/>
        </el-form-item>
        <el-form-item label="商品ID" prop="goodsId">
          <el-input v-model="form.goodsId" clearable placeholder="请输入商品ID"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field0">
          <el-input v-model="form.field0" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field1">
          <el-input v-model="form.field1" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field2">
          <el-input v-model="form.field2" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field3">
          <el-input v-model="form.field3" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field4">
          <el-input v-model="form.field4" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field5">
          <el-input v-model="form.field5" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field6">
          <el-input v-model="form.field6" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field7">
          <el-input v-model="form.field7" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field8">
          <el-input v-model="form.field8" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field9">
          <el-input v-model="form.field9" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field10">
          <el-input v-model="form.field10" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field11">
          <el-input v-model="form.field11" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field12">
          <el-input v-model="form.field12" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field13">
          <el-input v-model="form.field13" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field14">
          <el-input v-model="form.field14" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field15">
          <el-input v-model="form.field15" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field16">
          <el-input v-model="form.field16" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field17">
          <el-input v-model="form.field17" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field18">
          <el-input v-model="form.field18" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field19">
          <el-input v-model="form.field19" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="field20">
          <el-input v-model="form.field20" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="resultType">
          <el-input v-model="form.resultType" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="numberIndex">
          <el-input v-model="form.numberIndex" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="factoryId">
          <el-input v-model="form.factoryId" clearable placeholder="请输入${column.comment}"/>
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
      apsSchedulingVersionItemList: [],
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
        schedulingVersionId: undefined,
        orderId: undefined,
        orderNo: undefined,
        goodsId: undefined,
        field0: undefined,
        field1: undefined,
        field2: undefined,
        field3: undefined,
        field4: undefined,
        field5: undefined,
        field6: undefined,
        field7: undefined,
        field8: undefined,
        field9: undefined,
        field10: undefined,
        field11: undefined,
        field12: undefined,
        field13: undefined,
        field14: undefined,
        field15: undefined,
        field16: undefined,
        field17: undefined,
        field18: undefined,
        field19: undefined,
        field20: undefined,
        resultType: undefined,
        numberIndex: undefined,
        factoryId: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        schedulingVersionId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        orderNo: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        field0: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field1: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field2: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field3: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field4: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field5: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field6: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field7: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field8: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field9: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field10: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field11: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field12: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field13: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field14: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field15: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field16: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field17: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field18: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field19: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        field20: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        resultType: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        numberIndex: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsSchedulingVersionItem'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsSchedulingVersionItemList = response.dataList
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
        schedulingVersionId: undefined,
        orderId: undefined,
        orderNo: undefined,
        goodsId: undefined,
        field0: undefined,
        field1: undefined,
        field2: undefined,
        field3: undefined,
        field4: undefined,
        field5: undefined,
        field6: undefined,
        field7: undefined,
        field8: undefined,
        field9: undefined,
        field10: undefined,
        field11: undefined,
        field12: undefined,
        field13: undefined,
        field14: undefined,
        field15: undefined,
        field16: undefined,
        field17: undefined,
        field18: undefined,
        field19: undefined,
        field20: undefined,
        resultType: undefined,
        numberIndex: undefined,
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
      this.title = '添加排产版本项表'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改排产版本项表'
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

