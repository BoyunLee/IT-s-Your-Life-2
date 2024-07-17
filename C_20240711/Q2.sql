CREATE TABLE productOrder (
    id VARCHAR(100) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    price INT,
    buydate DATE NOT NULL,
    addr VARCHAR(200) NOT NULL DEFAULT 'home'
);

INSERT INTO productOrder (id, title, price, buydate, addr) VALUES
('100', 'hat', 1000, NOW(), 'office'),
('200', 'mouse', 2000, NOW(), 'home'),
('300', 'pen', NULL, NOW(), 'home');

SELECT * FROM productOrder;
