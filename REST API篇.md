
# @RestController  
    - 用在class上， 这个意思就是该class是控制rest的 api接口
# @RequestMapping("<path>")   
    - 用在class上， 初始接口， 
    - Ex.
        @RequestMapping("api")      这样后面的所有request/response的路径前面都要加一个 api/<路径>
# @GetMapping("<path>")
    - 当用户试图访问这个网站的时候， 需要给他return什么资料
    - 可以自定义path variable， 用到path variable的时候， 在declare function parameter的时候，前面要加一个 @PathVariable <declaration of variable>, 并且两个variable必须一样名字
        - Ex.
            @GetMapping("/students/{studentId}")   这样我可以可以访问 /api/students/0  /api/students/1 ...等
            public Student getStudent(@PathVariable int studentId)