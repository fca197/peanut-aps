<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="工厂ID" prop="factoryId">
        <el-input v-model="queryParams.data.factoryId" clearable placeholder="请输入工厂ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="商品ID" prop="goodsId">
        <el-input v-model="queryParams.data.goodsId" clearable placeholder="请输入商品ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="makeCapacityQuantity">
        <el-input v-model="queryParams.data.makeCapacityQuantity" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="year">
        <el-input v-model="queryParams.data.year" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="month">
        <el-input v-model="queryParams.data.month" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin1">
        <el-input v-model="queryParams.data.dayMin1" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax1">
        <el-input v-model="queryParams.data.dayMax1" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin2">
        <el-input v-model="queryParams.data.dayMin2" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax2">
        <el-input v-model="queryParams.data.dayMax2" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin3">
        <el-input v-model="queryParams.data.dayMin3" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax3">
        <el-input v-model="queryParams.data.dayMax3" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin4">
        <el-input v-model="queryParams.data.dayMin4" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax4">
        <el-input v-model="queryParams.data.dayMax4" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin5">
        <el-input v-model="queryParams.data.dayMin5" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax5">
        <el-input v-model="queryParams.data.dayMax5" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin6">
        <el-input v-model="queryParams.data.dayMin6" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax6">
        <el-input v-model="queryParams.data.dayMax6" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin7">
        <el-input v-model="queryParams.data.dayMin7" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax7">
        <el-input v-model="queryParams.data.dayMax7" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin8">
        <el-input v-model="queryParams.data.dayMin8" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax8">
        <el-input v-model="queryParams.data.dayMax8" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin9">
        <el-input v-model="queryParams.data.dayMin9" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax9">
        <el-input v-model="queryParams.data.dayMax9" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin10">
        <el-input v-model="queryParams.data.dayMin10" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax10">
        <el-input v-model="queryParams.data.dayMax10" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin11">
        <el-input v-model="queryParams.data.dayMin11" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax11">
        <el-input v-model="queryParams.data.dayMax11" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin12">
        <el-input v-model="queryParams.data.dayMin12" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax12">
        <el-input v-model="queryParams.data.dayMax12" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin13">
        <el-input v-model="queryParams.data.dayMin13" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax13">
        <el-input v-model="queryParams.data.dayMax13" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin14">
        <el-input v-model="queryParams.data.dayMin14" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax14">
        <el-input v-model="queryParams.data.dayMax14" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin15">
        <el-input v-model="queryParams.data.dayMin15" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax15">
        <el-input v-model="queryParams.data.dayMax15" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin16">
        <el-input v-model="queryParams.data.dayMin16" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax16">
        <el-input v-model="queryParams.data.dayMax16" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin17">
        <el-input v-model="queryParams.data.dayMin17" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax17">
        <el-input v-model="queryParams.data.dayMax17" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin18">
        <el-input v-model="queryParams.data.dayMin18" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax18">
        <el-input v-model="queryParams.data.dayMax18" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin19">
        <el-input v-model="queryParams.data.dayMin19" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax19">
        <el-input v-model="queryParams.data.dayMax19" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin20">
        <el-input v-model="queryParams.data.dayMin20" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax20">
        <el-input v-model="queryParams.data.dayMax20" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin21">
        <el-input v-model="queryParams.data.dayMin21" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax21">
        <el-input v-model="queryParams.data.dayMax21" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin22">
        <el-input v-model="queryParams.data.dayMin22" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax22">
        <el-input v-model="queryParams.data.dayMax22" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin23">
        <el-input v-model="queryParams.data.dayMin23" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax23">
        <el-input v-model="queryParams.data.dayMax23" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin24">
        <el-input v-model="queryParams.data.dayMin24" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax24">
        <el-input v-model="queryParams.data.dayMax24" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin25">
        <el-input v-model="queryParams.data.dayMin25" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax25">
        <el-input v-model="queryParams.data.dayMax25" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin26">
        <el-input v-model="queryParams.data.dayMin26" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax26">
        <el-input v-model="queryParams.data.dayMax26" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin27">
        <el-input v-model="queryParams.data.dayMin27" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax27">
        <el-input v-model="queryParams.data.dayMax27" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin28">
        <el-input v-model="queryParams.data.dayMin28" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax28">
        <el-input v-model="queryParams.data.dayMax28" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin29">
        <el-input v-model="queryParams.data.dayMin29" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax29">
        <el-input v-model="queryParams.data.dayMax29" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin30">
        <el-input v-model="queryParams.data.dayMin30" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax30">
        <el-input v-model="queryParams.data.dayMax30" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMin31">
        <el-input v-model="queryParams.data.dayMin31" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayMax31">
        <el-input v-model="queryParams.data.dayMax31" clearable placeholder="请输入制造数"
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

    <el-table v-loading="loading" :data="apsMakeCapacityGoodsList" @selection-change="handleSelectionChange">
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

        <el-form-item label="工厂ID" prop="factoryId">
          <el-input v-model="form.factoryId" clearable placeholder="请输入工厂ID"/>
        </el-form-item>
        <el-form-item label="商品ID" prop="goodsId">
          <el-input v-model="form.goodsId" clearable placeholder="请输入商品ID"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="makeCapacityQuantity">
          <el-input v-model="form.makeCapacityQuantity" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="year">
          <el-input v-model="form.year" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="month">
          <el-input v-model="form.month" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin1">
          <el-input v-model="form.dayMin1" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax1">
          <el-input v-model="form.dayMax1" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin2">
          <el-input v-model="form.dayMin2" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax2">
          <el-input v-model="form.dayMax2" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin3">
          <el-input v-model="form.dayMin3" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax3">
          <el-input v-model="form.dayMax3" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin4">
          <el-input v-model="form.dayMin4" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax4">
          <el-input v-model="form.dayMax4" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin5">
          <el-input v-model="form.dayMin5" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax5">
          <el-input v-model="form.dayMax5" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin6">
          <el-input v-model="form.dayMin6" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax6">
          <el-input v-model="form.dayMax6" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin7">
          <el-input v-model="form.dayMin7" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax7">
          <el-input v-model="form.dayMax7" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin8">
          <el-input v-model="form.dayMin8" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax8">
          <el-input v-model="form.dayMax8" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin9">
          <el-input v-model="form.dayMin9" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax9">
          <el-input v-model="form.dayMax9" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin10">
          <el-input v-model="form.dayMin10" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax10">
          <el-input v-model="form.dayMax10" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin11">
          <el-input v-model="form.dayMin11" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax11">
          <el-input v-model="form.dayMax11" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin12">
          <el-input v-model="form.dayMin12" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax12">
          <el-input v-model="form.dayMax12" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin13">
          <el-input v-model="form.dayMin13" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax13">
          <el-input v-model="form.dayMax13" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin14">
          <el-input v-model="form.dayMin14" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax14">
          <el-input v-model="form.dayMax14" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin15">
          <el-input v-model="form.dayMin15" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax15">
          <el-input v-model="form.dayMax15" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin16">
          <el-input v-model="form.dayMin16" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax16">
          <el-input v-model="form.dayMax16" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin17">
          <el-input v-model="form.dayMin17" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax17">
          <el-input v-model="form.dayMax17" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin18">
          <el-input v-model="form.dayMin18" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax18">
          <el-input v-model="form.dayMax18" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin19">
          <el-input v-model="form.dayMin19" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax19">
          <el-input v-model="form.dayMax19" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin20">
          <el-input v-model="form.dayMin20" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax20">
          <el-input v-model="form.dayMax20" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin21">
          <el-input v-model="form.dayMin21" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax21">
          <el-input v-model="form.dayMax21" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin22">
          <el-input v-model="form.dayMin22" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax22">
          <el-input v-model="form.dayMax22" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin23">
          <el-input v-model="form.dayMin23" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax23">
          <el-input v-model="form.dayMax23" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin24">
          <el-input v-model="form.dayMin24" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax24">
          <el-input v-model="form.dayMax24" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin25">
          <el-input v-model="form.dayMin25" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax25">
          <el-input v-model="form.dayMax25" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin26">
          <el-input v-model="form.dayMin26" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax26">
          <el-input v-model="form.dayMax26" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin27">
          <el-input v-model="form.dayMin27" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax27">
          <el-input v-model="form.dayMax27" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin28">
          <el-input v-model="form.dayMin28" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax28">
          <el-input v-model="form.dayMax28" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin29">
          <el-input v-model="form.dayMin29" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax29">
          <el-input v-model="form.dayMax29" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin30">
          <el-input v-model="form.dayMin30" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax30">
          <el-input v-model="form.dayMax30" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMin31">
          <el-input v-model="form.dayMin31" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayMax31">
          <el-input v-model="form.dayMax31" clearable placeholder="请输入制造数"/>
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
      apsMakeCapacityGoodsList: [],
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
        factoryId: undefined,
        goodsId: undefined,
        makeCapacityQuantity: undefined,
        year: undefined,
        month: undefined,
        dayMin1: undefined,
        dayMax1: undefined,
        dayMin2: undefined,
        dayMax2: undefined,
        dayMin3: undefined,
        dayMax3: undefined,
        dayMin4: undefined,
        dayMax4: undefined,
        dayMin5: undefined,
        dayMax5: undefined,
        dayMin6: undefined,
        dayMax6: undefined,
        dayMin7: undefined,
        dayMax7: undefined,
        dayMin8: undefined,
        dayMax8: undefined,
        dayMin9: undefined,
        dayMax9: undefined,
        dayMin10: undefined,
        dayMax10: undefined,
        dayMin11: undefined,
        dayMax11: undefined,
        dayMin12: undefined,
        dayMax12: undefined,
        dayMin13: undefined,
        dayMax13: undefined,
        dayMin14: undefined,
        dayMax14: undefined,
        dayMin15: undefined,
        dayMax15: undefined,
        dayMin16: undefined,
        dayMax16: undefined,
        dayMin17: undefined,
        dayMax17: undefined,
        dayMin18: undefined,
        dayMax18: undefined,
        dayMin19: undefined,
        dayMax19: undefined,
        dayMin20: undefined,
        dayMax20: undefined,
        dayMin21: undefined,
        dayMax21: undefined,
        dayMin22: undefined,
        dayMax22: undefined,
        dayMin23: undefined,
        dayMax23: undefined,
        dayMin24: undefined,
        dayMax24: undefined,
        dayMin25: undefined,
        dayMax25: undefined,
        dayMin26: undefined,
        dayMax26: undefined,
        dayMin27: undefined,
        dayMax27: undefined,
        dayMin28: undefined,
        dayMax28: undefined,
        dayMin29: undefined,
        dayMax29: undefined,
        dayMin30: undefined,
        dayMax30: undefined,
        dayMin31: undefined,
        dayMax31: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        factoryId: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        makeCapacityQuantity: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        year: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        month: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin1: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax1: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin2: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax2: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin3: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax3: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin4: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax4: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin5: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax5: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin6: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax6: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin7: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax7: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin8: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax8: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin9: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax9: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin10: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax10: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin11: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax11: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin12: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax12: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin13: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax13: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin14: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax14: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin15: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax15: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin16: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax16: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin17: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax17: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin18: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax18: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin19: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax19: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin20: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax20: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin21: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax21: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin22: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax22: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin23: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax23: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin24: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax24: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin25: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax25: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin26: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax26: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin27: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax27: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin28: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax28: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin29: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax29: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin30: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax30: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMin31: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayMax31: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsMakeCapacityGoods'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsMakeCapacityGoodsList = response.dataList
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
        factoryId: undefined,
        goodsId: undefined,
        makeCapacityQuantity: undefined,
        year: undefined,
        month: undefined,
        dayMin1: undefined,
        dayMax1: undefined,
        dayMin2: undefined,
        dayMax2: undefined,
        dayMin3: undefined,
        dayMax3: undefined,
        dayMin4: undefined,
        dayMax4: undefined,
        dayMin5: undefined,
        dayMax5: undefined,
        dayMin6: undefined,
        dayMax6: undefined,
        dayMin7: undefined,
        dayMax7: undefined,
        dayMin8: undefined,
        dayMax8: undefined,
        dayMin9: undefined,
        dayMax9: undefined,
        dayMin10: undefined,
        dayMax10: undefined,
        dayMin11: undefined,
        dayMax11: undefined,
        dayMin12: undefined,
        dayMax12: undefined,
        dayMin13: undefined,
        dayMax13: undefined,
        dayMin14: undefined,
        dayMax14: undefined,
        dayMin15: undefined,
        dayMax15: undefined,
        dayMin16: undefined,
        dayMax16: undefined,
        dayMin17: undefined,
        dayMax17: undefined,
        dayMin18: undefined,
        dayMax18: undefined,
        dayMin19: undefined,
        dayMax19: undefined,
        dayMin20: undefined,
        dayMax20: undefined,
        dayMin21: undefined,
        dayMax21: undefined,
        dayMin22: undefined,
        dayMax22: undefined,
        dayMin23: undefined,
        dayMax23: undefined,
        dayMin24: undefined,
        dayMax24: undefined,
        dayMin25: undefined,
        dayMax25: undefined,
        dayMin26: undefined,
        dayMax26: undefined,
        dayMin27: undefined,
        dayMax27: undefined,
        dayMin28: undefined,
        dayMax28: undefined,
        dayMin29: undefined,
        dayMax29: undefined,
        dayMin30: undefined,
        dayMax30: undefined,
        dayMin31: undefined,
        dayMax31: undefined,
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
      this.title = '添加工厂产能商品'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改工厂产能商品'
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

