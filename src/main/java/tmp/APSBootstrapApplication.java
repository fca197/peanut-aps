package tmp;

import cn.hutool.system.SystemUtil;
import com.google.ortools.Loader;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;
import com.olivia.sdk.config.ServiceNotice;
import com.olivia.sdk.utils.MDCUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***
 *
 */
@Slf4j
@EnableCaching
//@EnableAspectJAutoProxy
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@MapperScan(basePackages = {"com.olivia.peanut.*.mapper", "com.olivia.sdk.mapper"})
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.olivia")
@EnableTransactionManagement
public class APSBootstrapApplication {

  static {
    MDCUtils.initMdc();
    // 非window下 加载 or-tools 库
    // window下使用修改pom.xml中 ortools-java依赖排除的节点删除,增加window依赖
    log.info("load or-tools {}", SystemUtil.getOsInfo().getName());
    if (!SystemUtil.getOsInfo().isWindows()) {
      Loader.loadNativeLibraries();
    }
//    TypeHandlerRegistry

    AviatorEvaluator.getInstance().setOption(Options.OPTIMIZE_LEVEL, AviatorEvaluator.COMPILE);

    MDCUtils.clear();
  }


  public static void main(String[] args) {

    MDCUtils.initMdc();
    try {
      log.info(">>>>>>>  APSBootstrapApplication  start  >>>>>>>");

      SpringApplication.run(APSBootstrapApplication.class, args);
      log.info(">>>>>>>  APSBootstrapApplication  start success >>>>>>>");
      ServiceNotice.start();
    } catch (Exception e) {
      ServiceNotice.errorStop(e);
    }

    MDCUtils.clear();
  }
}
