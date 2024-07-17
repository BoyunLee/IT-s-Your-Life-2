# 1. 최고 연봉을 받는 직원의 이름과 그의 부서명 찾기
INSERT INTO emp_data(EMPNO, ENAME, JOB, HIREDATE, SAL, DEPTNO)
VALUES (7839, 'KING', 'PRESIDENT',	1981-11-17,	5000, 10);

SELECT E.ENAME, D.DNAME
FROM emp_data E
JOIN dept_data D
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL = (SELECT MAX(SAL) FROM emp_data);

# 2. 각 부서의 평균 연봉보다 더 많은 연봉을 받는 직원들의 목록
SELECT E.*, D.*
FROM emp_data E
JOIN DEPT_DATA D 
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL > (
	SELECT AVG(SAL) FROM EMP_DATA
	WHERE DEPTNO = E.DEPTNO
);

# 3. 부서별로 최고 연봉을 받는 직원의 정보 찾기
SELECT E.*, D.*
FROM emp_data E
JOIN DEPT_DATA D 
ON E.DEPTNO = D.DEPTNO
WHERE E.SAL = (
	SELECT MAX(SAL) FROM EMP_DATA
	WHERE DEPTNO = E.DEPTNO
);

# 4. 부서 위치가 'CHICAGO'인 모든 직원들의 정보
SELECT E.*, D.*
FROM emp_data E
JOIN DEPT_DATA D 
ON E.DEPTNO = D.DEPTNO
WHERE D.LOC = 'CHICAGO';

# 5. 모든 매니저 (MGR) 아래에서 일하는 직원들의 목록
SELECT E.*, D.*
FROM emp_data E
JOIN dept_data D 
ON E.DEPTNO = D.DEPTNO
WHERE E.MGR is NOT NULL;

