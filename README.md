# Capstone

# <a name="#Databases"></a>Capstone Databases

## <a name="#ServerProperties"></a>Properties
|Name|Value|
|---|---|
|Product|MariaDB|
|Version|10.7.3-MariaDB|
|Version Comment|mariadb.org binary distribution|
|Version Compile Machine|x64|
|Version Compile Os|Win64|
|Collation|utf8mb3_general_ci|
|Hostname|diligentp.com|
|Port|3306|
|Base Directory|C:\Program Files\MariaDB 10.7\\|

---

# Tables
## <a name="#Tables"></a>Objects _`2`_
|Name|Description|
|---|---|
|accounttable|사용자 계정 테이블|
|focustable|집중시간 테이블|


---


# accounttable

## <a name="#Description"></a>Description
> 사용자 계정 테이블


## <a name="#Columns"></a>Columns
|Key|Name|Data Type|Length|Precision|Scale|Unsigned|Zerofill|Binary|Not Null|Auto Increment|Default|Virtual|Description|
|:---:|---|---|---|---|---|---|---|---|---|---|---|---|---|
|PK|userno|INT||11||False|False|False|True|True||False||
||userid|VARCHAR|20|||False|False|False|True|False||False||
||userpass|VARCHAR|50|||False|False|False|True|False||False||
||username|VARCHAR|30|||False|False|False|True|False||False||
||userphone|VARCHAR|50|||False|False|False|True|False||False||
||useremail|VARCHAR|50|||False|False|False|False|False|NULL|False||
||userage|INT||11||False|False|False|True|False||False||
||regidate|DATE|0|||False|False|False|True|False||False||

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths|
|:---:|---|---|---|---|---|
||AccountTable_userno_uindex|userno|True|None||

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE accounttable (
  userno INT(11) NOT NULL AUTO_INCREMENT,
  userid VARCHAR(20) NOT NULL,
  userpass VARCHAR(50) NOT NULL,
  username VARCHAR(30) NOT NULL,
  userphone VARCHAR(50) NOT NULL,
  useremail VARCHAR(50) DEFAULT NULL,
  userage INT(11) NOT NULL,
  regidate DATE NOT NULL,
  PRIMARY KEY (userno),
  UNIQUE INDEX AccountTable_userno_uindex(userno)
)
ENGINE = INNODB,
CHARACTER SET utf8mb3,
COLLATE utf8mb3_general_ci;
```

---

# focustable

## <a name="#Description"></a>Description
> 집중시간 테이블


## <a name="#Columns"></a>Columns
|Key|Name|Data Type|Length|Precision|Scale|Unsigned|Zerofill|Binary|Not Null|Auto Increment|Default|Virtual|Description|
|:---:|---|---|---|---|---|---|---|---|---|---|---|---|---|
|FK|userno|INT||11||False|False|False|False|False|NULL|False||
||focustime_sec|INT||11||False|False|False|False|False|0|False|유저 집중시간 (초)단위|

## <a name="#Indexes"></a>Indexes
|Key|Name|Columns|Unique|Type|Key Lengths|
|:---:|---|---|---|---|---|
||FocusTable_accounttable_userno_fk|userno|False|None||

## <a name="#ForeignKeys"></a>Foreign Keys
|Name|Columns|Delete Rule|Update Rule|
|---|---|---|---|
|FocusTable_accounttable_userno_fk|userno|N/S|N/S|

## <a name="#SqlScript"></a>SQL Script
```SQL
CREATE TABLE focustable (
  userno INT(11) DEFAULT NULL,
  focustime_sec INT(11) DEFAULT 0 COMMENT '유저 집중시간 (초)단위'
)
ENGINE = INNODB,
CHARACTER SET utf8mb3,
COLLATE utf8mb3_general_ci,
COMMENT = '집중시간 테이블';

ALTER TABLE focustable 
  ADD CONSTRAINT FocusTable_accounttable_userno_fk FOREIGN KEY (userno)
    REFERENCES accounttable(userno) ON UPDATE CASCADE;
```
