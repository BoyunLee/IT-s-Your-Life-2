-- 데이터베이스 생성
CREATE DATABASE ShopDB;
USE ShopDB;

-- Product 테이블 생성
CREATE TABLE Product (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(50),
    Price DECIMAL(10, 2),
    Description VARCHAR(255)
);

-- Member 테이블 생성
CREATE TABLE Member (
    MemberID INT PRIMARY KEY,
    MemberName VARCHAR(50),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20)
);

-- OrderList 테이블 생성
CREATE TABLE OrderList (
    OrderID INT PRIMARY KEY,
    MemberID INT,
    OrderDate DATE,
    FOREIGN KEY (MemberID) REFERENCES Member(MemberID)
);

-- OrderDetails 테이블 생성
CREATE TABLE OrderDetails (
    OrderID INT,
    ProductID INT,
    Quantity INT,
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES OrderList(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);

-- Reply 테이블 생성
CREATE TABLE Reply (
    ReplyID INT PRIMARY KEY,
    BoardID INT,
    MemberID INT,
    ReplyText VARCHAR(255),
    ReplyDate DATE,
    FOREIGN KEY (BoardID) REFERENCES Board(BoardID),
    FOREIGN KEY (MemberID) REFERENCES Member(MemberID)
);

-- Board 테이블 생성
CREATE TABLE Board (
    BoardID INT PRIMARY KEY,
    Title VARCHAR(100),
    Content TEXT,
    MemberID INT,
    PostDate DATE,
    FOREIGN KEY (MemberID) REFERENCES Member(MemberID)
);

-- Product 데이터 삽입
INSERT INTO Product (ProductID, ProductName, Price, Description) VALUES
(1, 'Apple', 100.00, 'Fresh Apple'),
(2, 'Banana', 50.00, 'Yellow Banana');

-- Member 데이터 삽입
INSERT INTO Member (MemberID, MemberName, Email, PhoneNumber) VALUES
(1, 'John Doe', 'john@example.com', '123-456-7890'),
(2, 'Jane Doe', 'jane@example.com', '234-567-8901');

-- OrderList 데이터 삽입
INSERT INTO OrderList (OrderID, MemberID, OrderDate) VALUES
(1, 1, '2023-07-01'),
(2, 2, '2023-07-02');

-- OrderDetails 데이터 삽입
INSERT INTO OrderDetails (OrderID, ProductID, Quantity) VALUES
(1, 1, 10),
(2, 2, 20);

-- Board 데이터 삽입
INSERT INTO Board (BoardID, Title, Content, MemberID, PostDate) VALUES
(1, 'Welcome', 'Hello World', 1, '2023-07-01'),
(2, 'Announcement', 'New Update', 2, '2023-07-02');

-- Reply 데이터 삽입
INSERT INTO Reply (ReplyID, BoardID, MemberID, ReplyText, ReplyDate) VALUES
(1, 1, 1, 'Nice post!', '2023-07-03'),
(2, 1, 2, 'Thank you!', '2023-07-04');

-- 제약조건 조회
SELECT 
    TABLE_NAME,
    COLUMN_NAME,
    CONSTRAINT_NAME,
    REFERENCED_TABLE_NAME,
    REFERENCED_COLUMN_NAME
FROM 
    INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE 
    TABLE_NAME = 'Member';