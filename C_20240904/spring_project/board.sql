create database test_db;
use test_db;


DROP TABLE IF EXISTS  tbl_board;

CREATE TABLE tbl_board (
   no			INTEGER AUTO_INCREMENT PRIMARY KEY,
   title		VARCHAR(200) NOT NULL,
   content		TEXT,
   writer		VARCHAR(50) NOT NULL,
   reg_date		DATETIME DEFAULT CURRENT_TIMESTAMP,
   update_date	DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tbl_board(title, content, writer)
VALUES
    ('테스트 제목1', '테스트 내용1', 'user0'),
    ('테스트 제목2', '테스트 내용2', 'user0'),
    ('테스트 제목3', '테스트 내용3', 'user0'),
    ('테스트 제목4', '테스트 내용4', 'user0'),
    ('테스트 제목5', '테스트 내용5', 'user0');


SELECT * FROM tbl_board;

