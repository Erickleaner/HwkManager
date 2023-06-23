package service.Impl;

import java.util.List;

import dao.Impl.CourseDaoImpl;

import dao.Impl.TopicDaoImpl;
import model.Course;
import model.PageBean;
import model.Topic;
import service.CourseService;
import service.TopicService;

public class TopicServiceImpl implements TopicService {

    private TopicDaoImpl topicDaoImpl=new TopicDaoImpl();

    public int addTop(Topic topic, String startDate,String enDate) {

        int rs=topicDaoImpl.addTop(topic,startDate,enDate);
        return rs;
    }

    public int deleteTop(int topicID) {

        int rs = topicDaoImpl.deleteTop(topicID);
        return rs;
    }

    public int editTop(Topic topic, String startDate,String enDate) {

        int rs=topicDaoImpl.editTop(topic,startDate,enDate);
        return rs;
    }

    public List findAll() {

        List rs=topicDaoImpl.findAll();
        return rs;
    }

    public List findOne(int topicID) {

        List rs=topicDaoImpl.findOne(topicID);
        return rs;
    }

    public Topic selectOneTop(Topic topics) {

        Topic rs=topicDaoImpl.selectOneTop(topics);
        return rs;
    }

    public PageBean topicListPage(int pageNo, int pageCount) {

        PageBean rs=topicDaoImpl.topicListPage(pageNo, pageCount);
        return rs;
    }

}
