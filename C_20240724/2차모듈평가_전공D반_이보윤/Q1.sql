-- 1-1. city테이블에대한전체내용을출력
SELECT * FROM city;

-- 1-2. countrylanguage테이블에서 CountryCode가‘CHE’인 Language, Percentage컬럼출력
SELECT Language, Percentage
FROM  countrylanguage
WHERE CountryCode = 'CHE';

-- 1-3. city테이블에다음항목데이터를삽입
-- -아이디: 자동증가
-- -도시이름: Cairo
-- -국가코드: EGY
-- -지구(District): Cairo Governorate
-- -인구: 9,500,000
INSERT INTO `world2`.`city`(`Name`, `CountryCode`, `District`, `Population`) 
VALUES ('Cairo', 'EGY', 'Cairo Governorate', 9500000);

-- 1-4. city 테이블에서 CountryCode가'PNG'인모든행의 Name 열값을'GoodSite'로변경
SELECT replace(C1.Name, C2.Name, 'GoodSite')
FROM city C1
JOIN city C2 ON C1.ID = C2.ID
WHERE C2.Name = (SELECT Name FROM city WHERE CountryCode = 'PNG');

-- 1-5. country테이블에서Name열을기준으로내림차순으로정렬하여모든컬럼을출력
SELECT *
FROM country
ORDER BY Name DESC;