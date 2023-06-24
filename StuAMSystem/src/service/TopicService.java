package service;

import java.util.List;

import model.Course;
import model.PageBean;
import model.Topic;

public interface TopicService {
    /*
     * 添加课程
     */
    int addTop(Topic topic,String startDate,String enDate);
    /*
     * 删除课程
     */
    int deleteTop(int topicID);
    /*
     * 修改课程
     */
    int editTop(Topic topic,String startDate,String enDate);
    /*
     * 查询所有课程
     */
    List findAll();
    /*
     * 查询一个课程
     */
    List findOne(int topicID);
    /*
     * 查询该课程是否存在
     */
    Topic selectOneTop(Topic topics);
    /*
     * 分页查询课程
     */
    PageBean topicListPage(int pageNo,int pageCount);


}
