create table teacher
(
    teacher_id int         not null
        primary key,
    name       varchar(50) null,
    power      varchar(50) null
);

INSERT INTO hmk_manager.teacher (teacher_id, name, power) VALUES (100, '张三', 'special');
INSERT INTO hmk_manager.teacher (teacher_id, name, power) VALUES (101, '李四', 'normal');
