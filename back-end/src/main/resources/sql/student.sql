create table student
(
    student_id int         not null
        primary key,
    clazz_id   int         null,
    name       varchar(50) null,
    no         varchar(50) null,
    grade      int         null,
    phone      varchar(50) null,
    constraint FK_Reference_3
        foreign key (clazz_id) references clazz (clazz_id)
);

INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (2, 1, '王一番', '20201619', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (4, 1, '王潮涛', '20201618', 3, '19170386871');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (5, 1, '王智康', '20201620', 3, '19170386871');
