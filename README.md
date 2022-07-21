## 社区

项目本地访问地址：http://localhost:8887/

## 资料
https://spring.io/guides



## 工具


## 脚本
mybatis generator 生成脚本：
```bash
mvn -Dmybatis'.generator.overwrite=true' mybatis-generator:generate
```
服务器运行脚本：
```bash
java -jar -Dspring.profiles.active=production target/community-0.0.1-SNAPSHOT.jar
```


