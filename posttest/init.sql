-- Drop tables if they exist
DROP TABLE IF EXISTS lottery CASCADE;
DROP TABLE IF EXISTS user_ticket CASCADE;

CREATE TABLE user_ticket (
    user_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) NULL
);


CREATE TABLE lottery (
    id SERIAL PRIMARY KEY,
    ticket VARCHAR(6) UNIQUE NOT NULL,
    price INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    user_id VARCHAR(10) NULL REFERENCES user_ticket(user_id)
);

-- Initial data
INSERT INTO lottery(ticket, price, amount) VALUES('000001', 80, 1);
INSERT INTO lottery(ticket, price, amount) VALUES('000002', 80, 1);
INSERT INTO lottery(ticket, price, amount) VALUES('000003', 80, 1);