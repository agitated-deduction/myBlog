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
![dbTest](./img/dbTest)

### DB 생성하기
```sql
create table tbl_member(
	num int(11) AUTO_INCREMENT NOT NULL,
	id VARCHAR(20) NOT NULL UNIQUE,
	pwd VARCHAR(256) NOT NULL,
	name VARCHAR(16) NOT NULL,
	email VARCHAR(32) NOT NULL,
	`date` DATE NOT NULL,
	PRIMARY KEY(num, id)
);
create table tbl_board(
	idx int(11) AUTO_INCREMENT NOT NULL,
	title VARCHAR(100) NOT NULL,
	content text NOT NULL,
	writer VARCHAR(20) NOT NULL,
	`date` date NOT NULL,
	hit int(11) NOT NULL default 0,
	`lock` tinyint(1) NOT NULL default 0,
	PRIMARY KEY(idx)
);
```
