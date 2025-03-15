<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="版本ID" prop="schedulingDayId">
        <el-input v-model="queryParams.data.schedulingDayId" clearable placeholder="请输入版本ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="订单ID" prop="orderId">
        <el-input v-model="queryParams.data.orderId" clearable placeholder="请输入订单ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="机器ID" prop="machineId">
        <el-input v-model="queryParams.data.machineId" clearable placeholder="请输入机器ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="状态ID" prop="statusId">
        <el-input v-model="queryParams.data.statusId" clearable placeholder="请输入状态ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="beginDateTime">
        <el-input v-model="queryParams.data.beginDateTime" clearable placeholder="请输入开始时间"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="结束时间" prop="endDateTime">
        <el-input v-model="queryParams.data.endDateTime" clearable placeholder="请输入结束时间"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="开始秒" prop="startSecond">
        <el-input v-model="queryParams.data.startSecond" clearable placeholder="请输入开始秒"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="结束秒" prop="endSecond">
        <el-input v-model="queryParams.data.endSecond" clearable placeholder="请输入结束秒"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="耗时（秒）" prop="useTime">
        <el-input v-model="queryParams.data.useTime" clearable placeholder="请输入耗时（秒）"
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

    <el-table v-loading="loading" :data="apsSchedulingDayConfigVersionDetailMachineList"
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

        <el-form-item label="版本ID" prop="schedulingDayId">
          <el-input v-model="form.schedulingDayId" clearable placeholder="请输入版本ID"/>
        </el-form-item>
        <el-form-item label="订单ID" prop="orderId">
          <el-input v-model="form.orderId" clearable placeholder="请输入订单ID"/>
        </el-form-item>
        <el-form-item label="机器ID" prop="machineId">
          <el-input v-model="form.machineId" clearable placeholder="请输入机器ID"/>
        </el-form-item>
        <el-form-item label="状态ID" prop="statusId">
          <el-input v-model="form.statusId" clearable placeholder="请输入状态ID"/>
        </el-form-item>
        <el-form-item label="开始时间" prop="beginDateTime">
          <el-input v-model="form.beginDateTime" clearable placeholder="请输入开始时间"/>
        </el-form-item>
        <el-form-item label="结束时间" prop="endDateTime">
          <el-input v-model="form.endDateTime" clearable placeholder="请输入结束时间"/>
        </el-form-item>
        <el-form-item label="开始秒" prop="startSecond">
          <el-input v-model="form.startSecond" clearable placeholder="请输入开始秒"/>
        </el-form-item>
        <el-form-item label="结束秒" prop="endSecond">
          <el-input v-model="form.endSecond" clearable placeholder="请输入结束秒"/>
        </el-form-item>
        <el-form-item label="耗时（秒）" prop="useTime">
          <el-input v-model="form.useTime" clearable placeholder="请输入耗时（秒）"/>
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
      apsSchedulingDayConfigVersionDetailMachineList: [],
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
        orderId: undefined,
        machineId: undefined,
        statusId: undefined,
        beginDateTime: undefined,
        endDateTime: undefined,
        startSecond: undefined,
        endSecond: undefined,
        useTime: undefined,
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
        orderId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        machineId: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        beginDateTime: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        endDateTime: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        startSecond: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        endSecond: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        useTime: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsSchedulingDayConfigVersionDetailMachine'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsSchedulingDayConfigVersionDetailMachineList = response.dataList
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
        orderId: undefined,
        machineId: undefined,
        statusId: undefined,
        beginDateTime: undefined,
        endDateTime: undefined,
        startSecond: undefined,
        endSecond: undefined,
        useTime: undefined,
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
      this.title = '添加排程版本详情_机器'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改排程版本详情_机器'
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

