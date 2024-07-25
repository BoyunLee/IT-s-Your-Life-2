-- 3-1. city 테이블과country 테이블을CountryCode컬럼과Code 컬럼기준으로조인하고, city의Name과conutry의Name을출력하시오. (inner join문이용)
SELECT C1.Name, C2.Name
FROM city C1
INNER JOIN country C2 ON C1.CountryCode = C2.Code;

-- 3-2. country테이블에서모든국가명을출력하고각국가에서사용되는언어를함께출력(사용언어가없는경우NULL 표시, outer join문이용)
SELECT c.Name, l.Language
FROM country c
LEFT OUTER JOIN countrylanguage l ON c.Code = l.CountryCode;

-- 3-3. city테이블에서최대인구를가진도시의이름을출력(서브쿼리, MAX()함수이용)
SELECT c1.Name
FROM city c1
JOIN city c2 ON c1.ID = c2.ID
WHERE c2.Population = (SELECT MAX(Population) FROM city);