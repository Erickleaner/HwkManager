TRUNCATE TABLE tc;
create table tc
(
    tc_id      int auto_increment
        primary key,
    teacher_id int null,
    courseId   int null,
    constraint FK_Reference_1
        foreign key (teacher_id) references teacher (teacher_id),
    constraint FK_Reference_2
        foreign key (courseId) references course (course_id)
);

INSERT INTO hmk_manager.tc (tc_id, teacher_id, course_id) VALUES (1, 1, 4);
INSERT INTO hmk_manager.tc (tc_id, teacher_id, course_id) VALUES (2, 1, 2);
INSERT INTO hmk_manager.tc (tc_id, teacher_id, course_id) VALUES (3, 1, 3);
