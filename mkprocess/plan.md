# 계획

### 구상
GET: /

GET: /member/login<br>
POST: /member/login<br>
GET: /member/join<br>
POST: /member/join<br>
GET: /member/logout<br>
GET: /memeber/account/info<br>
PUT: /member/account/info<br>
DELETE: /member/accoutn/info<br>

GET: /board

GET: /{bid}<br>
GET: /{uid}/post<br>
POST: /{uid}/post<br>

PUT: /{uid}/post<br>
GET: /{bid}/{num}<br>
DELETE: /{uid}/{num}<br>


### DB
member<br>
num int(11) AUTO_INCREMENT NOT NULL,<br>
id VARCHAR(20) NOT NULL,<br>
pwd VARCHAR(256) NOT NULL,<br>
name VARCHAR(16) NOT NULL,<br>
email VARCHAR(32) NOT NULL,<br>
date DATE NOT NULL,<br>
PRIMARY KEY(member_idx),<br>
UNIQUE KEY member_uk(member_id)<br>

board<br>
idx int(11) AUTO_INCREMENT NOT NULL,<br>
title VARCHAR(64) NOT NULL,<br>
content text NOT NULL,<br>
author int(11) NOT NULL,<br>
date date NOT NULL,<br>
hit int(11) NOT NULL default 0,<br>
lock boolean<br>
FOREIGN KEY (author) references member(num)<br>
primary key(idx)<br>


| 날짜 | 계획 | ... |
|:--------|:--------|:--------|
| 2020-08-20 | GET: /board | 날짜 출력 형태(YYYY-MM-DD HH:mm), 프론트 화면 이쁘게 |
| 2020-08-21 | /{id} | <center>-</center> |
| 2020-08-22 | <center>-</center> | 오류화면, 트랜잭션 |
| 2020-08-23 | /member | <center>-</center> |
| 2020-08-23 | /member | 인터셉터 |


추가로 필요한거
카테고리, 구독