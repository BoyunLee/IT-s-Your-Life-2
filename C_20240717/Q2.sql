USE shop8;

-- 1. ClubName이 '음악'인 신청 삭제
DELETE 
FROM clubapplication
WHERE ClubName = '음악';

-- 2. StudentID가 103인 학생의 주소를 '서울시 강북구'로 수정
UPDATE student SET address = '서울시 강북구' 
WHERE StudentID = 103;

-- 3. ProfessorName 이 박지훈 인 교수의 연락처를 '02 777 8888' 로 수정
UPDATE professor SET PhoneNumber = '02-777-8888' 
WHERE ProfessorName = '박지훈';

-- 4. 모든 학생의 이름과 그들이 신청한 클럽 이름을 출력 (조인)
SELECT s.StudentName, c.ClubName
FROM student s
LEFT OUTER JOIN clubapplication c ON s.StudentID = c.StudentID; 

-- 5. 모든 학생들의 정보는 출력하고 , 학생이 가입한 클럽이 있으면 클럽명과 지도교수이름을 함께 출력 (조인)
SELECT s.*, c.ClubName, c.ProfessorName
FROM student s
LEFT OUTER JOIN clubapplication c ON s.StudentID = c.StudentID;