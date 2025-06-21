package com.olivia.peanut.aps.service.impl.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.olivia.peanut.aps.model.ApsGoods;
import com.olivia.peanut.aps.model.ApsGoodsForecast;
import com.olivia.peanut.aps.model.ApsGoodsSaleItem;
import com.olivia.peanut.aps.model.ApsSaleConfig;
import com.olivia.peanut.aps.service.ApsGoodsForecastService;
import com.olivia.peanut.aps.service.ApsGoodsSaleItemService;
import com.olivia.peanut.aps.service.ApsGoodsService;
import com.olivia.peanut.aps.service.ApsSaleConfigService;
import com.olivia.sdk.utils.$;
import com.olivia.sdk.utils.BaseEntity;
import com.olivia.sdk.utils.ListUtils;
import com.olivia.sdk.utils.PoiExcelUtil;
import com.olivia.sdk.utils.PoiExcelUtil.CellStyleEnum;
import com.olivia.sdk.utils.ReqResUtils;
import com.olivia.sdk.utils.ValueUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.jetbrains.annotations.NotNull;

@Slf4j
public class ApsGoodsForecastUtils {

  @SneakyThrows
  public static void downloadTemplate(Long id) {
    ApsGoodsForecastService apsGoodsForecastService = SpringUtil.getBean(
        ApsGoodsForecastService.class);
    ApsGoodsForecast goodsForecast = apsGoodsForecastService.getById(id);
    $.requireNonNullCanIgnoreException(goodsForecast, "未找到数据");

    HttpServletResponse response = ReqResUtils.getResponse();
    @Cleanup SXSSFWorkbook workbook = new SXSSFWorkbook();
    ApsGoodsService goodsService = SpringUtil.getBean(ApsGoodsService.class);

    ApsGoodsSaleItemService goodsSaleItemService = SpringUtil.getBean(
        ApsGoodsSaleItemService.class);
    @Cleanup ServletOutputStream outputStream = response.getOutputStream();
    workbook.setCompressTempFiles(true);
    Map<CellStyleEnum, CellStyle> styleMap = PoiExcelUtil.createStyles(workbook);
    CellStyle headerCellStyle = styleMap.get(CellStyleEnum.HEADER);
    CellStyle bodyCellStyle = styleMap.get(CellStyleEnum.BODY);
    ApsGoods apsGoods = goodsService.getById(goodsForecast.getGoodsId());

    CreateSaleConfigSheet result = getCreateSaleConfigSheet(workbook, apsGoods, headerCellStyle,
        goodsForecast, goodsSaleItemService);

    if (CollUtil.isNotEmpty(goodsForecast.getSaleConfigList())) {
      createGroupSheet(result.apsGoodsSaleItemList(), goodsForecast, workbook, apsGoods,
          headerCellStyle, result.style, result.monthList());
    }

    setColumnWidth(workbook);

    response.reset();
    response.setContentType("application/ms-excel;charset=UTF-8");
    response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(
        URLEncoder.encode(goodsForecast.getForecastName() + ".xls", StandardCharsets.UTF_8))));
    workbook.write(outputStream);

  }

  @NotNull
  private static CreateSaleConfigSheet getCreateSaleConfigSheet(SXSSFWorkbook workbook,
      ApsGoods apsGoods, CellStyle headerCellStyle, ApsGoodsForecast goodsForecast,
      ApsGoodsSaleItemService goodsSaleItemService) {
    SXSSFSheet sheet = workbook.createSheet(apsGoods.getGoodsName());
    SXSSFRow row = sheet.createRow(0);
    CellStyle style = workbook.createCellStyle();
    SXSSFCell goodsNameCell = row.createCell(1);
    goodsNameCell.setCellValue(apsGoods.getGoodsName());
    style.setAlignment(HorizontalAlignment.CENTER);
    style.setVerticalAlignment(VerticalAlignment.CENTER);
    goodsNameCell.setCellStyle(style);
    SXSSFCell cell = row.createCell(3);
    cell.setCellStyle(headerCellStyle);
    cell.setCellValue("月份");
    List<String> monthList = goodsForecast.getMonthList();
    $.requireNonNullCanIgnoreException(monthList, "月份为空");
    for (int i = 0; i < monthList.size(); i++) {
      cell = row.createCell(i + 4);
      cell.setCellStyle(headerCellStyle);
      cell.setCellValue("'" + monthList.get(i));
    }
    ApsSaleConfigService apsSaleConfigService = SpringUtil.getBean(ApsSaleConfigService.class);
    Map<Long, ApsSaleConfig> saleConfigMap = apsSaleConfigService.list().stream()
        .collect(Collectors.toMap(BaseEntity::getId, Function.identity()));
    List<ApsGoodsSaleItem> apsGoodsSaleItemList = goodsSaleItemService.list(
        new LambdaQueryWrapper<ApsGoodsSaleItem>().eq(ApsGoodsSaleItem::getGoodsId,
            apsGoods.getId()));

    apsGoodsSaleItemList.forEach(item -> {
      item.setCurrentSaleConfig(
          saleConfigMap.getOrDefault(item.getSaleConfigId(), new ApsSaleConfig()));
      item.setParentSaleConfig(saleConfigMap.getOrDefault(item.getCurrentSaleConfig().getParentId(),
          new ApsSaleConfig()));
    });
    apsGoodsSaleItemList.removeIf(t -> !Objects.equals(t.getCurrentSaleConfig().getIsValue(), 1));
    apsGoodsSaleItemList.sort(Comparator.comparing(t -> t.getCurrentSaleConfig().getSaleCode()));
    SXSSFRow nameRow = sheet.createRow(1);
    SXSSFCell ct1 = nameRow.createCell(1);
    ct1.setCellValue("销售特征组");
    ct1.setCellStyle(headerCellStyle);
    SXSSFCell ct2 = nameRow.createCell(2);
    ct2.setCellValue("销售特征");
    ct2.setCellStyle(headerCellStyle);
    SXSSFCell cc = nameRow.createCell(3);
    cc.setCellValue("总计");
    cc.setCellStyle(headerCellStyle);
    IntStream.range(0, apsGoodsSaleItemList.size()).forEach(i -> {
      SXSSFRow rowTmp = sheet.createRow(i + 2);
      ApsGoodsSaleItem apsGoodsSaleItem = apsGoodsSaleItemList.get(i);
      rowTmp.createCell(0).setCellValue(ValueUtils.value2Str(apsGoodsSaleItem.getSaleConfigId()));
      rowTmp.createCell(1).setCellValue(apsGoodsSaleItem.getParentSaleConfig().getSaleCode() + "/"
          + apsGoodsSaleItem.getParentSaleConfig().getSaleName());
      rowTmp.createCell(2).setCellValue(apsGoodsSaleItem.getCurrentSaleConfig().getSaleCode() + "/"
          + apsGoodsSaleItem.getCurrentSaleConfig().getSaleName());
    });
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
    return new CreateSaleConfigSheet(monthList, apsGoodsSaleItemList, style);
  }

  private record CreateSaleConfigSheet(List<String> monthList,
                                       List<ApsGoodsSaleItem> apsGoodsSaleItemList,
                                       CellStyle style) {

  }

  private static void setColumnWidth(SXSSFWorkbook workbook) {
    IntStream.range(0, workbook.getNumberOfSheets()).forEach(i -> {
      SXSSFSheet sheetAt = workbook.getSheetAt(i);

      IntStream.range(1, 3).forEach(t -> sheetAt.setColumnWidth(t, 30 * 256));
//      sheetAt.autoSizeColumn(0);
      IntStream.range(3, sheetAt.getRow(0).getLastCellNum())
          .forEach(t -> sheetAt.setColumnWidth(t, 15 * 256));
    });
  }

  private static void createGroupSheet(List<ApsGoodsSaleItem> apsGoodsSaleItemList,
      ApsGoodsForecast goodsForecast, SXSSFWorkbook workbook, ApsGoods apsGoods,
      CellStyle headerCellStyle, CellStyle bodyCellStyle, List<String> monthList) {
    List<List<ApsGoodsSaleItem>> allApsSaleItemList = new ArrayList<>(apsGoodsSaleItemList.stream()
        .collect(Collectors.groupingBy(t -> t.getCurrentSaleConfig().getParentId())).values());

    allApsSaleItemList.removeIf(t -> !goodsForecast.getSaleConfigList()
        .contains(t.getFirst().getParentSaleConfig().getId()));

    if (CollUtil.isEmpty(allApsSaleItemList)) {
      log.error("allApsSaleItemList is null id : {} ", goodsForecast.getId());
      return;
    }

    List<List<ApsGoodsSaleItem>> listList = ListUtils.cartesianProductAlt(allApsSaleItemList);
    String sheetName = allApsSaleItemList.stream()
        .map(t -> t.getFirst().getParentSaleConfig().getSaleName())
        .distinct().collect(Collectors.joining("-"));
    log.info("sheetName :  {}", sheetName);
    Sheet groupSheet = workbook.createSheet(sheetName);
    Row headerRow = groupSheet.createRow(0);
    headerRow.createCell(1).setCellValue("销售ID");
    headerRow.createCell(1).setCellValue(apsGoods.getGoodsName());
    headerRow.getCell(1).setCellStyle(bodyCellStyle);
    headerRow.createCell(3).setCellValue("月份");
    headerRow.getCell(3).setCellStyle(headerCellStyle);
    AtomicInteger i = new AtomicInteger(4);
    monthList.forEach(t -> {
      Cell cellTmp = headerRow.createCell(i.getAndIncrement());
      cellTmp.setCellStyle(headerCellStyle);
      cellTmp.setCellValue(t);
    });
    AtomicInteger rowIndex = new AtomicInteger(1);
    listList.forEach(t -> {
      List<ApsGoodsSaleItem> t1 = new ArrayList<>(t);
      t1.sort(Comparator.comparing(tt -> tt.getCurrentSaleConfig().getSaleCode()));
      Row rowRow = groupSheet.createRow(rowIndex.getAndIncrement());
      rowRow.createCell(0).setCellValue(
          t1.stream().map(ApsGoodsSaleItem::getSaleConfigId).map(String::valueOf).collect(
              Collectors.joining(",")));
      rowRow.createCell(1).setCellValue(
          t1.stream().map(
                  tt -> tt.getParentSaleConfig().getSaleCode() + "_" + tt.getParentSaleConfig()
                      .getSaleName())
              .collect(Collectors.joining("/")));
      rowRow.createCell(2).setCellValue(
          t1.stream().map(
                  tt -> tt.getCurrentSaleConfig().getSaleCode() + "_" + tt.getCurrentSaleConfig()
                      .getSaleName())
              .collect(Collectors.joining("/")));
    });
    groupSheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 2));
  }
}
