package dao.Impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;

import java.util.ArrayList;
import java.util.List;

import dao.TopicDao;
import model.Course;
import model.PageBean;
import dao.CourseDao;
import db.DBCon;
import model.Topic;

public class TopicDaoImpl implements TopicDao {

    private DBCon dbCon = new DBCon();
    private Topic topic;
    private PageBean pageBean;

    public int addTop(Topic topic, String startDate) {
        System.out.println(startDate);

        String sql = "insert into topic(course_name,topic_name,course_teacher,detail,startdate,endate) values('"
                + topic.getCourseName()
                + "','"
                + topic.getTopicName()
                + "','"
                + topic.getCourseTeacher()
                + "','"
                + topic.getDetail()
                + "','"
                + topic.getStartDate()
                + "','"
                + topic.getEnDate()
                + "')";
        int rs = dbCon.query(sql);
        return rs;
    }

    public int deleteTop(int topicID) {
        String sql = "delete from topic where topic_id=" + topicID;
        int rs = dbCon.query(sql);
        return rs;
    }

    public int editTop(Topic topic, String startDate) {
        String sql = "update topic set topic_name='" + topic.getTopicName()
                + "',course_name=" + topic.getCourseName()
                + "',course_teacher=" + topic.getCourseTeacher()
                + ",detail=" + topic.getDetail()
                + ",endate=" + topic.getEnDate()
                + "',startdate=DATE('" + startDate + "') where topic_id="
                + topic.getTopicID();
        int rs = dbCon.query(sql);
        return rs;
    }

    public List findAll() {
        List<Topic> list = new ArrayList<Topic>();
        String sql = "select * from topic";
        ResultSet rs = dbCon.find(sql);
        try {
            while (rs.next()) {
                int topicID = rs.getInt("topic_id");
                String courseName = rs.getString("course_name");
                String topicName = rs.getString("topic_name");
                String courseTeacher = rs.getString("course_teacher");
                String detail = rs.getString("detail");
                Date startDate = rs.getDate("startdate");
                Date enDate = rs.getDate("endate");
                topic = new Topic(topicID, courseName, topicName, courseTeacher, detail, startDate, enDate);
                list.add(topic);
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }

    public List findOne(int topicID) {
        List<Topic> list = new ArrayList<Topic>();
        String sql = "select * from topic where topic_id=" + topicID;
        ResultSet rs = dbCon.find(sql);
        try {
            while (rs.next()) {
                int topicid = rs.getInt("topic_id");
                String courseName = rs.getString("course_name");
                String topicName = rs.getString("topic_name");
                String courseTeacher = rs.getString("course_teacher");
                String detail = rs.getString("detail");
                Date startDate = rs.getDate("startdate");
                Date enDate = rs.getDate("endate");
                topic = new Topic(topicID, courseName, topicName, courseTeacher, detail, startDate, enDate);
                list.add(topic);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return list;
    }

    public Topic selectOneTop(Topic topics) {
        String sql = "select * from topic where topic_name='"
                + topics.getTopicName() + "' and course_teacher='"
                + topics.getCourseTeacher() + "'";
        ResultSet rs = dbCon.find(sql);
        try {
            while (rs.next()) {
                int topicid = rs.getInt("topic_id");
                String courseName = rs.getString("course_name");
                String topicName = rs.getString("topic_name");
                String courseTeacher = rs.getString("course_teacher");
                String detail = rs.getString("detail");
                Date startDate = rs.getDate("startdate");
                Date enDate = rs.getDate("endate");
                topic = new Topic(topicid, courseName, topicName, courseTeacher, detail, startDate, enDate);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return topic;
    }

    public PageBean topicListPage(int pageNo, int pageCount) {
        int totalCount=0;
        List<Topic> list = new ArrayList<Topic>();
        String sql = "select * from topic limit "+((pageNo-1)*pageCount)+","+pageCount;
        String sqlCount="select count(*) from topic";
        ResultSet rs = dbCon.find(sql);
        try {
            while (rs.next()) {
                int topicID = rs.getInt("topic_id");
                String courseName = rs.getString("course_name");
                String topicName = rs.getString("topic_name");
                String courseTeacher = rs.getString("course_teacher");
                String detail = rs.getString("detail");
                Date startDate = rs.getDate("startdate");
                Date enDate = rs.getDate("endate");
                topic = new Topic(topicID, courseName, topicName, courseTeacher, detail, startDate, enDate);
                list.add(topic);
            }
            rs=dbCon.find(sqlCount);
            while(rs.next()){
                totalCount=rs.getInt(1);
            }
            pageBean=new PageBean(list,totalCount,pageNo,pageCount);

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return pageBean;
    }

}

