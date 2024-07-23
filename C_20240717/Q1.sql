CREATE DATABASE shop8;
USE shop8;

-- student 테이블 생성
CREATE TABLE student (
    StudentID INT PRIMARY KEY,
    StudentName VARCHAR(50),
    PhoneNumber VARCHAR(15),
    Address VARCHAR(100)
);

-- professor 테이블 생성
CREATE TABLE professor (
    ProfessorName VARCHAR(50) PRIMARY KEY,
    Office VARCHAR(50),
    PhoneNumber VARCHAR(15)
);

-- clubapplication 테이블 생성
CREATE TABLE clubapplication (
	clubID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT NOT NULL,
    ClubName VARCHAR(50),
    ProfessorName VARCHAR(50),
    FOREIGN KEY (StudentID) REFERENCES student(StudentID),
    FOREIGN KEY (ProfessorName) REFERENCES professor(ProfessorName)
);

INSERT INTO student (StudentID,	StudentName, PhoneNumber, Address) VALUES
(101, '이영희', '02-234-5678', '서울시 강남구'),
(102, '박철수', '02-345-6789', '서울시 서초구'),
(103, '최수민', '02-456-7890', '서울시 송파구');

INSERT INTO professor (ProfessorName, Office, PhoneNumber) VALUES
('김명수', '공학관101호', '02-111-2222'),
('이정민', '공학관202호', '02-333-4444'),
('박지훈', '공학관303호', '02-555-6666');

INSERT INTO clubapplication (ClubID, StudentID, ClubName, ProfessorName) VALUES
(1, '101', '음악', '김명수'),
(2, '102', '미술', '이정민'),
(3, '103', '체육', '박지훈');

