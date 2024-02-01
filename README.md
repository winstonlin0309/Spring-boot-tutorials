# Spring-boot-tutorials
# 更改spring boot 读取的目录
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}

如果这样的话， 他只会读取那个main folder里面的资料，但是如果想要读取main folder外面的资料， 我们需要定义他们的路径
@SpringBootApplication(
		scanBasePackages = {"com.luv2code.springcoredemo",
							"com.luv2code.util"}
)
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}


# Beans
@Component
	@Lazy
		- 延迟注入, 通常与@Component一起用， 它涉及到在需要时才注入依赖项，而不是在容器启动时立即注入。这有助于减少应用程序启动时间，特别是当依赖项的创建或初始化可能很昂贵时
		- 可以通过application.preperties来给每一个dependency设置一个@Lazy， 无需给每一个class手动添加
			- aplication.preperties
				- spring.main.lazy-initialization = true
		-慎重使用， 具体不知道
	@Primary
		- 也叫Default Component， 当有多个Component 被declare的时候， 就可以使用 @Primary来设置一个主要的（默认）， 这样就不需要@Qualifier
	@Qualifier
		- 在有多个Component的时候， 标注想要使用哪一个Component
		- Ex.
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
		- 每一个bean default都只有一个实例， 这意味着每一个被创建的object 都point到一个实例， 但是通过这个方法就可以创建不同的实例， 这样他们就不会point到同一个实例

# Configuration Beans	自定义beans
@Congfiguration



## 数据库篇（MySQL） 
# CommandLineRunner
CommandLineRunner
	- 是Spring Boot中的一个接口（也是Bean），用于在Spring Boot应用程序启动后执行特定的任务或代码块。它通常用于执行一些初始化操作、数据加载、调度任务等
	- 在Spring Beans 加载之后才运行

@Entity
	- declare一个class为数据库中的一个Entity
	- 通常和@Table一起用
@Table
	- 这个是给该table设置为一个名字， 用在class上
@Id
	- 意思是这个variable为PK
@Column(name="your_variable_name")
	- 这个定义着在数据库中的变量名
	- Ex.
		@Column(name="first_name")			//注意的是： 在使用first_name的时候， 数据库必须要有这个变量名
		private String firstName			//这个意思就是在数据库中，他叫first_name， 但是在java中，我们把他赋予到了firstName
@GeneratedValue(Strategy = GenerationType.IDENTITY)
	- 要和@Id一起用
	- 这个定义了如何自动生成PK的值， 就像是 MYSQL里面的 AUTO_INCREMENT， 他会自己生成值，并且自动增加（default每次+1）
	- 这是一种基于数据库自增长列（如MySQL的AUTO_INCREMENT）的方式来生成主键值
	- Ex.
		@Id
		@GeneratedValue(Strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
@Transactional
	- 很重要的一个注解， 但是time cost比较高
	- Spring框架中的一个注解，用于管理事务。它的作用是指示Spring框架在被注解的方法上启用事务管理。事务是一组数据库操作，要么全部成功提交，要么全部失败回滚，以确保数据的一致性和完整性。

@Repository
	- 一般是用在DAO层(Data Access Object) 它的主要作用是将数据访问层的类识别为 Spring Bean，由 Spring 容器进行管理。使用 @Repository 注解的类通常用于与数据库、文件系统、Web服务或其他数据源进行交互，执行数据的持久化、检索和操作等任务。

## JPA 数据库篇
EntityManager: 是JPA库中的一个类，用这个可以和数据库进行交互， 运作CRUD功能
	CRUD：
	C:
		- EntityManager entityManager = new EntityManager
		- entityManager.persist(<data>); 		保存到数据库中

	R:
		- .find(<entity_class>, <PK>)
			- 通过entity_class以及pk值来找到数据, 如果没找到，返回null
			- 这里的Entity class 是值JPA 在java中赋予的对象类， 而不是db中的。
			- Ex.
				Student myStudent = entityManager.find(Student.class, 1)
		- Querying
			- entityManager.createQuery(<Query语法>, <Entity class>)
			- 需要注意的数， Query语法里面的变量名是JPA中的 而不是DB中的。
			- Ex.			
				theQuery = entityManager.createQuery("FROM Student Where lastName='Doe'", student.class)
				这里的Student 和lastName就是JPA中的，              

			 