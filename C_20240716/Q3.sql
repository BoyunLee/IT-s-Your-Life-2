# 1. SALES와 RESEARCH부서 직원 목록 합치기(UNION)
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE D.DNAME = 'SALES'
UNION
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE D.DNAME = 'RESEARCH';

# 2. 연봉이 2000 이상인 직원과 관리자 목록 합치기(UNION)
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL >= 2000
UNION
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE E.EMPNO IN (SELECT DISTINCT MGR FROM emp_data WHERE MGR IS NOT NULL);

# 3. 보스턴과 댈러스에 위치한 부서의 직원 목록 합치기(UNION)
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE D.LOC = 'DALLAS'
UNION
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE D.LOC = 'BOSTON';