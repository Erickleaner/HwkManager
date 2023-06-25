create table course
(
    course_id  int auto_increment
        primary key,
    name       varchar(50) null,
    serial_num varchar(50) null,
    stu_time   int         null,
    score      int         null,
    semester   varchar(50) null
);

INSERT INTO hmk_manager.course (course_id, name, serial_num, stu_time, score, semester) VALUES (1, '操作系统', '01', 36, 4, '2-up');
INSERT INTO hmk_manager.course (course_id, name, serial_num, stu_time, score, semester) VALUES (2, '数据库原理', '02', 56, 12, '2-up');
INSERT INTO hmk_manager.course (course_id, name, serial_num, stu_time, score, semester) VALUES (9, '计网及其计算', '03', 4, 18, '1-up');
INSERT INTO hmk_manager.course (course_id, name, serial_num, stu_time, score, semester) VALUES (11, '编译原理', '04', 32, 6, '3-up');
