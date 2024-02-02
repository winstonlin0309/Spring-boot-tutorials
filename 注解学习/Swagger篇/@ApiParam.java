/*

介绍
    - @ApiParam 是一个 Swagger 注解，通常用于文档化 API 的方法参数，以提供更详细的参数描述和额外的元信息。
       它用于在生成 API 文档时为参数添加说明和约束信息。

使用方式
    - @Api  在class上
    - @ApiOperation     在method上
    - @ApiParam     在parameter上

 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(value = "用户管理API", description = "用于管理用户信息的API")      //Api(value = <input>)  这个属性主要表明了api的名称或者标题， 用于描述这个api的用途
public class UserController {

    @GetMapping("/getUser")
    @ApiOperation(value = "根据用户ID获取用户信息", notes = "根据用户ID查询并返回用户信息")
    public ResponseEntity<User> getUserById(@ApiParam(value = "用户ID") @PathVariable Long id) {
        //@ApiParam在这里的意思就是 它提供了参数的描述信息， 但是他不是必填的， 如果要设置成必填的如下
        // @ApiParam(value = "用户ID", required = true)
    }

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

    

}
