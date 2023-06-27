create table hmk_manager.task
(
    task_id    int auto_increment
        primary key,
    name       varchar(50)   null,
    descr     varchar(200)  not null,
    start_time date          not null,
    end_time   date          not null,
    is_publish      int default 0 not null
);
INSERT INTO hmk_manager.task (task_id,name,descr,start_time, end_time,is_publish) VALUES (1,'需求分析','完成酒店管理系统的需求分析','2023-6-12','2023-6-14',1);
INSERT INTO hmk_manager.task (task_id,name,descr,start_time, end_time,is_publish) VALUES (2,'界面设计','完成酒店管理系统的界面设计','2023-6-15','2023-6-18',0);
