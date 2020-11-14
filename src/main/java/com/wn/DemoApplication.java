package com.wn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*@SpringBootApplication就是一个组合注解：

-  @SpringBootConfiguration就是@Configuration注解，代表启动类就是一个配置类。
-  @EnableAutoConfiguration帮你实现自动装配的，SpringBoot工程启动时，运行一个SpringFactoriesLoader的类，加载META-INF/spring.factories配置类（已经开启的），通过SpringFactoriesLoader中的load方法，以for循环的方式，一个一个加载。
   - 好处：无需编写大量的整合配置信息，只需要按照SpringBoot提供好了约定去整合即可。
   - 坏处：如果说你导入了一个starter依赖，那么你就需要填写他必要的配置信息。
   - 手动关闭自动装配指定内容：@SpringBootApplication(exclude = QuartzAutoConfiguration.class)
-  @ComponentScan就相当于<context:component-scan basePackage=“包名” />，帮助扫描注解的。*/
@SpringBootApplication
/*添加一个mapper扫描*/
@MapperScan(basePackages = "com/wn/mapper")

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
