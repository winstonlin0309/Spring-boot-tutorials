# Turn off the spring boot banner
spring.main.banner-mode=off

# Reduce logging level.     Set logging level to warn
logging.level.root=warn

# Add logging configs to display SQL statement
logging.level.org.hibernate.SQL = debug
logging.level.org.hibernate.orm.jdbc.bind=trace


# 如果table已经存在了，会自动drop， 然后重新create一个（在公司慎用这个）
spring.jpa.hibernate.ddl-auto=create    

# 保存原有的data 作用是自动更新数据库表结构以反映实体类的定义变化，但它通常只应该在开发和测试阶段使用，因为在生产环境中自动更新数据库表结构可能会有一些潜在的风险，因此在生产环境中通常建议将其设置为 "none" 或 "validate"，以避免不必要的数据库表结构修改
spring.jpa.hibernate.ddl-auto=update