create table account
(
    account_id int auto_increment
        primary key,
    username   varchar(50) null,
    password   varchar(50) null,
    role       varchar(50) null
);

INSERT INTO hmk_manager.account (account_id, username, password, role) VALUES (1, 'teacher', '123456', 'teacher');
INSERT INTO hmk_manager.account (account_id, username, password, role) VALUES (2, '20201619', '123456', 'student');
INSERT INTO hmk_manager.account (account_id, username, password, role) VALUES (4, '20201618', '123456', 'student');
INSERT INTO hmk_manager.account (account_id, username, password, role) VALUES (5, '20201620', '123456', 'student');
