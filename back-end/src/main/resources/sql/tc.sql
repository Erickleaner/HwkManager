create table tc
(
    tc_id      int auto_increment
        primary key,
    teacher_id int null,
    course_id  int null
);

INSERT INTO hmk_manager.tc (tc_id, teacher_id, course_id) VALUES (13, 100, 1);
