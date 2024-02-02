/* 
@Api 注解通常在基于 Spring Boot 的 RESTful API 项目中用于生成API文档，
它不是 Java 核心的一部分，而是通常与第三方工具（如 Swagger 或 Springfox Swagger）一起使用

Swagger 很重要
*/



/*
这个是如何生成Api

@Api 和 @ApiOperation 注解用于定义 API 的细节
*/
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(value = "用户管理API", description = "用于管理用户信息的API")      //Api(value = <input>)  这个属性主要表明了api的名称或者标题， 用于描述这个api的用途
public class UserController {

    @GetMapping("/{id}")
    @ApiOperation(value = "根据用户ID获取用户信息", notes = "根据用户ID查询并返回用户信息")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // 实际的业务逻辑
    }

    @PostMapping("/")
    @ApiOperation(value = "创建新用户", notes = "创建新用户并返回用户信息")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // 实际的业务逻辑
    }

    // 其他方法...
}



/*
介绍：
    - 下面这个是配置环境， 在哪里生成api， 告诉了swagger框架如何去扫描和生成api
    - 通常上面的代码和下面的代码是分开的， 在不同file。
*/
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller")) // 指定扫描的包
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("API 文档")
                        .description("示例 Spring Boot RESTful API 文档")
                        .version("1.0")
                        .build());
    }
}