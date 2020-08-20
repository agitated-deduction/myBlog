# DB


### DB 연결 테스트

MySQL, MyBatis

web.xml
```xml
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-config>classpath:spring/*-context.xml</param-config>
</context-param>
```
classpath: 는 src/main/resourses

dataSource-context.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"

	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"


 
	xmlns:mybatis-spring="http://mybatis.org/schema/mybatis-spring"

	xsi:schemaLocation="

http://mybatis.org/schema/mybatis-spring 

http://mybatis.org/schema/mybatis-spring.xsd

http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	

<!--dataSource 객체 설정 -->

<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">

<property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />

<property name="url" value="jdbc:mysql://127.0.0.1:3306/myblog?useSSL=false&amp;serverTimezone=Asia/Seoul" />       

        <property name="username" value="root"></property>

        <property name="password" value="1234"></property>

</bean>  



<!-- SqlSessionFactory 객체 설정 -->

<bean id="SqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">

<property name="dataSource" ref="dataSource" />       

<property name="mapperLocations" value="classpath:/mappers/**/*Mapper.xml" />

</bean>

	

<!-- SqlSession Template 설정 -->

<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate" destroy-method="clearCache">

<constructor-arg name="sqlSessionFactory" ref="SqlSessionFactory" />

</bean>

</beans>


```

src/main/resources
에 mapper폴더 생성
00Mapper.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper

    PUBLIC "-//mybatis.org/DTD Mapper 3.0//EN"

    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

    

<mapper namespace="com.wakefield.myblog.board.boardMapper">



</mapper>
```

src/test/java
MySQLConnectionTest.java
```java
package com.wakefield.myblog;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/dataSource-context.xml"})
public class MySQLConnectionTest {
	private static final Logger logger = LoggerFactory.getLogger(MySQLConnectionTest.class);
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testConnection() {
		try(Connection conn = ds.getConnection()){
			logger.info("\n MySQL 연결:" + conn);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

```

MyBatisTest.java
```java
import javax.annotation.Resource;



import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = { "classpath:spring/dataSource-context.xml" })

public class MybatisTest {

	private static final Logger logger = LoggerFactory.getLogger(MybatisTest.class);

	

	@Inject

	private SqlSessionFactory sessionFactory;

	

	@Test

	public void testSessionFactory() {

		logger.info("\n Session Factory : " + sessionFactory);

	}

	

	@Test

	public void testSqlSession() {

		try (SqlSession session = sessionFactory.openSession()){

			logger.info("\n Sql Session : " + session);

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}

```

테스트 성공
![dbTest](./img/dbTest.PNG)


### DB 생성하기
```sql
create table tbl_member(
	num int(11) AUTO_INCREMENT NOT NULL,
	id VARCHAR(20) NOT NULL UNIQUE,
	pwd VARCHAR(256) NOT NULL,
	name VARCHAR(16) NOT NULL,
	email VARCHAR(32) NOT NULL,
	`date` datetime NOT NULL,
	PRIMARY KEY(num, id)
);
create table tbl_board(
	idx int(11) AUTO_INCREMENT NOT NULL,
	title VARCHAR(100) NOT NULL,
	content text NOT NULL,
	writer VARCHAR(20) NOT NULL,
	`date` datetime NOT NULL,
	hit int(11) NOT NULL default 0,
	`lock` tinyint(1) NOT NULL default 0,
	PRIMARY KEY(idx)
);
```


[mysql datetime과 timestamp에 대해](https://nesoy.github.io/articles/2020-02/mysql-datetime-timestamp)

### DB 쿼리 모니터링
pom.xml
```xml
<!-- https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4 -->
<dependency>
    <groupId>org.bgee.log4jdbc-log4j2</groupId>
    <artifactId>log4jdbc-log4j2-jdbc4</artifactId>
    <version>1.16</version>
</dependency>
```
dataSource-context.xml
```xml
<!--  
<property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
<property name="url" value="jdbc:mysql://127.0.0.1:3306/myblog?useSSL=false&amp;serverTimezone=Asia/Seoul" />       
-->
<property name="driverClassName" value="net.sf.log4jdbc.sql.jdbcapi.DriverSpy" />
<property name="url" value="jdbc:log4jdbc:mysql://127.0.0.1:3306/myblog?allowPublicKeyRetrieval=true&amp;useSSL=false&amp;serverTimezone=UTC" />

```

log4jdbc.log4j2.properties
```
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```

log4j.xml
```xml
<!-- SQL Logger -->
	<logger name="jdbc.sqltiming" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>
	<!--sqltiming: SQL문과 실행시키는데 수행된 시간 정보 -->

	<logger name="jdbc.sqlonly" additivity="false"> 
		<level value="info"/> 
		<appender-ref ref="console"/> 
	</logger>
	<!--sqlonly: 쿼리문장만 로그로. -->

	<logger name="jdbc.audit" additivity="false"> 
		<level value="warn"/>  
		<appender-ref ref="console"/> 
	</logger> 
	<!--audit: resultset을 제외한 모든 jdbc호출 정보를 남긴다. 많은 양의 로그 생성, JDBC문제를 추적할 필요가 없는 경우 권장하지 않음 -->

	<logger name="jdbc.resultset" additivity="false">
		<level value="warn" />
		<appender-ref ref="console"/> 
	</logger>
	<!--resultset: audit + resultset까지. 많은양의 로그-->
     
	<logger name="jdbc.resultsettable" additivity="false"> 
		<level value="info"/>  
		<appender-ref ref="console"/> 
	</logger> 
	<!--resultsettable: 조회 된 데이터의 table을 로그로 남긴다. -->
```