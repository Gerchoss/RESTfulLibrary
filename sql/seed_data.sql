INSERT INTO category (category_name)
VALUES
('Fiction'),
('Non-Fiction'),
('Science Fiction'),
('Fantasy'),
('Romance'),
('Biography');

INSERT INTO book (isbn, title, author, pages, category_id, created_at)
VALUES
('978-1-56619-9', 'The Great Adventure', 'John Doe', 250, 1, CURRENT_TIMESTAMP),
('978-1-23456-7', 'Introduction to Science', 'Jane Smith', 300, 2, CURRENT_TIMESTAMP),
('978-0-12-3456', 'The Stars Beyond', 'Alice Brown', 400, 3, CURRENT_TIMESTAMP),
('978-0-12-4567', 'The Fantasy Realm', 'Tom White', 500, 4, CURRENT_TIMESTAMP),
('978-0-12-5678', 'Life Story', 'Eve Black', 200, 5, CURRENT_TIMESTAMP),
('978-1-11111-1', 'The Secret Code', 'Michael Green', 350, 1, CURRENT_TIMESTAMP),
('978-1-22222-2', 'World of Wonders', 'Emma Blue', 280, 2, CURRENT_TIMESTAMP),
('978-1-33333-3', 'Galactic Wars', 'Bob Red', 450, 3, CURRENT_TIMESTAMP),
('978-1-44444-4', 'Elves and Dragons', 'Nina Gold', 600, 4, CURRENT_TIMESTAMP),
('978-1-55555-5', 'Memoirs of a Soldier', 'Chris Gray', 150, 5, CURRENT_TIMESTAMP),
('978-1-66666-6', 'The Dark Forest', 'Olivia White', 290, 1, CURRENT_TIMESTAMP),
('978-1-77777-7', 'The History of Earth', 'Liam Black', 320, 2, CURRENT_TIMESTAMP),
('978-1-88888-8', 'Exploring Mars', 'Sophia Blue', 430, 3, CURRENT_TIMESTAMP),
('978-1-99999-9', 'Wizards and Magic', 'James Green', 550, 4, CURRENT_TIMESTAMP),
('978-0-11-2223', 'The Soldiers Journey', 'Grace Red', 200, 5, CURRENT_TIMESTAMP);

INSERT INTO client (client_name, password, email, created_at)
VALUES
('Carlos', 'password123', 'alice@example.com', CURRENT_TIMESTAMP),
('Charly', 'password456', 'bob@example.com', CURRENT_TIMESTAMP),
('Richard', 'password789', 'charlie@example.com', CURRENT_TIMESTAMP),
('Albert', 'password101', 'diana@example.com', CURRENT_TIMESTAMP),
('Robert', 'password1212', 'olivia@example.com', CURRENT_TIMESTAMP);


INSERT INTO library (book_id, client_id, created_at, rental_value, rental_expiration, deleted)
VALUES
(1, 1, CURRENT_TIMESTAMP, 5.00, '2025-02-28', false),
(2, 2, CURRENT_TIMESTAMP, 6.00, '2025-03-10', false);