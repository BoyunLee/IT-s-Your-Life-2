
CREATE TABLE product3 (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    content VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    company VARCHAR(100) NOT NULL,
    img VARCHAR(100) NOT NULL
);

# 2. price 로 내림차순 정렬하여 전체컬럼 검색
SELECT * 
FROM product3
ORDER BY price DESC;

# 3. company 로 오름차순 정렬하여 제품의 이름 , 내용 , 가격
SELECT name, content, price
FROM product3
ORDER BY company;

# 4. company 의 목록을 중복을 제거하여 검색
SELECT DISTINCT company
FROM product3;

# 5. 각 음식을 5 개씩 주문했을 때의 가격을 price5 라고 항목명으로 하여 출력
SELECT id, name, content, price, company, img, price * 5 AS price5
FROM product3;

# 6. price 가 5000 인 제품명과 회사명
SELECT name, company
FROM product3
WHERE price = 5000;

# 8. price가 3000 이상 6000 이하 사이인 제품명과 가격 , 회사명 검색
SELECT name, price, company
FROM product3
WHERE price BETWEEN 3000 AND 6000;

# 9. 회사명이 c100 이 아닌 회사명과 제품명
SELECT name, company
FROM product3
WHERE NOT company = 'c100';

# 10. 회사명이 c100, c200 인 제품명과 가격
SELECT name, price
FROM product3
WHERE company = 'c100' OR 'c200';

# 11.제품명에 4로 끝나는 제품의 전체 정보 검색
SELECT *
FROM product3
WHERE name LIKE '%4';

# 12. 제품내용에 food 를 포함하는 제품의 전체 정보 검색
SELECT *
FROM product3
WHERE content LIKE '%food%';

# 13. price가 5000 원인 제품의 content 를 품절로 수정
UPDATE product3
SET content = '품절'
WHERE price = 5000 ;
SELECT *
FROM product3;

# 14. id가 100 또는 102 번 제품의 img 를 o.png 로 , price 를 10000 으로 수정
UPDATE product3
SET img = 'o.png', price = 10000
WHERE id = 100 OR id = 102;
SELECT *
FROM product3;

# 15. 회사명이 c100 인 경우 모든 정보 삭제
DELETE FROM product3
WHERE company = 'c100';

# 16. 테이블의 모든 정보 삭제
DELETE FROM product3;

# 17. 테이블 삭제
DROP TABLE product3;
