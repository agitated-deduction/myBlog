# 계획

### 구상
GET: /



GET: /member/login
POST: /member/login
GET: /member/join
POST: /member/join
GET: /member/logout
GET: /memeber/account/info
UPDATE: /member/account/info
DELETE: /member/accoutn/info



GET: /{id}
GET: /{id}/fpost
POST: /{id}/fpost

UPDATE: /{id}/fpost
GET: /{id}/{num}
DELETE: /{id}/{num}

### DB
member
num int(11) AUTO_INCREMENT NOT NULL,
id VARCHAR(20) NOT NULL,
pwd VARCHAR(256) NOT NULL,
name VARCHAR(16) NOT NULL,
email VARCHAR(32) NOT NULL,
date DATE NOT NULL,
PRIMARY KEY(member_idx),
UNIQUE KEY member_uk(member_id)

board
idx int(11) AUTO_INCREMENT NOT NULL,
title VARCHAR(64) NOT NULL,
content text NOT NULL,
author int(11) NOT NULL,
date date NOT NULL,
hit int(11) NOT NULL default 0,
lock boolean
FOREIGN KEY (author) references member(num)
primary key(idx)