create table tc
(
    tc_id      int auto_increment
        primary key,
    teacher_id int null,
    course_id  int null,
    constraint FK_Reference_1
        foreign key (teacher_id) references teacher (teacher_id),
    constraint FK_Reference_2
        foreign key (course_id) references course (course_id)
);

INSERT INTO hmk_manager.tc (tc_id, teacher_id, course_id) VALUES (13, 100, 1);
