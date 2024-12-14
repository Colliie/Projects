// Books
INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('Spring in Action', 'Craig Walls', '1234567890', 2018, 5);

INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('Saving America', 'Doug Towns', '3456789124', 2013, 3);

INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('A Blast Into Space', 'Leon Sharp', '3498735619', 2011, 6);

INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('Taking The Fall', 'Moby Felter', '2368901230', 2001, 2);

INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('A Ride Threw History', 'Dean Maxell', '1253795323', 2023, 3);

INSERT INTO book (title, author, isbn, published_year, copies_available)
VALUES ('Spring in Action', 'Craig Walls', '1234567890', 2018, 5);

// Members
INSERT INTO member (name, email, membership_date)
VALUES ('Jane Doe', 'john.Doe@example.com', '2020-01-01');

INSERT INTO member (name, email, membership_date)
VALUES ('Jane Woe', 'jane.woe@example.com', '2022-10-05');

INSERT INTO member (name, email, membership_date)
VALUES ('Alex Hunzs', 'Alex.hunz@example.com', '2018-09-15');

INSERT INTO member (name, email, membership_date)
VALUES ('Ed Dunz', 'Ed.dunz@example.com', '2015-04-07');

// Loans
INSERT INTO loan (loan_date, return_date, book_id, member_id, status)
VALUES ('2018-04-09', '2018-07-11', '1', '1', 'RETURNED');

INSERT INTO loan (loan_date, return_date, book_id, member_id, status)
VALUES ('2020-06-02', '2020-08-9', '2', '2', 'AWAY');

INSERT INTO loan (loan_date, return_date, book_id, member_id, status)
VALUES ('2021-02-21', '2021-11-05', '3', '3', 'RETURNED');