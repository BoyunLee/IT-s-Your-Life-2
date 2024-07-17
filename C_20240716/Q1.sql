# 1. DEPTNO 컬럼을 기준으로 두 개의 테이블을 조인 후,  
# EMPNO, JOB, SAL, COMM, DNAME, LOC를 검색하여 출력하시오.(INNER JOIN)
SELECT E.EMPNO, E.JOB, E.SAL, E.COMM, D.DNAME, D.LOC
FROM emp_data E
INNER JOIN dept_data D ON E.DEPTNO = D.DEPTNO;

# 2. EMP 테이블 내에는 일반 직원과 매니저가 함께 저장되어있다. 
# 일반 직원의 EMPNO, JOB, SAL과 일반직원을 관리하는 MGR의 EMPNO, JOB을 함께 검색하여 출력하시오.(SELF JOIN)
SELECT E.EMPNO, E.JOB, E.SAL, E2.EMPNO, E2.JOB
FROM emp_data E
JOIN emp_data E2 ON E.MGR = E2.EMPNO;

# 3. 모든 DEPT_DATA 테이블의 항목이 출력되고, 
# 두 테이블 간 DEPTNO가 일치하는 것을 찾아 EMP_DATA 테이블의 DEPTNO, EMPNO, ENAME 항목을 추가 출력되도록 조인하시오.(OUTER JOIN)
SELECT D.*, E.DEPTNO, E.EMPNO, E.ENAME
FROM dept_data D
LEFT OUTER JOIN emp_data E ON E.DEPTNO = D.DEPTNO;