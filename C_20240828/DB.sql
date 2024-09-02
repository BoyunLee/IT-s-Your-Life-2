use shop2;
CREATE TABLE Young (
bizId varchar(500) NOT NULL,
polyBizSjnm varchar(500),
plcyTpNm varchar(500),
cnsgNmor varchar(500),
rqutProcCn varchar(500),
PRIMARY KEY (bizId)
);
use shop2;
CREATE TABLE Movie (
rnum VARCHAR(50) PRIMARY KEY, -- Assumingrnum is the unique identifier
ranks VARCHAR(10),
rankInten VARCHAR(10),
rankOldAndNew VARCHAR(10),
movieCd VARCHAR(20),
movieNm VARCHAR(100),
openDt DATE, -- Assuming openDt is a date
salesAmt DECIMAL(15, 2),
salesShare DECIMAL(5, 2),
salesInten DECIMAL(15, 2),
salesChange DECIMAL(5, 2),
salesAcc DECIMAL(15, 2),
audiCnt DECIMAL(15, 2),
audiInten DECIMAL(15, 2),
audiChange DECIMAL(5, 2),
audiAcc DECIMAL(15, 2),
scrnCnt INT,
showCnt INT
);
use shop2;
CREATE TABLE MoviePerson (
peopleCd VARCHAR(255) NOT NULL, -- 영화인 코드를 출력합니다
peopleNm VARCHAR(255) NOT NULL, -- 영화인명을 출력합니다
peopleNmEn VARCHAR(255), -- 영화인명 영문 을 출력합니다
repRoleNm VARCHAR(255), -- 분야를 출력합니다
filmoNames TEXT -- 필모리스트를 출력합니다
);