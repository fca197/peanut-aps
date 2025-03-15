<template>
  <div class="app-container">
    <el-form v-show="showSearch" ref="queryForm" :inline="true" :model="queryParams" label-width="88px" size="small">
      <el-form-item label="商品ID" prop="goodsId">
        <el-input v-model="queryParams.data.goodsId" clearable placeholder="请输入商品ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="makeMonthId">
        <el-input v-model="queryParams.data.makeMonthId" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="projectConfigCode">
        <el-input v-model="queryParams.data.projectConfigCode" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="year">
        <el-input v-model="queryParams.data.year" clearable placeholder="请输入${column.comment}"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum1">
        <el-input v-model="queryParams.data.dayNum1" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum2">
        <el-input v-model="queryParams.data.dayNum2" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum3">
        <el-input v-model="queryParams.data.dayNum3" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum4">
        <el-input v-model="queryParams.data.dayNum4" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum5">
        <el-input v-model="queryParams.data.dayNum5" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum6">
        <el-input v-model="queryParams.data.dayNum6" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum7">
        <el-input v-model="queryParams.data.dayNum7" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum8">
        <el-input v-model="queryParams.data.dayNum8" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum9">
        <el-input v-model="queryParams.data.dayNum9" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum10">
        <el-input v-model="queryParams.data.dayNum10" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum11">
        <el-input v-model="queryParams.data.dayNum11" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum12">
        <el-input v-model="queryParams.data.dayNum12" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum13">
        <el-input v-model="queryParams.data.dayNum13" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum14">
        <el-input v-model="queryParams.data.dayNum14" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum15">
        <el-input v-model="queryParams.data.dayNum15" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum16">
        <el-input v-model="queryParams.data.dayNum16" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum17">
        <el-input v-model="queryParams.data.dayNum17" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum18">
        <el-input v-model="queryParams.data.dayNum18" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum19">
        <el-input v-model="queryParams.data.dayNum19" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum20">
        <el-input v-model="queryParams.data.dayNum20" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum21">
        <el-input v-model="queryParams.data.dayNum21" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum22">
        <el-input v-model="queryParams.data.dayNum22" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum23">
        <el-input v-model="queryParams.data.dayNum23" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum24">
        <el-input v-model="queryParams.data.dayNum24" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum25">
        <el-input v-model="queryParams.data.dayNum25" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum26">
        <el-input v-model="queryParams.data.dayNum26" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum27">
        <el-input v-model="queryParams.data.dayNum27" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum28">
        <el-input v-model="queryParams.data.dayNum28" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum29">
        <el-input v-model="queryParams.data.dayNum29" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum30">
        <el-input v-model="queryParams.data.dayNum30" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum31">
        <el-input v-model="queryParams.data.dayNum31" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum32">
        <el-input v-model="queryParams.data.dayNum32" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum33">
        <el-input v-model="queryParams.data.dayNum33" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum34">
        <el-input v-model="queryParams.data.dayNum34" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum35">
        <el-input v-model="queryParams.data.dayNum35" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum36">
        <el-input v-model="queryParams.data.dayNum36" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum37">
        <el-input v-model="queryParams.data.dayNum37" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum38">
        <el-input v-model="queryParams.data.dayNum38" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum39">
        <el-input v-model="queryParams.data.dayNum39" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum40">
        <el-input v-model="queryParams.data.dayNum40" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum41">
        <el-input v-model="queryParams.data.dayNum41" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum42">
        <el-input v-model="queryParams.data.dayNum42" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum43">
        <el-input v-model="queryParams.data.dayNum43" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum44">
        <el-input v-model="queryParams.data.dayNum44" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum45">
        <el-input v-model="queryParams.data.dayNum45" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum46">
        <el-input v-model="queryParams.data.dayNum46" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum47">
        <el-input v-model="queryParams.data.dayNum47" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum48">
        <el-input v-model="queryParams.data.dayNum48" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum49">
        <el-input v-model="queryParams.data.dayNum49" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum50">
        <el-input v-model="queryParams.data.dayNum50" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum51">
        <el-input v-model="queryParams.data.dayNum51" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum52">
        <el-input v-model="queryParams.data.dayNum52" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum53">
        <el-input v-model="queryParams.data.dayNum53" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum54">
        <el-input v-model="queryParams.data.dayNum54" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum55">
        <el-input v-model="queryParams.data.dayNum55" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum56">
        <el-input v-model="queryParams.data.dayNum56" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum57">
        <el-input v-model="queryParams.data.dayNum57" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum58">
        <el-input v-model="queryParams.data.dayNum58" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum59">
        <el-input v-model="queryParams.data.dayNum59" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum60">
        <el-input v-model="queryParams.data.dayNum60" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum61">
        <el-input v-model="queryParams.data.dayNum61" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum62">
        <el-input v-model="queryParams.data.dayNum62" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum63">
        <el-input v-model="queryParams.data.dayNum63" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum64">
        <el-input v-model="queryParams.data.dayNum64" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum65">
        <el-input v-model="queryParams.data.dayNum65" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum66">
        <el-input v-model="queryParams.data.dayNum66" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum67">
        <el-input v-model="queryParams.data.dayNum67" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum68">
        <el-input v-model="queryParams.data.dayNum68" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum69">
        <el-input v-model="queryParams.data.dayNum69" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum70">
        <el-input v-model="queryParams.data.dayNum70" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum71">
        <el-input v-model="queryParams.data.dayNum71" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum72">
        <el-input v-model="queryParams.data.dayNum72" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum73">
        <el-input v-model="queryParams.data.dayNum73" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum74">
        <el-input v-model="queryParams.data.dayNum74" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum75">
        <el-input v-model="queryParams.data.dayNum75" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum76">
        <el-input v-model="queryParams.data.dayNum76" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum77">
        <el-input v-model="queryParams.data.dayNum77" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum78">
        <el-input v-model="queryParams.data.dayNum78" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum79">
        <el-input v-model="queryParams.data.dayNum79" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum80">
        <el-input v-model="queryParams.data.dayNum80" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum81">
        <el-input v-model="queryParams.data.dayNum81" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum82">
        <el-input v-model="queryParams.data.dayNum82" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum83">
        <el-input v-model="queryParams.data.dayNum83" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum84">
        <el-input v-model="queryParams.data.dayNum84" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum85">
        <el-input v-model="queryParams.data.dayNum85" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum86">
        <el-input v-model="queryParams.data.dayNum86" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum87">
        <el-input v-model="queryParams.data.dayNum87" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum88">
        <el-input v-model="queryParams.data.dayNum88" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum89">
        <el-input v-model="queryParams.data.dayNum89" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum90">
        <el-input v-model="queryParams.data.dayNum90" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum91">
        <el-input v-model="queryParams.data.dayNum91" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum92">
        <el-input v-model="queryParams.data.dayNum92" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum93">
        <el-input v-model="queryParams.data.dayNum93" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum94">
        <el-input v-model="queryParams.data.dayNum94" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum95">
        <el-input v-model="queryParams.data.dayNum95" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum96">
        <el-input v-model="queryParams.data.dayNum96" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum97">
        <el-input v-model="queryParams.data.dayNum97" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum98">
        <el-input v-model="queryParams.data.dayNum98" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum99">
        <el-input v-model="queryParams.data.dayNum99" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum100">
        <el-input v-model="queryParams.data.dayNum100" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum101">
        <el-input v-model="queryParams.data.dayNum101" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum102">
        <el-input v-model="queryParams.data.dayNum102" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum103">
        <el-input v-model="queryParams.data.dayNum103" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum104">
        <el-input v-model="queryParams.data.dayNum104" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum105">
        <el-input v-model="queryParams.data.dayNum105" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum106">
        <el-input v-model="queryParams.data.dayNum106" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum107">
        <el-input v-model="queryParams.data.dayNum107" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum108">
        <el-input v-model="queryParams.data.dayNum108" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum109">
        <el-input v-model="queryParams.data.dayNum109" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum110">
        <el-input v-model="queryParams.data.dayNum110" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum111">
        <el-input v-model="queryParams.data.dayNum111" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum112">
        <el-input v-model="queryParams.data.dayNum112" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum113">
        <el-input v-model="queryParams.data.dayNum113" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum114">
        <el-input v-model="queryParams.data.dayNum114" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum115">
        <el-input v-model="queryParams.data.dayNum115" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum116">
        <el-input v-model="queryParams.data.dayNum116" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum117">
        <el-input v-model="queryParams.data.dayNum117" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum118">
        <el-input v-model="queryParams.data.dayNum118" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum119">
        <el-input v-model="queryParams.data.dayNum119" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum120">
        <el-input v-model="queryParams.data.dayNum120" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum121">
        <el-input v-model="queryParams.data.dayNum121" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum122">
        <el-input v-model="queryParams.data.dayNum122" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum123">
        <el-input v-model="queryParams.data.dayNum123" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum124">
        <el-input v-model="queryParams.data.dayNum124" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum125">
        <el-input v-model="queryParams.data.dayNum125" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum126">
        <el-input v-model="queryParams.data.dayNum126" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum127">
        <el-input v-model="queryParams.data.dayNum127" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum128">
        <el-input v-model="queryParams.data.dayNum128" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum129">
        <el-input v-model="queryParams.data.dayNum129" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum130">
        <el-input v-model="queryParams.data.dayNum130" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum131">
        <el-input v-model="queryParams.data.dayNum131" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum132">
        <el-input v-model="queryParams.data.dayNum132" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum133">
        <el-input v-model="queryParams.data.dayNum133" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum134">
        <el-input v-model="queryParams.data.dayNum134" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum135">
        <el-input v-model="queryParams.data.dayNum135" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum136">
        <el-input v-model="queryParams.data.dayNum136" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum137">
        <el-input v-model="queryParams.data.dayNum137" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum138">
        <el-input v-model="queryParams.data.dayNum138" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum139">
        <el-input v-model="queryParams.data.dayNum139" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum140">
        <el-input v-model="queryParams.data.dayNum140" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum141">
        <el-input v-model="queryParams.data.dayNum141" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum142">
        <el-input v-model="queryParams.data.dayNum142" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum143">
        <el-input v-model="queryParams.data.dayNum143" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum144">
        <el-input v-model="queryParams.data.dayNum144" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum145">
        <el-input v-model="queryParams.data.dayNum145" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum146">
        <el-input v-model="queryParams.data.dayNum146" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum147">
        <el-input v-model="queryParams.data.dayNum147" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum148">
        <el-input v-model="queryParams.data.dayNum148" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum149">
        <el-input v-model="queryParams.data.dayNum149" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum150">
        <el-input v-model="queryParams.data.dayNum150" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum151">
        <el-input v-model="queryParams.data.dayNum151" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum152">
        <el-input v-model="queryParams.data.dayNum152" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum153">
        <el-input v-model="queryParams.data.dayNum153" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum154">
        <el-input v-model="queryParams.data.dayNum154" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum155">
        <el-input v-model="queryParams.data.dayNum155" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum156">
        <el-input v-model="queryParams.data.dayNum156" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum157">
        <el-input v-model="queryParams.data.dayNum157" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum158">
        <el-input v-model="queryParams.data.dayNum158" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum159">
        <el-input v-model="queryParams.data.dayNum159" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum160">
        <el-input v-model="queryParams.data.dayNum160" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum161">
        <el-input v-model="queryParams.data.dayNum161" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum162">
        <el-input v-model="queryParams.data.dayNum162" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum163">
        <el-input v-model="queryParams.data.dayNum163" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum164">
        <el-input v-model="queryParams.data.dayNum164" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum165">
        <el-input v-model="queryParams.data.dayNum165" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum166">
        <el-input v-model="queryParams.data.dayNum166" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum167">
        <el-input v-model="queryParams.data.dayNum167" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum168">
        <el-input v-model="queryParams.data.dayNum168" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum169">
        <el-input v-model="queryParams.data.dayNum169" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum170">
        <el-input v-model="queryParams.data.dayNum170" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum171">
        <el-input v-model="queryParams.data.dayNum171" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum172">
        <el-input v-model="queryParams.data.dayNum172" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum173">
        <el-input v-model="queryParams.data.dayNum173" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum174">
        <el-input v-model="queryParams.data.dayNum174" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum175">
        <el-input v-model="queryParams.data.dayNum175" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum176">
        <el-input v-model="queryParams.data.dayNum176" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum177">
        <el-input v-model="queryParams.data.dayNum177" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum178">
        <el-input v-model="queryParams.data.dayNum178" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum179">
        <el-input v-model="queryParams.data.dayNum179" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum180">
        <el-input v-model="queryParams.data.dayNum180" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum181">
        <el-input v-model="queryParams.data.dayNum181" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum182">
        <el-input v-model="queryParams.data.dayNum182" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum183">
        <el-input v-model="queryParams.data.dayNum183" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum184">
        <el-input v-model="queryParams.data.dayNum184" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum185">
        <el-input v-model="queryParams.data.dayNum185" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum186">
        <el-input v-model="queryParams.data.dayNum186" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum187">
        <el-input v-model="queryParams.data.dayNum187" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum188">
        <el-input v-model="queryParams.data.dayNum188" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum189">
        <el-input v-model="queryParams.data.dayNum189" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum190">
        <el-input v-model="queryParams.data.dayNum190" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum191">
        <el-input v-model="queryParams.data.dayNum191" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum192">
        <el-input v-model="queryParams.data.dayNum192" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum193">
        <el-input v-model="queryParams.data.dayNum193" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum194">
        <el-input v-model="queryParams.data.dayNum194" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum195">
        <el-input v-model="queryParams.data.dayNum195" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum196">
        <el-input v-model="queryParams.data.dayNum196" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum197">
        <el-input v-model="queryParams.data.dayNum197" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum198">
        <el-input v-model="queryParams.data.dayNum198" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum199">
        <el-input v-model="queryParams.data.dayNum199" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum200">
        <el-input v-model="queryParams.data.dayNum200" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum201">
        <el-input v-model="queryParams.data.dayNum201" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum202">
        <el-input v-model="queryParams.data.dayNum202" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum203">
        <el-input v-model="queryParams.data.dayNum203" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum204">
        <el-input v-model="queryParams.data.dayNum204" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum205">
        <el-input v-model="queryParams.data.dayNum205" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum206">
        <el-input v-model="queryParams.data.dayNum206" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum207">
        <el-input v-model="queryParams.data.dayNum207" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum208">
        <el-input v-model="queryParams.data.dayNum208" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum209">
        <el-input v-model="queryParams.data.dayNum209" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum210">
        <el-input v-model="queryParams.data.dayNum210" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum211">
        <el-input v-model="queryParams.data.dayNum211" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum212">
        <el-input v-model="queryParams.data.dayNum212" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum213">
        <el-input v-model="queryParams.data.dayNum213" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum214">
        <el-input v-model="queryParams.data.dayNum214" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum215">
        <el-input v-model="queryParams.data.dayNum215" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum216">
        <el-input v-model="queryParams.data.dayNum216" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum217">
        <el-input v-model="queryParams.data.dayNum217" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum218">
        <el-input v-model="queryParams.data.dayNum218" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum219">
        <el-input v-model="queryParams.data.dayNum219" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum220">
        <el-input v-model="queryParams.data.dayNum220" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum221">
        <el-input v-model="queryParams.data.dayNum221" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum222">
        <el-input v-model="queryParams.data.dayNum222" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum223">
        <el-input v-model="queryParams.data.dayNum223" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum224">
        <el-input v-model="queryParams.data.dayNum224" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum225">
        <el-input v-model="queryParams.data.dayNum225" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum226">
        <el-input v-model="queryParams.data.dayNum226" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum227">
        <el-input v-model="queryParams.data.dayNum227" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum228">
        <el-input v-model="queryParams.data.dayNum228" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum229">
        <el-input v-model="queryParams.data.dayNum229" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum230">
        <el-input v-model="queryParams.data.dayNum230" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum231">
        <el-input v-model="queryParams.data.dayNum231" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum232">
        <el-input v-model="queryParams.data.dayNum232" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum233">
        <el-input v-model="queryParams.data.dayNum233" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum234">
        <el-input v-model="queryParams.data.dayNum234" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum235">
        <el-input v-model="queryParams.data.dayNum235" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum236">
        <el-input v-model="queryParams.data.dayNum236" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum237">
        <el-input v-model="queryParams.data.dayNum237" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum238">
        <el-input v-model="queryParams.data.dayNum238" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum239">
        <el-input v-model="queryParams.data.dayNum239" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum240">
        <el-input v-model="queryParams.data.dayNum240" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum241">
        <el-input v-model="queryParams.data.dayNum241" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum242">
        <el-input v-model="queryParams.data.dayNum242" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum243">
        <el-input v-model="queryParams.data.dayNum243" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum244">
        <el-input v-model="queryParams.data.dayNum244" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum245">
        <el-input v-model="queryParams.data.dayNum245" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum246">
        <el-input v-model="queryParams.data.dayNum246" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum247">
        <el-input v-model="queryParams.data.dayNum247" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum248">
        <el-input v-model="queryParams.data.dayNum248" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum249">
        <el-input v-model="queryParams.data.dayNum249" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum250">
        <el-input v-model="queryParams.data.dayNum250" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum251">
        <el-input v-model="queryParams.data.dayNum251" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum252">
        <el-input v-model="queryParams.data.dayNum252" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum253">
        <el-input v-model="queryParams.data.dayNum253" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum254">
        <el-input v-model="queryParams.data.dayNum254" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum255">
        <el-input v-model="queryParams.data.dayNum255" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum256">
        <el-input v-model="queryParams.data.dayNum256" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum257">
        <el-input v-model="queryParams.data.dayNum257" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum258">
        <el-input v-model="queryParams.data.dayNum258" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum259">
        <el-input v-model="queryParams.data.dayNum259" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum260">
        <el-input v-model="queryParams.data.dayNum260" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum261">
        <el-input v-model="queryParams.data.dayNum261" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum262">
        <el-input v-model="queryParams.data.dayNum262" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum263">
        <el-input v-model="queryParams.data.dayNum263" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum264">
        <el-input v-model="queryParams.data.dayNum264" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum265">
        <el-input v-model="queryParams.data.dayNum265" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum266">
        <el-input v-model="queryParams.data.dayNum266" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum267">
        <el-input v-model="queryParams.data.dayNum267" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum268">
        <el-input v-model="queryParams.data.dayNum268" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum269">
        <el-input v-model="queryParams.data.dayNum269" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum270">
        <el-input v-model="queryParams.data.dayNum270" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum271">
        <el-input v-model="queryParams.data.dayNum271" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum272">
        <el-input v-model="queryParams.data.dayNum272" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum273">
        <el-input v-model="queryParams.data.dayNum273" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum274">
        <el-input v-model="queryParams.data.dayNum274" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum275">
        <el-input v-model="queryParams.data.dayNum275" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum276">
        <el-input v-model="queryParams.data.dayNum276" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum277">
        <el-input v-model="queryParams.data.dayNum277" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum278">
        <el-input v-model="queryParams.data.dayNum278" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum279">
        <el-input v-model="queryParams.data.dayNum279" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum280">
        <el-input v-model="queryParams.data.dayNum280" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum281">
        <el-input v-model="queryParams.data.dayNum281" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum282">
        <el-input v-model="queryParams.data.dayNum282" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum283">
        <el-input v-model="queryParams.data.dayNum283" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum284">
        <el-input v-model="queryParams.data.dayNum284" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum285">
        <el-input v-model="queryParams.data.dayNum285" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum286">
        <el-input v-model="queryParams.data.dayNum286" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum287">
        <el-input v-model="queryParams.data.dayNum287" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum288">
        <el-input v-model="queryParams.data.dayNum288" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum289">
        <el-input v-model="queryParams.data.dayNum289" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum290">
        <el-input v-model="queryParams.data.dayNum290" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum291">
        <el-input v-model="queryParams.data.dayNum291" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum292">
        <el-input v-model="queryParams.data.dayNum292" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum293">
        <el-input v-model="queryParams.data.dayNum293" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum294">
        <el-input v-model="queryParams.data.dayNum294" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum295">
        <el-input v-model="queryParams.data.dayNum295" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum296">
        <el-input v-model="queryParams.data.dayNum296" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum297">
        <el-input v-model="queryParams.data.dayNum297" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum298">
        <el-input v-model="queryParams.data.dayNum298" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum299">
        <el-input v-model="queryParams.data.dayNum299" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum300">
        <el-input v-model="queryParams.data.dayNum300" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum301">
        <el-input v-model="queryParams.data.dayNum301" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum302">
        <el-input v-model="queryParams.data.dayNum302" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum303">
        <el-input v-model="queryParams.data.dayNum303" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum304">
        <el-input v-model="queryParams.data.dayNum304" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum305">
        <el-input v-model="queryParams.data.dayNum305" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum306">
        <el-input v-model="queryParams.data.dayNum306" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum307">
        <el-input v-model="queryParams.data.dayNum307" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum308">
        <el-input v-model="queryParams.data.dayNum308" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum309">
        <el-input v-model="queryParams.data.dayNum309" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum310">
        <el-input v-model="queryParams.data.dayNum310" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum311">
        <el-input v-model="queryParams.data.dayNum311" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum312">
        <el-input v-model="queryParams.data.dayNum312" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum313">
        <el-input v-model="queryParams.data.dayNum313" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum314">
        <el-input v-model="queryParams.data.dayNum314" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum315">
        <el-input v-model="queryParams.data.dayNum315" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum316">
        <el-input v-model="queryParams.data.dayNum316" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum317">
        <el-input v-model="queryParams.data.dayNum317" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum318">
        <el-input v-model="queryParams.data.dayNum318" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum319">
        <el-input v-model="queryParams.data.dayNum319" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum320">
        <el-input v-model="queryParams.data.dayNum320" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum321">
        <el-input v-model="queryParams.data.dayNum321" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum322">
        <el-input v-model="queryParams.data.dayNum322" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum323">
        <el-input v-model="queryParams.data.dayNum323" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum324">
        <el-input v-model="queryParams.data.dayNum324" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum325">
        <el-input v-model="queryParams.data.dayNum325" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum326">
        <el-input v-model="queryParams.data.dayNum326" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum327">
        <el-input v-model="queryParams.data.dayNum327" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum328">
        <el-input v-model="queryParams.data.dayNum328" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum329">
        <el-input v-model="queryParams.data.dayNum329" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum330">
        <el-input v-model="queryParams.data.dayNum330" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum331">
        <el-input v-model="queryParams.data.dayNum331" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum332">
        <el-input v-model="queryParams.data.dayNum332" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum333">
        <el-input v-model="queryParams.data.dayNum333" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum334">
        <el-input v-model="queryParams.data.dayNum334" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum335">
        <el-input v-model="queryParams.data.dayNum335" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum336">
        <el-input v-model="queryParams.data.dayNum336" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum337">
        <el-input v-model="queryParams.data.dayNum337" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum338">
        <el-input v-model="queryParams.data.dayNum338" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum339">
        <el-input v-model="queryParams.data.dayNum339" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum340">
        <el-input v-model="queryParams.data.dayNum340" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum341">
        <el-input v-model="queryParams.data.dayNum341" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum342">
        <el-input v-model="queryParams.data.dayNum342" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum343">
        <el-input v-model="queryParams.data.dayNum343" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum344">
        <el-input v-model="queryParams.data.dayNum344" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum345">
        <el-input v-model="queryParams.data.dayNum345" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum346">
        <el-input v-model="queryParams.data.dayNum346" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum347">
        <el-input v-model="queryParams.data.dayNum347" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum348">
        <el-input v-model="queryParams.data.dayNum348" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum349">
        <el-input v-model="queryParams.data.dayNum349" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum350">
        <el-input v-model="queryParams.data.dayNum350" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum351">
        <el-input v-model="queryParams.data.dayNum351" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum352">
        <el-input v-model="queryParams.data.dayNum352" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum353">
        <el-input v-model="queryParams.data.dayNum353" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum354">
        <el-input v-model="queryParams.data.dayNum354" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum355">
        <el-input v-model="queryParams.data.dayNum355" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum356">
        <el-input v-model="queryParams.data.dayNum356" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum357">
        <el-input v-model="queryParams.data.dayNum357" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum358">
        <el-input v-model="queryParams.data.dayNum358" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum359">
        <el-input v-model="queryParams.data.dayNum359" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum360">
        <el-input v-model="queryParams.data.dayNum360" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum361">
        <el-input v-model="queryParams.data.dayNum361" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum362">
        <el-input v-model="queryParams.data.dayNum362" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum363">
        <el-input v-model="queryParams.data.dayNum363" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum364">
        <el-input v-model="queryParams.data.dayNum364" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum365">
        <el-input v-model="queryParams.data.dayNum365" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="制造数" prop="dayNum366">
        <el-input v-model="queryParams.data.dayNum366" clearable placeholder="请输入制造数"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="工厂ID" prop="factoryId">
        <el-input v-model="queryParams.data.factoryId" clearable placeholder="请输入工厂ID"
                  @keyup.enter.native="handleQuery"/>
      </el-form-item>
      <el-form-item label="${column.comment}" prop="makeSaleConfigId">
        <el-input v-model="queryParams.data.makeSaleConfigId" clearable placeholder="请输入${column.comment}"
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

    <el-table v-loading="loading" :data="apsGoodsForecastMakeProjectDataList" @selection-change="handleSelectionChange">
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

        <el-form-item label="商品ID" prop="goodsId">
          <el-input v-model="form.goodsId" clearable placeholder="请输入商品ID"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="makeMonthId">
          <el-input v-model="form.makeMonthId" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="projectConfigCode">
          <el-input v-model="form.projectConfigCode" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="year">
          <el-input v-model="form.year" clearable placeholder="请输入${column.comment}"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum1">
          <el-input v-model="form.dayNum1" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum2">
          <el-input v-model="form.dayNum2" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum3">
          <el-input v-model="form.dayNum3" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum4">
          <el-input v-model="form.dayNum4" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum5">
          <el-input v-model="form.dayNum5" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum6">
          <el-input v-model="form.dayNum6" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum7">
          <el-input v-model="form.dayNum7" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum8">
          <el-input v-model="form.dayNum8" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum9">
          <el-input v-model="form.dayNum9" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum10">
          <el-input v-model="form.dayNum10" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum11">
          <el-input v-model="form.dayNum11" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum12">
          <el-input v-model="form.dayNum12" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum13">
          <el-input v-model="form.dayNum13" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum14">
          <el-input v-model="form.dayNum14" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum15">
          <el-input v-model="form.dayNum15" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum16">
          <el-input v-model="form.dayNum16" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum17">
          <el-input v-model="form.dayNum17" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum18">
          <el-input v-model="form.dayNum18" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum19">
          <el-input v-model="form.dayNum19" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum20">
          <el-input v-model="form.dayNum20" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum21">
          <el-input v-model="form.dayNum21" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum22">
          <el-input v-model="form.dayNum22" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum23">
          <el-input v-model="form.dayNum23" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum24">
          <el-input v-model="form.dayNum24" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum25">
          <el-input v-model="form.dayNum25" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum26">
          <el-input v-model="form.dayNum26" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum27">
          <el-input v-model="form.dayNum27" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum28">
          <el-input v-model="form.dayNum28" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum29">
          <el-input v-model="form.dayNum29" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum30">
          <el-input v-model="form.dayNum30" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum31">
          <el-input v-model="form.dayNum31" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum32">
          <el-input v-model="form.dayNum32" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum33">
          <el-input v-model="form.dayNum33" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum34">
          <el-input v-model="form.dayNum34" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum35">
          <el-input v-model="form.dayNum35" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum36">
          <el-input v-model="form.dayNum36" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum37">
          <el-input v-model="form.dayNum37" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum38">
          <el-input v-model="form.dayNum38" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum39">
          <el-input v-model="form.dayNum39" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum40">
          <el-input v-model="form.dayNum40" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum41">
          <el-input v-model="form.dayNum41" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum42">
          <el-input v-model="form.dayNum42" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum43">
          <el-input v-model="form.dayNum43" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum44">
          <el-input v-model="form.dayNum44" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum45">
          <el-input v-model="form.dayNum45" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum46">
          <el-input v-model="form.dayNum46" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum47">
          <el-input v-model="form.dayNum47" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum48">
          <el-input v-model="form.dayNum48" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum49">
          <el-input v-model="form.dayNum49" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum50">
          <el-input v-model="form.dayNum50" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum51">
          <el-input v-model="form.dayNum51" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum52">
          <el-input v-model="form.dayNum52" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum53">
          <el-input v-model="form.dayNum53" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum54">
          <el-input v-model="form.dayNum54" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum55">
          <el-input v-model="form.dayNum55" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum56">
          <el-input v-model="form.dayNum56" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum57">
          <el-input v-model="form.dayNum57" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum58">
          <el-input v-model="form.dayNum58" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum59">
          <el-input v-model="form.dayNum59" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum60">
          <el-input v-model="form.dayNum60" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum61">
          <el-input v-model="form.dayNum61" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum62">
          <el-input v-model="form.dayNum62" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum63">
          <el-input v-model="form.dayNum63" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum64">
          <el-input v-model="form.dayNum64" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum65">
          <el-input v-model="form.dayNum65" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum66">
          <el-input v-model="form.dayNum66" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum67">
          <el-input v-model="form.dayNum67" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum68">
          <el-input v-model="form.dayNum68" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum69">
          <el-input v-model="form.dayNum69" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum70">
          <el-input v-model="form.dayNum70" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum71">
          <el-input v-model="form.dayNum71" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum72">
          <el-input v-model="form.dayNum72" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum73">
          <el-input v-model="form.dayNum73" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum74">
          <el-input v-model="form.dayNum74" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum75">
          <el-input v-model="form.dayNum75" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum76">
          <el-input v-model="form.dayNum76" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum77">
          <el-input v-model="form.dayNum77" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum78">
          <el-input v-model="form.dayNum78" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum79">
          <el-input v-model="form.dayNum79" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum80">
          <el-input v-model="form.dayNum80" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum81">
          <el-input v-model="form.dayNum81" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum82">
          <el-input v-model="form.dayNum82" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum83">
          <el-input v-model="form.dayNum83" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum84">
          <el-input v-model="form.dayNum84" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum85">
          <el-input v-model="form.dayNum85" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum86">
          <el-input v-model="form.dayNum86" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum87">
          <el-input v-model="form.dayNum87" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum88">
          <el-input v-model="form.dayNum88" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum89">
          <el-input v-model="form.dayNum89" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum90">
          <el-input v-model="form.dayNum90" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum91">
          <el-input v-model="form.dayNum91" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum92">
          <el-input v-model="form.dayNum92" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum93">
          <el-input v-model="form.dayNum93" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum94">
          <el-input v-model="form.dayNum94" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum95">
          <el-input v-model="form.dayNum95" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum96">
          <el-input v-model="form.dayNum96" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum97">
          <el-input v-model="form.dayNum97" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum98">
          <el-input v-model="form.dayNum98" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum99">
          <el-input v-model="form.dayNum99" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum100">
          <el-input v-model="form.dayNum100" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum101">
          <el-input v-model="form.dayNum101" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum102">
          <el-input v-model="form.dayNum102" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum103">
          <el-input v-model="form.dayNum103" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum104">
          <el-input v-model="form.dayNum104" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum105">
          <el-input v-model="form.dayNum105" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum106">
          <el-input v-model="form.dayNum106" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum107">
          <el-input v-model="form.dayNum107" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum108">
          <el-input v-model="form.dayNum108" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum109">
          <el-input v-model="form.dayNum109" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum110">
          <el-input v-model="form.dayNum110" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum111">
          <el-input v-model="form.dayNum111" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum112">
          <el-input v-model="form.dayNum112" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum113">
          <el-input v-model="form.dayNum113" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum114">
          <el-input v-model="form.dayNum114" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum115">
          <el-input v-model="form.dayNum115" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum116">
          <el-input v-model="form.dayNum116" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum117">
          <el-input v-model="form.dayNum117" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum118">
          <el-input v-model="form.dayNum118" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum119">
          <el-input v-model="form.dayNum119" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum120">
          <el-input v-model="form.dayNum120" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum121">
          <el-input v-model="form.dayNum121" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum122">
          <el-input v-model="form.dayNum122" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum123">
          <el-input v-model="form.dayNum123" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum124">
          <el-input v-model="form.dayNum124" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum125">
          <el-input v-model="form.dayNum125" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum126">
          <el-input v-model="form.dayNum126" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum127">
          <el-input v-model="form.dayNum127" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum128">
          <el-input v-model="form.dayNum128" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum129">
          <el-input v-model="form.dayNum129" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum130">
          <el-input v-model="form.dayNum130" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum131">
          <el-input v-model="form.dayNum131" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum132">
          <el-input v-model="form.dayNum132" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum133">
          <el-input v-model="form.dayNum133" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum134">
          <el-input v-model="form.dayNum134" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum135">
          <el-input v-model="form.dayNum135" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum136">
          <el-input v-model="form.dayNum136" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum137">
          <el-input v-model="form.dayNum137" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum138">
          <el-input v-model="form.dayNum138" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum139">
          <el-input v-model="form.dayNum139" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum140">
          <el-input v-model="form.dayNum140" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum141">
          <el-input v-model="form.dayNum141" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum142">
          <el-input v-model="form.dayNum142" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum143">
          <el-input v-model="form.dayNum143" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum144">
          <el-input v-model="form.dayNum144" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum145">
          <el-input v-model="form.dayNum145" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum146">
          <el-input v-model="form.dayNum146" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum147">
          <el-input v-model="form.dayNum147" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum148">
          <el-input v-model="form.dayNum148" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum149">
          <el-input v-model="form.dayNum149" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum150">
          <el-input v-model="form.dayNum150" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum151">
          <el-input v-model="form.dayNum151" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum152">
          <el-input v-model="form.dayNum152" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum153">
          <el-input v-model="form.dayNum153" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum154">
          <el-input v-model="form.dayNum154" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum155">
          <el-input v-model="form.dayNum155" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum156">
          <el-input v-model="form.dayNum156" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum157">
          <el-input v-model="form.dayNum157" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum158">
          <el-input v-model="form.dayNum158" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum159">
          <el-input v-model="form.dayNum159" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum160">
          <el-input v-model="form.dayNum160" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum161">
          <el-input v-model="form.dayNum161" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum162">
          <el-input v-model="form.dayNum162" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum163">
          <el-input v-model="form.dayNum163" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum164">
          <el-input v-model="form.dayNum164" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum165">
          <el-input v-model="form.dayNum165" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum166">
          <el-input v-model="form.dayNum166" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum167">
          <el-input v-model="form.dayNum167" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum168">
          <el-input v-model="form.dayNum168" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum169">
          <el-input v-model="form.dayNum169" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum170">
          <el-input v-model="form.dayNum170" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum171">
          <el-input v-model="form.dayNum171" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum172">
          <el-input v-model="form.dayNum172" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum173">
          <el-input v-model="form.dayNum173" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum174">
          <el-input v-model="form.dayNum174" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum175">
          <el-input v-model="form.dayNum175" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum176">
          <el-input v-model="form.dayNum176" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum177">
          <el-input v-model="form.dayNum177" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum178">
          <el-input v-model="form.dayNum178" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum179">
          <el-input v-model="form.dayNum179" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum180">
          <el-input v-model="form.dayNum180" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum181">
          <el-input v-model="form.dayNum181" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum182">
          <el-input v-model="form.dayNum182" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum183">
          <el-input v-model="form.dayNum183" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum184">
          <el-input v-model="form.dayNum184" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum185">
          <el-input v-model="form.dayNum185" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum186">
          <el-input v-model="form.dayNum186" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum187">
          <el-input v-model="form.dayNum187" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum188">
          <el-input v-model="form.dayNum188" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum189">
          <el-input v-model="form.dayNum189" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum190">
          <el-input v-model="form.dayNum190" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum191">
          <el-input v-model="form.dayNum191" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum192">
          <el-input v-model="form.dayNum192" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum193">
          <el-input v-model="form.dayNum193" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum194">
          <el-input v-model="form.dayNum194" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum195">
          <el-input v-model="form.dayNum195" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum196">
          <el-input v-model="form.dayNum196" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum197">
          <el-input v-model="form.dayNum197" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum198">
          <el-input v-model="form.dayNum198" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum199">
          <el-input v-model="form.dayNum199" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum200">
          <el-input v-model="form.dayNum200" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum201">
          <el-input v-model="form.dayNum201" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum202">
          <el-input v-model="form.dayNum202" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum203">
          <el-input v-model="form.dayNum203" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum204">
          <el-input v-model="form.dayNum204" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum205">
          <el-input v-model="form.dayNum205" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum206">
          <el-input v-model="form.dayNum206" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum207">
          <el-input v-model="form.dayNum207" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum208">
          <el-input v-model="form.dayNum208" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum209">
          <el-input v-model="form.dayNum209" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum210">
          <el-input v-model="form.dayNum210" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum211">
          <el-input v-model="form.dayNum211" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum212">
          <el-input v-model="form.dayNum212" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum213">
          <el-input v-model="form.dayNum213" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum214">
          <el-input v-model="form.dayNum214" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum215">
          <el-input v-model="form.dayNum215" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum216">
          <el-input v-model="form.dayNum216" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum217">
          <el-input v-model="form.dayNum217" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum218">
          <el-input v-model="form.dayNum218" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum219">
          <el-input v-model="form.dayNum219" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum220">
          <el-input v-model="form.dayNum220" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum221">
          <el-input v-model="form.dayNum221" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum222">
          <el-input v-model="form.dayNum222" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum223">
          <el-input v-model="form.dayNum223" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum224">
          <el-input v-model="form.dayNum224" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum225">
          <el-input v-model="form.dayNum225" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum226">
          <el-input v-model="form.dayNum226" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum227">
          <el-input v-model="form.dayNum227" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum228">
          <el-input v-model="form.dayNum228" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum229">
          <el-input v-model="form.dayNum229" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum230">
          <el-input v-model="form.dayNum230" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum231">
          <el-input v-model="form.dayNum231" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum232">
          <el-input v-model="form.dayNum232" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum233">
          <el-input v-model="form.dayNum233" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum234">
          <el-input v-model="form.dayNum234" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum235">
          <el-input v-model="form.dayNum235" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum236">
          <el-input v-model="form.dayNum236" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum237">
          <el-input v-model="form.dayNum237" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum238">
          <el-input v-model="form.dayNum238" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum239">
          <el-input v-model="form.dayNum239" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum240">
          <el-input v-model="form.dayNum240" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum241">
          <el-input v-model="form.dayNum241" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum242">
          <el-input v-model="form.dayNum242" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum243">
          <el-input v-model="form.dayNum243" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum244">
          <el-input v-model="form.dayNum244" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum245">
          <el-input v-model="form.dayNum245" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum246">
          <el-input v-model="form.dayNum246" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum247">
          <el-input v-model="form.dayNum247" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum248">
          <el-input v-model="form.dayNum248" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum249">
          <el-input v-model="form.dayNum249" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum250">
          <el-input v-model="form.dayNum250" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum251">
          <el-input v-model="form.dayNum251" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum252">
          <el-input v-model="form.dayNum252" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum253">
          <el-input v-model="form.dayNum253" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum254">
          <el-input v-model="form.dayNum254" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum255">
          <el-input v-model="form.dayNum255" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum256">
          <el-input v-model="form.dayNum256" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum257">
          <el-input v-model="form.dayNum257" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum258">
          <el-input v-model="form.dayNum258" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum259">
          <el-input v-model="form.dayNum259" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum260">
          <el-input v-model="form.dayNum260" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum261">
          <el-input v-model="form.dayNum261" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum262">
          <el-input v-model="form.dayNum262" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum263">
          <el-input v-model="form.dayNum263" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum264">
          <el-input v-model="form.dayNum264" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum265">
          <el-input v-model="form.dayNum265" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum266">
          <el-input v-model="form.dayNum266" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum267">
          <el-input v-model="form.dayNum267" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum268">
          <el-input v-model="form.dayNum268" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum269">
          <el-input v-model="form.dayNum269" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum270">
          <el-input v-model="form.dayNum270" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum271">
          <el-input v-model="form.dayNum271" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum272">
          <el-input v-model="form.dayNum272" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum273">
          <el-input v-model="form.dayNum273" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum274">
          <el-input v-model="form.dayNum274" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum275">
          <el-input v-model="form.dayNum275" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum276">
          <el-input v-model="form.dayNum276" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum277">
          <el-input v-model="form.dayNum277" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum278">
          <el-input v-model="form.dayNum278" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum279">
          <el-input v-model="form.dayNum279" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum280">
          <el-input v-model="form.dayNum280" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum281">
          <el-input v-model="form.dayNum281" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum282">
          <el-input v-model="form.dayNum282" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum283">
          <el-input v-model="form.dayNum283" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum284">
          <el-input v-model="form.dayNum284" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum285">
          <el-input v-model="form.dayNum285" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum286">
          <el-input v-model="form.dayNum286" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum287">
          <el-input v-model="form.dayNum287" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum288">
          <el-input v-model="form.dayNum288" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum289">
          <el-input v-model="form.dayNum289" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum290">
          <el-input v-model="form.dayNum290" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum291">
          <el-input v-model="form.dayNum291" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum292">
          <el-input v-model="form.dayNum292" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum293">
          <el-input v-model="form.dayNum293" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum294">
          <el-input v-model="form.dayNum294" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum295">
          <el-input v-model="form.dayNum295" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum296">
          <el-input v-model="form.dayNum296" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum297">
          <el-input v-model="form.dayNum297" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum298">
          <el-input v-model="form.dayNum298" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum299">
          <el-input v-model="form.dayNum299" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum300">
          <el-input v-model="form.dayNum300" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum301">
          <el-input v-model="form.dayNum301" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum302">
          <el-input v-model="form.dayNum302" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum303">
          <el-input v-model="form.dayNum303" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum304">
          <el-input v-model="form.dayNum304" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum305">
          <el-input v-model="form.dayNum305" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum306">
          <el-input v-model="form.dayNum306" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum307">
          <el-input v-model="form.dayNum307" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum308">
          <el-input v-model="form.dayNum308" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum309">
          <el-input v-model="form.dayNum309" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum310">
          <el-input v-model="form.dayNum310" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum311">
          <el-input v-model="form.dayNum311" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum312">
          <el-input v-model="form.dayNum312" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum313">
          <el-input v-model="form.dayNum313" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum314">
          <el-input v-model="form.dayNum314" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum315">
          <el-input v-model="form.dayNum315" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum316">
          <el-input v-model="form.dayNum316" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum317">
          <el-input v-model="form.dayNum317" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum318">
          <el-input v-model="form.dayNum318" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum319">
          <el-input v-model="form.dayNum319" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum320">
          <el-input v-model="form.dayNum320" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum321">
          <el-input v-model="form.dayNum321" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum322">
          <el-input v-model="form.dayNum322" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum323">
          <el-input v-model="form.dayNum323" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum324">
          <el-input v-model="form.dayNum324" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum325">
          <el-input v-model="form.dayNum325" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum326">
          <el-input v-model="form.dayNum326" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum327">
          <el-input v-model="form.dayNum327" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum328">
          <el-input v-model="form.dayNum328" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum329">
          <el-input v-model="form.dayNum329" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum330">
          <el-input v-model="form.dayNum330" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum331">
          <el-input v-model="form.dayNum331" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum332">
          <el-input v-model="form.dayNum332" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum333">
          <el-input v-model="form.dayNum333" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum334">
          <el-input v-model="form.dayNum334" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum335">
          <el-input v-model="form.dayNum335" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum336">
          <el-input v-model="form.dayNum336" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum337">
          <el-input v-model="form.dayNum337" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum338">
          <el-input v-model="form.dayNum338" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum339">
          <el-input v-model="form.dayNum339" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum340">
          <el-input v-model="form.dayNum340" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum341">
          <el-input v-model="form.dayNum341" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum342">
          <el-input v-model="form.dayNum342" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum343">
          <el-input v-model="form.dayNum343" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum344">
          <el-input v-model="form.dayNum344" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum345">
          <el-input v-model="form.dayNum345" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum346">
          <el-input v-model="form.dayNum346" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum347">
          <el-input v-model="form.dayNum347" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum348">
          <el-input v-model="form.dayNum348" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum349">
          <el-input v-model="form.dayNum349" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum350">
          <el-input v-model="form.dayNum350" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum351">
          <el-input v-model="form.dayNum351" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum352">
          <el-input v-model="form.dayNum352" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum353">
          <el-input v-model="form.dayNum353" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum354">
          <el-input v-model="form.dayNum354" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum355">
          <el-input v-model="form.dayNum355" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum356">
          <el-input v-model="form.dayNum356" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum357">
          <el-input v-model="form.dayNum357" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum358">
          <el-input v-model="form.dayNum358" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum359">
          <el-input v-model="form.dayNum359" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum360">
          <el-input v-model="form.dayNum360" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum361">
          <el-input v-model="form.dayNum361" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum362">
          <el-input v-model="form.dayNum362" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum363">
          <el-input v-model="form.dayNum363" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum364">
          <el-input v-model="form.dayNum364" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum365">
          <el-input v-model="form.dayNum365" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="制造数" prop="dayNum366">
          <el-input v-model="form.dayNum366" clearable placeholder="请输入制造数"/>
        </el-form-item>
        <el-form-item label="工厂ID" prop="factoryId">
          <el-input v-model="form.factoryId" clearable placeholder="请输入工厂ID"/>
        </el-form-item>
        <el-form-item label="${column.comment}" prop="makeSaleConfigId">
          <el-input v-model="form.makeSaleConfigId" clearable placeholder="请输入${column.comment}"/>
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
      apsGoodsForecastMakeProjectDataList: [],
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
        goodsId: undefined,
        makeMonthId: undefined,
        projectConfigCode: undefined,
        year: undefined,
        dayNum1: undefined,
        dayNum2: undefined,
        dayNum3: undefined,
        dayNum4: undefined,
        dayNum5: undefined,
        dayNum6: undefined,
        dayNum7: undefined,
        dayNum8: undefined,
        dayNum9: undefined,
        dayNum10: undefined,
        dayNum11: undefined,
        dayNum12: undefined,
        dayNum13: undefined,
        dayNum14: undefined,
        dayNum15: undefined,
        dayNum16: undefined,
        dayNum17: undefined,
        dayNum18: undefined,
        dayNum19: undefined,
        dayNum20: undefined,
        dayNum21: undefined,
        dayNum22: undefined,
        dayNum23: undefined,
        dayNum24: undefined,
        dayNum25: undefined,
        dayNum26: undefined,
        dayNum27: undefined,
        dayNum28: undefined,
        dayNum29: undefined,
        dayNum30: undefined,
        dayNum31: undefined,
        dayNum32: undefined,
        dayNum33: undefined,
        dayNum34: undefined,
        dayNum35: undefined,
        dayNum36: undefined,
        dayNum37: undefined,
        dayNum38: undefined,
        dayNum39: undefined,
        dayNum40: undefined,
        dayNum41: undefined,
        dayNum42: undefined,
        dayNum43: undefined,
        dayNum44: undefined,
        dayNum45: undefined,
        dayNum46: undefined,
        dayNum47: undefined,
        dayNum48: undefined,
        dayNum49: undefined,
        dayNum50: undefined,
        dayNum51: undefined,
        dayNum52: undefined,
        dayNum53: undefined,
        dayNum54: undefined,
        dayNum55: undefined,
        dayNum56: undefined,
        dayNum57: undefined,
        dayNum58: undefined,
        dayNum59: undefined,
        dayNum60: undefined,
        dayNum61: undefined,
        dayNum62: undefined,
        dayNum63: undefined,
        dayNum64: undefined,
        dayNum65: undefined,
        dayNum66: undefined,
        dayNum67: undefined,
        dayNum68: undefined,
        dayNum69: undefined,
        dayNum70: undefined,
        dayNum71: undefined,
        dayNum72: undefined,
        dayNum73: undefined,
        dayNum74: undefined,
        dayNum75: undefined,
        dayNum76: undefined,
        dayNum77: undefined,
        dayNum78: undefined,
        dayNum79: undefined,
        dayNum80: undefined,
        dayNum81: undefined,
        dayNum82: undefined,
        dayNum83: undefined,
        dayNum84: undefined,
        dayNum85: undefined,
        dayNum86: undefined,
        dayNum87: undefined,
        dayNum88: undefined,
        dayNum89: undefined,
        dayNum90: undefined,
        dayNum91: undefined,
        dayNum92: undefined,
        dayNum93: undefined,
        dayNum94: undefined,
        dayNum95: undefined,
        dayNum96: undefined,
        dayNum97: undefined,
        dayNum98: undefined,
        dayNum99: undefined,
        dayNum100: undefined,
        dayNum101: undefined,
        dayNum102: undefined,
        dayNum103: undefined,
        dayNum104: undefined,
        dayNum105: undefined,
        dayNum106: undefined,
        dayNum107: undefined,
        dayNum108: undefined,
        dayNum109: undefined,
        dayNum110: undefined,
        dayNum111: undefined,
        dayNum112: undefined,
        dayNum113: undefined,
        dayNum114: undefined,
        dayNum115: undefined,
        dayNum116: undefined,
        dayNum117: undefined,
        dayNum118: undefined,
        dayNum119: undefined,
        dayNum120: undefined,
        dayNum121: undefined,
        dayNum122: undefined,
        dayNum123: undefined,
        dayNum124: undefined,
        dayNum125: undefined,
        dayNum126: undefined,
        dayNum127: undefined,
        dayNum128: undefined,
        dayNum129: undefined,
        dayNum130: undefined,
        dayNum131: undefined,
        dayNum132: undefined,
        dayNum133: undefined,
        dayNum134: undefined,
        dayNum135: undefined,
        dayNum136: undefined,
        dayNum137: undefined,
        dayNum138: undefined,
        dayNum139: undefined,
        dayNum140: undefined,
        dayNum141: undefined,
        dayNum142: undefined,
        dayNum143: undefined,
        dayNum144: undefined,
        dayNum145: undefined,
        dayNum146: undefined,
        dayNum147: undefined,
        dayNum148: undefined,
        dayNum149: undefined,
        dayNum150: undefined,
        dayNum151: undefined,
        dayNum152: undefined,
        dayNum153: undefined,
        dayNum154: undefined,
        dayNum155: undefined,
        dayNum156: undefined,
        dayNum157: undefined,
        dayNum158: undefined,
        dayNum159: undefined,
        dayNum160: undefined,
        dayNum161: undefined,
        dayNum162: undefined,
        dayNum163: undefined,
        dayNum164: undefined,
        dayNum165: undefined,
        dayNum166: undefined,
        dayNum167: undefined,
        dayNum168: undefined,
        dayNum169: undefined,
        dayNum170: undefined,
        dayNum171: undefined,
        dayNum172: undefined,
        dayNum173: undefined,
        dayNum174: undefined,
        dayNum175: undefined,
        dayNum176: undefined,
        dayNum177: undefined,
        dayNum178: undefined,
        dayNum179: undefined,
        dayNum180: undefined,
        dayNum181: undefined,
        dayNum182: undefined,
        dayNum183: undefined,
        dayNum184: undefined,
        dayNum185: undefined,
        dayNum186: undefined,
        dayNum187: undefined,
        dayNum188: undefined,
        dayNum189: undefined,
        dayNum190: undefined,
        dayNum191: undefined,
        dayNum192: undefined,
        dayNum193: undefined,
        dayNum194: undefined,
        dayNum195: undefined,
        dayNum196: undefined,
        dayNum197: undefined,
        dayNum198: undefined,
        dayNum199: undefined,
        dayNum200: undefined,
        dayNum201: undefined,
        dayNum202: undefined,
        dayNum203: undefined,
        dayNum204: undefined,
        dayNum205: undefined,
        dayNum206: undefined,
        dayNum207: undefined,
        dayNum208: undefined,
        dayNum209: undefined,
        dayNum210: undefined,
        dayNum211: undefined,
        dayNum212: undefined,
        dayNum213: undefined,
        dayNum214: undefined,
        dayNum215: undefined,
        dayNum216: undefined,
        dayNum217: undefined,
        dayNum218: undefined,
        dayNum219: undefined,
        dayNum220: undefined,
        dayNum221: undefined,
        dayNum222: undefined,
        dayNum223: undefined,
        dayNum224: undefined,
        dayNum225: undefined,
        dayNum226: undefined,
        dayNum227: undefined,
        dayNum228: undefined,
        dayNum229: undefined,
        dayNum230: undefined,
        dayNum231: undefined,
        dayNum232: undefined,
        dayNum233: undefined,
        dayNum234: undefined,
        dayNum235: undefined,
        dayNum236: undefined,
        dayNum237: undefined,
        dayNum238: undefined,
        dayNum239: undefined,
        dayNum240: undefined,
        dayNum241: undefined,
        dayNum242: undefined,
        dayNum243: undefined,
        dayNum244: undefined,
        dayNum245: undefined,
        dayNum246: undefined,
        dayNum247: undefined,
        dayNum248: undefined,
        dayNum249: undefined,
        dayNum250: undefined,
        dayNum251: undefined,
        dayNum252: undefined,
        dayNum253: undefined,
        dayNum254: undefined,
        dayNum255: undefined,
        dayNum256: undefined,
        dayNum257: undefined,
        dayNum258: undefined,
        dayNum259: undefined,
        dayNum260: undefined,
        dayNum261: undefined,
        dayNum262: undefined,
        dayNum263: undefined,
        dayNum264: undefined,
        dayNum265: undefined,
        dayNum266: undefined,
        dayNum267: undefined,
        dayNum268: undefined,
        dayNum269: undefined,
        dayNum270: undefined,
        dayNum271: undefined,
        dayNum272: undefined,
        dayNum273: undefined,
        dayNum274: undefined,
        dayNum275: undefined,
        dayNum276: undefined,
        dayNum277: undefined,
        dayNum278: undefined,
        dayNum279: undefined,
        dayNum280: undefined,
        dayNum281: undefined,
        dayNum282: undefined,
        dayNum283: undefined,
        dayNum284: undefined,
        dayNum285: undefined,
        dayNum286: undefined,
        dayNum287: undefined,
        dayNum288: undefined,
        dayNum289: undefined,
        dayNum290: undefined,
        dayNum291: undefined,
        dayNum292: undefined,
        dayNum293: undefined,
        dayNum294: undefined,
        dayNum295: undefined,
        dayNum296: undefined,
        dayNum297: undefined,
        dayNum298: undefined,
        dayNum299: undefined,
        dayNum300: undefined,
        dayNum301: undefined,
        dayNum302: undefined,
        dayNum303: undefined,
        dayNum304: undefined,
        dayNum305: undefined,
        dayNum306: undefined,
        dayNum307: undefined,
        dayNum308: undefined,
        dayNum309: undefined,
        dayNum310: undefined,
        dayNum311: undefined,
        dayNum312: undefined,
        dayNum313: undefined,
        dayNum314: undefined,
        dayNum315: undefined,
        dayNum316: undefined,
        dayNum317: undefined,
        dayNum318: undefined,
        dayNum319: undefined,
        dayNum320: undefined,
        dayNum321: undefined,
        dayNum322: undefined,
        dayNum323: undefined,
        dayNum324: undefined,
        dayNum325: undefined,
        dayNum326: undefined,
        dayNum327: undefined,
        dayNum328: undefined,
        dayNum329: undefined,
        dayNum330: undefined,
        dayNum331: undefined,
        dayNum332: undefined,
        dayNum333: undefined,
        dayNum334: undefined,
        dayNum335: undefined,
        dayNum336: undefined,
        dayNum337: undefined,
        dayNum338: undefined,
        dayNum339: undefined,
        dayNum340: undefined,
        dayNum341: undefined,
        dayNum342: undefined,
        dayNum343: undefined,
        dayNum344: undefined,
        dayNum345: undefined,
        dayNum346: undefined,
        dayNum347: undefined,
        dayNum348: undefined,
        dayNum349: undefined,
        dayNum350: undefined,
        dayNum351: undefined,
        dayNum352: undefined,
        dayNum353: undefined,
        dayNum354: undefined,
        dayNum355: undefined,
        dayNum356: undefined,
        dayNum357: undefined,
        dayNum358: undefined,
        dayNum359: undefined,
        dayNum360: undefined,
        dayNum361: undefined,
        dayNum362: undefined,
        dayNum363: undefined,
        dayNum364: undefined,
        dayNum365: undefined,
        dayNum366: undefined,
        factoryId: undefined,
        makeSaleConfigId: undefined,
        id: undefined
      },
      // 表单校验
      rules: {
        goodsId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        makeMonthId: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        projectConfigCode: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        dayNum1: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum2: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum3: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum4: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum5: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum6: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum7: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum8: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum9: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum10: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum11: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum12: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum13: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum14: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum15: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum16: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum17: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum18: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum19: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum20: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum21: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum22: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum23: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum24: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum25: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum26: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum27: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum28: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum29: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum30: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum31: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum32: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum33: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum34: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum35: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum36: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum37: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum38: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum39: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum40: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum41: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum42: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum43: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum44: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum45: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum46: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum47: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum48: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum49: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum50: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum51: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum52: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum53: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum54: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum55: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum56: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum57: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum58: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum59: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum60: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum61: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum62: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum63: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum64: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum65: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum66: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum67: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum68: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum69: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum70: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum71: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum72: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum73: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum74: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum75: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum76: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum77: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum78: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum79: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum80: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum81: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum82: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum83: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum84: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum85: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum86: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum87: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum88: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum89: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum90: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum91: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum92: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum93: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum94: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum95: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum96: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum97: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum98: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum99: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum100: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum101: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum102: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum103: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum104: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum105: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum106: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum107: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum108: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum109: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum110: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum111: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum112: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum113: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum114: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum115: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum116: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum117: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum118: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum119: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum120: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum121: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum122: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum123: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum124: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum125: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum126: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum127: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum128: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum129: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum130: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum131: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum132: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum133: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum134: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum135: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum136: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum137: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum138: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum139: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum140: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum141: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum142: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum143: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum144: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum145: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum146: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum147: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum148: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum149: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum150: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum151: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum152: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum153: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum154: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum155: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum156: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum157: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum158: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum159: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum160: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum161: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum162: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum163: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum164: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum165: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum166: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum167: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum168: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum169: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum170: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum171: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum172: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum173: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum174: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum175: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum176: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum177: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum178: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum179: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum180: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum181: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum182: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum183: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum184: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum185: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum186: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum187: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum188: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum189: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum190: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum191: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum192: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum193: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum194: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum195: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum196: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum197: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum198: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum199: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum200: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum201: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum202: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum203: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum204: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum205: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum206: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum207: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum208: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum209: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum210: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum211: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum212: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum213: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum214: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum215: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum216: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum217: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum218: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum219: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum220: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum221: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum222: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum223: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum224: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum225: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum226: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum227: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum228: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum229: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum230: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum231: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum232: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum233: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum234: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum235: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum236: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum237: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum238: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum239: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum240: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum241: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum242: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum243: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum244: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum245: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum246: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum247: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum248: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum249: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum250: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum251: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum252: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum253: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum254: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum255: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum256: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum257: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum258: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum259: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum260: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum261: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum262: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum263: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum264: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum265: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum266: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum267: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum268: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum269: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum270: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum271: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum272: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum273: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum274: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum275: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum276: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum277: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum278: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum279: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum280: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum281: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum282: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum283: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum284: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum285: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum286: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum287: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum288: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum289: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum290: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum291: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum292: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum293: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum294: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum295: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum296: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum297: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum298: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum299: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum300: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum301: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum302: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum303: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum304: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum305: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum306: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum307: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum308: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum309: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum310: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum311: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum312: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum313: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum314: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum315: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum316: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum317: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum318: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum319: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum320: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum321: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum322: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum323: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum324: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum325: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum326: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum327: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum328: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum329: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum330: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum331: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum332: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum333: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum334: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum335: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum336: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum337: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum338: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum339: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum340: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum341: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum342: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum343: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum344: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum345: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum346: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum347: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum348: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum349: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum350: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum351: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum352: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum353: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum354: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum355: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum356: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum357: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum358: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum359: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum360: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum361: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum362: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum363: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum364: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum365: [{required: true, message: "不能为空", trigger: "blur"}, {
          min: 5,
          max: 20,
          message: '长度在 5 到 20 个字符',
          trigger: 'blur'
        }],
        dayNum366: [{required: true, message: "不能为空", trigger: "blur"}, {
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
        makeSaleConfigId: [{required: true, message: "不能为空", trigger: "blur"}, {
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
    document['pagePath'] = '/apsGoodsForecastMakeProjectData'
    this.getList()
  },
  methods: {
    /** 查询公告列表 */
    getList() {
      this.loading = true
      queryPageList(this.queryParams).then(response => {
        response = response.data
        this.tableHeaderList = response.headerList
        this.apsGoodsForecastMakeProjectDataList = response.dataList
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
        goodsId: undefined,
        makeMonthId: undefined,
        projectConfigCode: undefined,
        year: undefined,
        dayNum1: undefined,
        dayNum2: undefined,
        dayNum3: undefined,
        dayNum4: undefined,
        dayNum5: undefined,
        dayNum6: undefined,
        dayNum7: undefined,
        dayNum8: undefined,
        dayNum9: undefined,
        dayNum10: undefined,
        dayNum11: undefined,
        dayNum12: undefined,
        dayNum13: undefined,
        dayNum14: undefined,
        dayNum15: undefined,
        dayNum16: undefined,
        dayNum17: undefined,
        dayNum18: undefined,
        dayNum19: undefined,
        dayNum20: undefined,
        dayNum21: undefined,
        dayNum22: undefined,
        dayNum23: undefined,
        dayNum24: undefined,
        dayNum25: undefined,
        dayNum26: undefined,
        dayNum27: undefined,
        dayNum28: undefined,
        dayNum29: undefined,
        dayNum30: undefined,
        dayNum31: undefined,
        dayNum32: undefined,
        dayNum33: undefined,
        dayNum34: undefined,
        dayNum35: undefined,
        dayNum36: undefined,
        dayNum37: undefined,
        dayNum38: undefined,
        dayNum39: undefined,
        dayNum40: undefined,
        dayNum41: undefined,
        dayNum42: undefined,
        dayNum43: undefined,
        dayNum44: undefined,
        dayNum45: undefined,
        dayNum46: undefined,
        dayNum47: undefined,
        dayNum48: undefined,
        dayNum49: undefined,
        dayNum50: undefined,
        dayNum51: undefined,
        dayNum52: undefined,
        dayNum53: undefined,
        dayNum54: undefined,
        dayNum55: undefined,
        dayNum56: undefined,
        dayNum57: undefined,
        dayNum58: undefined,
        dayNum59: undefined,
        dayNum60: undefined,
        dayNum61: undefined,
        dayNum62: undefined,
        dayNum63: undefined,
        dayNum64: undefined,
        dayNum65: undefined,
        dayNum66: undefined,
        dayNum67: undefined,
        dayNum68: undefined,
        dayNum69: undefined,
        dayNum70: undefined,
        dayNum71: undefined,
        dayNum72: undefined,
        dayNum73: undefined,
        dayNum74: undefined,
        dayNum75: undefined,
        dayNum76: undefined,
        dayNum77: undefined,
        dayNum78: undefined,
        dayNum79: undefined,
        dayNum80: undefined,
        dayNum81: undefined,
        dayNum82: undefined,
        dayNum83: undefined,
        dayNum84: undefined,
        dayNum85: undefined,
        dayNum86: undefined,
        dayNum87: undefined,
        dayNum88: undefined,
        dayNum89: undefined,
        dayNum90: undefined,
        dayNum91: undefined,
        dayNum92: undefined,
        dayNum93: undefined,
        dayNum94: undefined,
        dayNum95: undefined,
        dayNum96: undefined,
        dayNum97: undefined,
        dayNum98: undefined,
        dayNum99: undefined,
        dayNum100: undefined,
        dayNum101: undefined,
        dayNum102: undefined,
        dayNum103: undefined,
        dayNum104: undefined,
        dayNum105: undefined,
        dayNum106: undefined,
        dayNum107: undefined,
        dayNum108: undefined,
        dayNum109: undefined,
        dayNum110: undefined,
        dayNum111: undefined,
        dayNum112: undefined,
        dayNum113: undefined,
        dayNum114: undefined,
        dayNum115: undefined,
        dayNum116: undefined,
        dayNum117: undefined,
        dayNum118: undefined,
        dayNum119: undefined,
        dayNum120: undefined,
        dayNum121: undefined,
        dayNum122: undefined,
        dayNum123: undefined,
        dayNum124: undefined,
        dayNum125: undefined,
        dayNum126: undefined,
        dayNum127: undefined,
        dayNum128: undefined,
        dayNum129: undefined,
        dayNum130: undefined,
        dayNum131: undefined,
        dayNum132: undefined,
        dayNum133: undefined,
        dayNum134: undefined,
        dayNum135: undefined,
        dayNum136: undefined,
        dayNum137: undefined,
        dayNum138: undefined,
        dayNum139: undefined,
        dayNum140: undefined,
        dayNum141: undefined,
        dayNum142: undefined,
        dayNum143: undefined,
        dayNum144: undefined,
        dayNum145: undefined,
        dayNum146: undefined,
        dayNum147: undefined,
        dayNum148: undefined,
        dayNum149: undefined,
        dayNum150: undefined,
        dayNum151: undefined,
        dayNum152: undefined,
        dayNum153: undefined,
        dayNum154: undefined,
        dayNum155: undefined,
        dayNum156: undefined,
        dayNum157: undefined,
        dayNum158: undefined,
        dayNum159: undefined,
        dayNum160: undefined,
        dayNum161: undefined,
        dayNum162: undefined,
        dayNum163: undefined,
        dayNum164: undefined,
        dayNum165: undefined,
        dayNum166: undefined,
        dayNum167: undefined,
        dayNum168: undefined,
        dayNum169: undefined,
        dayNum170: undefined,
        dayNum171: undefined,
        dayNum172: undefined,
        dayNum173: undefined,
        dayNum174: undefined,
        dayNum175: undefined,
        dayNum176: undefined,
        dayNum177: undefined,
        dayNum178: undefined,
        dayNum179: undefined,
        dayNum180: undefined,
        dayNum181: undefined,
        dayNum182: undefined,
        dayNum183: undefined,
        dayNum184: undefined,
        dayNum185: undefined,
        dayNum186: undefined,
        dayNum187: undefined,
        dayNum188: undefined,
        dayNum189: undefined,
        dayNum190: undefined,
        dayNum191: undefined,
        dayNum192: undefined,
        dayNum193: undefined,
        dayNum194: undefined,
        dayNum195: undefined,
        dayNum196: undefined,
        dayNum197: undefined,
        dayNum198: undefined,
        dayNum199: undefined,
        dayNum200: undefined,
        dayNum201: undefined,
        dayNum202: undefined,
        dayNum203: undefined,
        dayNum204: undefined,
        dayNum205: undefined,
        dayNum206: undefined,
        dayNum207: undefined,
        dayNum208: undefined,
        dayNum209: undefined,
        dayNum210: undefined,
        dayNum211: undefined,
        dayNum212: undefined,
        dayNum213: undefined,
        dayNum214: undefined,
        dayNum215: undefined,
        dayNum216: undefined,
        dayNum217: undefined,
        dayNum218: undefined,
        dayNum219: undefined,
        dayNum220: undefined,
        dayNum221: undefined,
        dayNum222: undefined,
        dayNum223: undefined,
        dayNum224: undefined,
        dayNum225: undefined,
        dayNum226: undefined,
        dayNum227: undefined,
        dayNum228: undefined,
        dayNum229: undefined,
        dayNum230: undefined,
        dayNum231: undefined,
        dayNum232: undefined,
        dayNum233: undefined,
        dayNum234: undefined,
        dayNum235: undefined,
        dayNum236: undefined,
        dayNum237: undefined,
        dayNum238: undefined,
        dayNum239: undefined,
        dayNum240: undefined,
        dayNum241: undefined,
        dayNum242: undefined,
        dayNum243: undefined,
        dayNum244: undefined,
        dayNum245: undefined,
        dayNum246: undefined,
        dayNum247: undefined,
        dayNum248: undefined,
        dayNum249: undefined,
        dayNum250: undefined,
        dayNum251: undefined,
        dayNum252: undefined,
        dayNum253: undefined,
        dayNum254: undefined,
        dayNum255: undefined,
        dayNum256: undefined,
        dayNum257: undefined,
        dayNum258: undefined,
        dayNum259: undefined,
        dayNum260: undefined,
        dayNum261: undefined,
        dayNum262: undefined,
        dayNum263: undefined,
        dayNum264: undefined,
        dayNum265: undefined,
        dayNum266: undefined,
        dayNum267: undefined,
        dayNum268: undefined,
        dayNum269: undefined,
        dayNum270: undefined,
        dayNum271: undefined,
        dayNum272: undefined,
        dayNum273: undefined,
        dayNum274: undefined,
        dayNum275: undefined,
        dayNum276: undefined,
        dayNum277: undefined,
        dayNum278: undefined,
        dayNum279: undefined,
        dayNum280: undefined,
        dayNum281: undefined,
        dayNum282: undefined,
        dayNum283: undefined,
        dayNum284: undefined,
        dayNum285: undefined,
        dayNum286: undefined,
        dayNum287: undefined,
        dayNum288: undefined,
        dayNum289: undefined,
        dayNum290: undefined,
        dayNum291: undefined,
        dayNum292: undefined,
        dayNum293: undefined,
        dayNum294: undefined,
        dayNum295: undefined,
        dayNum296: undefined,
        dayNum297: undefined,
        dayNum298: undefined,
        dayNum299: undefined,
        dayNum300: undefined,
        dayNum301: undefined,
        dayNum302: undefined,
        dayNum303: undefined,
        dayNum304: undefined,
        dayNum305: undefined,
        dayNum306: undefined,
        dayNum307: undefined,
        dayNum308: undefined,
        dayNum309: undefined,
        dayNum310: undefined,
        dayNum311: undefined,
        dayNum312: undefined,
        dayNum313: undefined,
        dayNum314: undefined,
        dayNum315: undefined,
        dayNum316: undefined,
        dayNum317: undefined,
        dayNum318: undefined,
        dayNum319: undefined,
        dayNum320: undefined,
        dayNum321: undefined,
        dayNum322: undefined,
        dayNum323: undefined,
        dayNum324: undefined,
        dayNum325: undefined,
        dayNum326: undefined,
        dayNum327: undefined,
        dayNum328: undefined,
        dayNum329: undefined,
        dayNum330: undefined,
        dayNum331: undefined,
        dayNum332: undefined,
        dayNum333: undefined,
        dayNum334: undefined,
        dayNum335: undefined,
        dayNum336: undefined,
        dayNum337: undefined,
        dayNum338: undefined,
        dayNum339: undefined,
        dayNum340: undefined,
        dayNum341: undefined,
        dayNum342: undefined,
        dayNum343: undefined,
        dayNum344: undefined,
        dayNum345: undefined,
        dayNum346: undefined,
        dayNum347: undefined,
        dayNum348: undefined,
        dayNum349: undefined,
        dayNum350: undefined,
        dayNum351: undefined,
        dayNum352: undefined,
        dayNum353: undefined,
        dayNum354: undefined,
        dayNum355: undefined,
        dayNum356: undefined,
        dayNum357: undefined,
        dayNum358: undefined,
        dayNum359: undefined,
        dayNum360: undefined,
        dayNum361: undefined,
        dayNum362: undefined,
        dayNum363: undefined,
        dayNum364: undefined,
        dayNum365: undefined,
        dayNum366: undefined,
        factoryId: undefined,
        makeSaleConfigId: undefined,
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
      this.title = '添加预测数据'
      this.open = true
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      let req = {idList: [row.id], pageSize: 1, pageNum: 1}
      getById(req).then(response => {
        this.form = response.data.dataList[0]
        this.title = '修改预测数据'
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

