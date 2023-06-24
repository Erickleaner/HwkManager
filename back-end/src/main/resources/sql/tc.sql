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

