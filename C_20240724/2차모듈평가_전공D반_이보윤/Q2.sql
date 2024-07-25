-- 2-1. city테이블에서Name 컬럼의데이터를모두대문자로변경하여출력
SELECT upper(Name) AS NAME
FROM city;

-- 2-2. city테이블에서ID 컬럼과CountryCode 컬럼의데이터를결합하여“4080-TKM”와같이출력
SELECT concat(ID, "-", CountryCode) AS IDCountryCode
FROM city;

-- 2-3. city테이블에서District 컬럼데이터(영문)의글자수를출력
SELECT length(District) AS District
FROM city;

-- 2-4. city테이블에서Population 컬럼의평균값을출력
SELECT AVG(Population)
FROM city;

-- 2-5. country테이블에서Continent별최대값GNP값출력(출력항목은Continent 명, GNP 최대값. 출력순서는GNP 최대값의오름차순)
SELECT Continent, MAX(GNP)
FROM country
GROUP BY Continent
ORDER BY MAX(GNP);