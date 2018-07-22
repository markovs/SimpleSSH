## 项目结构

- main 项目主文件夹<br>
    - java 源码文件夹
        - cst.wyz.entity 实体类
        - cst.wyz.dao 数据库底层逻辑实现类
        - cst.wyz.service 业务逻辑类
        - cst.wyz.controller 业务控制类
    - resource 资源文件夹
        - jdbc.properties 数据库配置文件
        - applicationContext.xml Spring 配置文件，主要配置 Spring 容器的内容
        - springmvc.xml Spring MVC 配置文件，主要配置 MVC 的解析和转发
    - webapp web 相关文件夹
        - WEB-INF
            - images 静态图片资源
            - js 静态 js 资源
            - style 静态 css 资源
            - view 网页页面文件夹
## 依赖包
* 日志相关依赖
* 测试相关依赖
* Spring 相关依赖
* Hibernate 相关依赖
* 数据库相关依赖
* 服务器相关依赖
* Json 相关依赖

**见 pom.xml**
## bug 以及处理方法

* **java.lang.ClassNotFoundException: org.hibernate.boot.model.naming.ImplicitNamingStrategy**
> applicationContext.xml 中定义 sessionFactory bean 的时候，定义的 LocalSessionFactoryBean 是 Hibernate5 的，但是自己用的 Hibernate 因为要使用 createCriteria 所以是 Hibernate 4 版本的，bean 的 class 改成 Hibernate 4，问题解决。

---

*  **java.lang.ClassNotFoundException: javax.servlet.http.HttpServletRequest **
>  
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>servlet-api</artifactId>
      <version>2.5</version>
    </dependency>
---
* **java.lang.NoSuchMethodError: org.hibernate.engine.spi.SessionImplementor.getJdbcCoordinator()**
> 查看源码发现 Hibernate4.* 没有``` getJdbcCoordinator()```方法，修改版本号到 5.1.14.Final
---
* **java.lang.ClassNotFoundException: javax.xml.bind.JAXBException**
> JAXB API是java EE 的API，因此在java SE 9.0 中不再包含这个 Jar 包。 
java 9 中引入了模块的概念，默认情况下，Java SE中将不再包含java EE 的Jar包 
而在 java 6/7 / 8 时关于这个API 都是捆绑在一起的
---
* **java.lang.ClassNotFoundException: javax.servlet.SessionCookieConfig**
> Spring 4 需要依赖 servlet 3.0 以上的版本支持
---
* **java.lang.ClassNotFoundException: com.fasterxml.jackson.core.util.DefaultPrettyPrinter$Indenter**
* **java.lang.ClassNotFoundException: com.fasterxml.jackson.databind.ObjectMapper**
> Json 媒体类型的支持问题，需要在spring mvc 中设置请求处理转换 bean 能够实现将字符串转换为 json 数据传输。**发出的请求需要设置 Content-type 为 application/json. 且Controller 接收参数时需设置 ```@RequestBody```**注解
```
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping"/>

    <bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
        <property name="cacheSeconds" value="0"/>
        <property name="messageConverters">
            <list>
                <ref bean="mappingJacksonHttpMessageConverter"/>
                <ref bean="mappingStringHttpMessageConverter"/>
            </list>
        </property>
    </bean>

    <bean id="mappingStringHttpMessageConverter" class="org.springframework.http.converter.StringHttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <value>text/plain;charset=UTF-8</value>
                <value>application/json;charset=UTF-8</value>
            </list>
        </property>
    </bean>

    <bean id="mappingJacksonHttpMessageConverter" class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
        <property name="supportedMediaTypes">
            <list>
                <bean class="org.springframework.http.MediaType">
                    <constructor-arg index="0" value="application"/>
                    <constructor-arg index="1" value="json"/>
                    <constructor-arg index="2" value="UTF-8"/>
                </bean>
            </list>
        </property>
    </bean>
```
```
<dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.5.2</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.5.2</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.5.2</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.module</groupId>
            <artifactId>jackson-module-jaxb-annotations</artifactId>
            <version>2.5.2</version>
        </dependency>
```
---
