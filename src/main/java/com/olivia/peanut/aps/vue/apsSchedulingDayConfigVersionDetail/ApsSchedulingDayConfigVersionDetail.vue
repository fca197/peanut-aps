<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="${column.comment}" prop="schedulingDayId">
        <el-input v-model="queryParams.data.schedulingDayId" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="配置类型 sale,part,bom" prop="configBizType">
        <el-input v-model="queryParams.data.configBizType" clearable placeholder="请输入配置类型 sale,part,bom"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="配置业务ID" prop="configBizId">
        <el-input v-model="queryParams.data.configBizId" clearable placeholder="请输入配置业务ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="配置业务名称" prop="configBizName">
        <el-input v-model="queryParams.data.configBizName" clearable placeholder="请输入配置业务名称"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="配置业务数量" prop="configBizNum">
        <el-input v-model="queryParams.data.configBizNum" clearable placeholder="请输入配置业务数量"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单ID" prop="orderId">
        <el-input v-model="queryParams.data.orderId" clearable placeholder="请输入订单ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单编号" prop="orderNo">
        <el-input v-model="queryParams.data.orderNo" clearable placeholder="请输入订单编号"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="房间id" prop="roomId">
        <el-input v-model="queryParams.data.roomId" clearable placeholder="请输入房间id"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态 Id" prop="statusId">
        <el-input v-model="queryParams.data.statusId" clearable placeholder="请输入状态 Id"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="排序" prop="sortIndex">
        <el-input v-model="queryParams.data.sortIndex" clearable placeholder="请输入排序"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否匹配 0 否,1 是" prop="isMatch">
        <el-input v-model="queryParams.data.isMatch" clearable placeholder="请输入是否匹配 0 否,1 是"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="循环次数" prop="loopIndex">
        <el-input v-model="queryParams.data.loopIndex" clearable placeholder="请输入循环次数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="是否满足 0 否,1 是" prop="loopEnough">
        <el-input v-model="queryParams.data.loopEnough" clearable placeholder="请输入是否满足 0 否,1 是"
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

    <el-table v-loading="loading" :data="apsSchedulingDayConfigVersionDetailList"
              @selection-change="handleSelectionChange">
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

        <el-form-item label="${column.comment}" prop="schedulingDayId">
          <el-input v-model="form.schedulingDayId" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="配置类型 sale,part,bom" prop="configBizType">
          <el-input v-model="form.configBizType" clearable placeholder="请输入配置类型 sale,part,bom"/>
        </el-form-item>
        <el-form-item label="配置业务ID" prop="configBizId">
          <el-input v-model="form.configBizId" clearable placeholder="请输入配置业务ID"/>
        </el-form-item>
        <el-form-item label="配置业务名称" prop="configBizName">
          <el-input v-model="form.configBizName" clearable placeholder="请输入配置业务名称"/>
        </el-form-item>
        <el-form-item label="配置业务数量" prop="configBizNum">
          <el-input v-model="form.configBizNum" clearable placeholder="请输入配置业务数量"/>
        </el-form-item>
        <el-form-item label="订单ID" prop="orderId">
          <el-input v-model="form.orderId" clearable placeholder="请输入订单ID"/>
        </el-form-item>
        <el-form-item label="订单编号" prop="orderNo">
          <el-input v-model="form.orderNo" clearable placeholder="请输入订单编号"/>
        </el-form-item>
        <el-form-item label="房间id" prop="roomId">
          <el-input v-model="form.roomId" clearable placeholder="请输入房间id"/>
        </el-form-item>
        <el-form-item label="状态 Id" prop="statusId">
          <el-input v-model="form.statusId" clearable placeholder="请输入状态 Id"/>
        </el-form-item>
        <el-form-item label="排序" prop="sortIndex">
          <el-input v-model="form.sortIndex" clearable placeholder="请输入排序"/>
        </el-form-item>
        <el-form-item label="是否匹配 0 否,1 是" prop="isMatch">
          <el-input v-model="form.isMatch" clearable placeholder="请输入是否匹配 0 否,1 是"/>
        </el-form-item>
        <el-form-item label="循环次数" prop="loopIndex">
          <el-input v-model="form.loopIndex" clearable placeholder="请输入循环次数"/>
        </el-form-item>
        <el-form-item label="是否满足 0 否,1 是" prop="loopEnough">
          <el-input v-model="form.loopEnough" clearable placeholder="请输入是否满足 0 否,1 是"/>
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
      apsSchedulingDayConfigVersionDetailList: [],
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
        schedulingDayId: undefined,
        configBizType: undefined,
        configBizId: undefined,
        configBizName: undefined,
        configBizNum: undefined,
        orderId: undefined,
        orderNo: undefined,
        roomId: undefined,
        statusId: undefined,
        sortIndex: undefined,
        isMatch: undefined,
        loopIndex: undefined,
        loopEnough: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        schedulingDayId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        configBizType: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        configBizId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        configBizName: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        configBizNum: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        roomId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        statusId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        sortIndex: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        isMatch: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        loopIndex: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        loopEnough: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsSchedulingDayConfigVersionDetail'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsSchedulingDayConfigVersionDetailList = response.dataList
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
        schedulingDayId: undefined,
        configBizType: undefined,
        configBizId: undefined,
        configBizName: undefined,
        configBizNum: undefined,
        orderId: undefined,
        orderNo: undefined,
        roomId: undefined,
        statusId: undefined,
        sortIndex: undefined,
        isMatch: undefined,
        loopIndex: undefined,
        loopEnough: undefined,
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
      this.title = '添加排程版本配置明细表'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改排程版本配置明细表'
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

