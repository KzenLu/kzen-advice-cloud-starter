# kzen-advice-cloud-starter

result-unified

使用方式

* 1、打包方式

  ~~~java
  mvn install:install-file -Dfile=/Users/kzen/kzen-advice-cloud-starter-1.0-SNAPSHOT.jar -DgroupId=com.kzen.cloud -DartifactId=kzen-advice-cloud-starter -Dversion=1.0-SNAPSHOT -Dpackaging=jar
  ~~~

* 2、pom.xml文件中（根据1中自定义打包方式、依赖会有变化）

~~~java
<dependency>
  <groupId>com.kzen.cloud</groupId>
  <artifactId>kzen-advice-cloud-starter</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
~~~

* 3、在springboot 启动类添加 @EnableResponseAdvice 注解

* 4、正常返回值内会出现示例样式：

  ~~~java
  {
      "code": 200,
      "message": "成功",
      "data": {
          "json_key":"value"
      },
      "currentTime": "2021-09-01 14:23:41"
  }
  ~~~

  
