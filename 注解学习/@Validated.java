/*
介绍： 
    - @Validated是一个用于标注在类或方法上的注解，用于启用方法参数校验的功能。它通常与javax.validation中的注解
    （例如@NotNull、@Min、@Max等）一起使用，以验证方法的输入参数是否符合预期的规则。

在什么层使用
    - 服务层 或者 管理层

*/

@RestController
@RequestMapping("/api")
@Validated
public class UserController {

    @PostMapping("/createUser")             //需要在检查的parameter里面添加@valid
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        // 在这里处理用户创建逻辑
        return ResponseEntity.ok("用户创建成功");
    }
}




/* 
 * 使用@Validated的时候 一般在需要被Validated的 class里面要添加定义信息， 
    - 比如@NotNull， 
      @NotEmpty
      @NotBlank
      @Size(min, max)
      @Min(value)
      @Max(value)
      @Pattern(regex)
      @Email
    下面就是个User class declaration的例子
*/

public class User {
    @NotNull
    private String username;
    
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
    @Email
    private String email;

    // 其他字段和方法...
}
