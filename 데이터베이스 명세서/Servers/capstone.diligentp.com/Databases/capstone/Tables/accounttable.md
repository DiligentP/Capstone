[Project](../../../../../startpage.md)>[Servers](../../../../Servers.md)>[capstone.diligentp.com](../../../capstone.diligentp.com.md)>[Databases](../../Databases.md)>[capstone](../capstone.md)>[Tables](Tables.md)>accounttable


# ![logo](../../../../../Images/table64.svg) accounttable

## <a name="#Description"></a>Description
> 사용자 계정 테이블
## <a name="#Properties"></a>Properties
|Name|Value|
|---|---|
|Engine|InnoDB|
|Auto Increment|0|
|Average Row Length|0|
|Charset|utf8mb3|
|Collation|utf8mb3_general_ci|
|Row Format|Default|
|Min Rows|0|
|Max Rows|0|
|Checksum|False|
|Page Checksum|True|
|Pack Keys|False|
|Delay Key Write|False|
|Is Partitioned|False|
|Encryption|False|
|Encryption Key Id|0|
|Persistent Statistics|DEFAULT|
|Auto Recalculate Statistics|DEFAULT|
|Sample Pages|0|
|Created|2022-05-26 오후 9:40:06|
|Last Modified|0001-01-01 오전 12:00:00|


## <a name="#Columns"></a>Columns
|Key|Name|Data Type|Length|Precision|Scale|Unsigned|Zerofill|Binary|Not Null|Auto Increment|Default|Virtual|Description|
|:---:|---|---|---|---|---|---|---|---|---|---|---|---|---|
|[![Primary Key ](../../../../../Images/primarykey.svg)](#Indexes)[![Indexes AccountTable_userno_uindex](../../../../../Images/index.svg)](#Indexes)|userno|INT||11||False|False|False|True|True||False||
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

## <a name="#DependsOn"></a>Depends On
No items found

## <a name="#UsedBy"></a>Used By _`1`_
- ![Table](../../../../../Images/table.svg) [focustable](focustable.md)


||||
|---|---|---|
|Author: |Copyright © All Rights Reserved|Created: 26-05-2022|
# dbForge Documenter Trial