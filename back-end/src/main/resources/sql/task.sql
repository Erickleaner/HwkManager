create table task
(
    task_id     int auto_increment
        primary key,
    name        varchar(50)   null,
    detail      varchar(100)  null,
    start_time  date          null,
    end_time    date          null,
    homework_id int           null,
    publish     int default 0 null
);

INSERT INTO hmk_manager.task (task_id, name, detail, start_time, end_time, homework_id, publish) VALUES (1, '任务01', '这是一个任务', '2023-06-23', '2023-06-24', 7, 1);
