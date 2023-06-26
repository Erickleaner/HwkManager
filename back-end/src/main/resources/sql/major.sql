create table major
(
    major_id int auto_increment
        primary key,
    name     varchar(50) null
);

INSERT INTO hmk_manager.major (major_id, name) VALUES (1, '软件工程');
INSERT INTO hmk_manager.major (major_id, name) VALUES (2, '电子信息');
INSERT INTO hmk_manager.major (major_id, name) VALUES (3, '自动化');
