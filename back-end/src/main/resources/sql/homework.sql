create table homework
(
    homework_id int auto_increment
        primary key,
    ctc_id      int           null,
    start_time  date          null,
    end_time    date          null,
    name        varchar(50)   null,
    detail      varchar(100)  null,
    publish     int default 0 null,
    constraint FK_Reference_7
        foreign key (ctc_id) references ctc (ctc_id)
);

INSERT INTO hmk_manager.homework (homework_id, ctc_id, start_time, end_time, name, detail, publish) VALUES (7, 6, '2023-06-22', '2023-06-27', '多线程程序设计', '设计实现一个简易的多线程课设', 1);
