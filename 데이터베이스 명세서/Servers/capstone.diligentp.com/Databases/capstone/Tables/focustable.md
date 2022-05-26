[Project](../../../../../startpage.md)>[Servers](../../../../Servers.md)>[capstone.diligentp.com](../../../capstone.diligentp.com.md)>[Databases](../../Databases.md)>[capstone](../capstone.md)>[Tables](Tables.md)>focustable


# ![logo](../../../../../Images/table64.svg) focustable

## <a name="#Description"></a>Description
> 집중시간 테이블
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
|Created|2022-05-26 오후 9:54:00|
|Last Modified|0001-01-01 오전 12:00:00|


## <a name="#Columns"></a>Columns
|Key|Name|Data Type|Length|Precision|Scale|Unsigned|Zerofill|Binary|Not Null|Auto Increment|Default|Virtual|Description|
|:---:|---|---|---|---|---|---|---|---|---|---|---|---|---|
|[![Foreign Keys FocusTable_accounttable_userno_fk: accounttable](../../../../../Images/foreignkey.svg)](#ForeignKeys)[![Indexes FocusTable_accounttable_userno_fk](../../../../../Images/index.svg)](#Indexes)|userno|INT||11||False|False|False|False|False|NULL|False||
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

## <a name="#DependsOn"></a>Depends On _`1`_
- ![Table](../../../../../Images/table.svg) [accounttable](accounttable.md)


## <a name="#UsedBy"></a>Used By
No items found

||||
|---|---|---|
|Author: |Copyright © All Rights Reserved|Created: 26-05-2022|
# dbForge Documenter Trial