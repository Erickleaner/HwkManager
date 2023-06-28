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

INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (1, 1, '王一番', '20201601', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (2, 1, '李华', '20201602', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (3, 1, '张伟', '20201603', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (4, 1, '王潮涛', '20201604', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (5, 1, '赵敏', '20201605', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (6, 1, '陈飞', '20201606', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (7, 1, '李静', '20201607', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (8, 1, '王智康', '20201608', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (9, 1, '刘晨', '20201609', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (10, 1, '孙宇', '20201610', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (11, 1, '张伟', '20201611', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (12, 1, '王浩', '20201612', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (13, 1, '刘莉', '20201613', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (14, 1, '陈明', '20201614', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (15, 1, '杨红', '20201615', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (16, 1, '王磊', '20201616', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (17, 1, '张丽', '20201617', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (18, 1, '赵鑫', '20201618', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (19, 1, '陈晨', '20201619', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (20, 1, '李娜', '20201620', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (21, 1, '王刚', '20201621', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (22, 1, '刘洋', '20201622', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (23, 1, '杨柳', '20201623', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (24, 1, '王明', '20201624', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (25, 1, '张霞', '20201625', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (26, 1, '陈杰', '20201626', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (27, 1, '李峰', '20201627', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (28, 1, '王丽', '20201628', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (29, 1, '刘伟', '20201629', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (30, 1, '杨阳', '20201630', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (31, 1, '王艳', '20201631', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (32, 1, '张华', '20201632', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (50, 2, '陈军', '20201701', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (51, 2, '李芳', '20201702', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (52, 2, '刘伟', '20201703', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (53, 2, '张敏', '20201704', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (54, 2, '王宇', '20201705', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (55, 2, '陈静', '20201706', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (56, 2, '李峰', '20201707', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (57, 2, '王霞', '20201708', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (58, 2, '张阳', '20201709', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (59, 2, '陈娜', '20201710', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (60, 2, '李刚', '20201711', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (61, 2, '王艳', '20201712', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (62, 2, '张华', '20201713', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (63, 2, '刘军', '20201714', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (64, 2, '李霞', '20201715', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (65, 2, '王丽', '20201716', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (66, 2, '陈宇', '20201717', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (67, 2, '李梅', '20201718', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (68, 2, '张磊', '20201719', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (69, 2, '王丹', '20201720', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (70, 2, '陈强', '20201721', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (71, 2, '李婷', '20201722', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (72, 2, '王鑫', '20201723', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (73, 2, '张勇', '20201724', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (74, 2, '刘琳', '20201725', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (75, 2, '陈杰', '20201726', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (76, 2, '李飞', '20201727', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (77, 2, '王萍', '20201728', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (78, 2, '张涛', '20201729', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (79, 2, '陈明', '20201730', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (80, 2, '杨丽', '20201731', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (81, 2, '王阳', '20201732', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (82, 2, '张刚', '20201733', 3, '18534907896');
INSERT INTO hmk_manager.student (student_id, clazz_id, name, no, grade, phone) VALUES (83, 2, '刘艳', '20201734', 3, '18534907896');
