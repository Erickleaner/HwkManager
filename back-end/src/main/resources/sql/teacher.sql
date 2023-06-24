create table teacher
(
    teacher_id int         not null
        primary key,
    name       varchar(50) null
);

INSERT INTO hmk_manager.teacher (teacher_id, name) VALUES (1, '张三');
