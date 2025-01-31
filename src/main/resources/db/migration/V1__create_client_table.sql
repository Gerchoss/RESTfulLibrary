CREATE TABLE clients (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(35) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    created_at timestamp
);