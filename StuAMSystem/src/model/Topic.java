package model;

import java.util.Date;

public class Topic {
    private int TopicID;
    private String courseName;
    private String topicName;

    private String courseTeacher;
    private String detail;

    private Date startDate;
    private Date enDate;

    public int getTopicID() {
        return TopicID;
    }

    public void setTopicID(int topicID) {
        TopicID = topicID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnDate() {
        return enDate;
    }

    public void setEnDate(Date enDate) {
        this.enDate = enDate;
    }

    public Topic(int topicID, String courseName, String topicName, String courseTeacher, String detail, Date startDate, Date enDate) {
        TopicID = topicID;
        this.courseName = courseName;
        this.topicName = topicName;
        this.courseTeacher = courseTeacher;
        this.detail = detail;
        this.startDate = startDate;
        this.enDate = enDate;
    }

    public Topic() {
        super();
    }

    public Topic(String courseName, String topicName, String courseTeacher, String detail, Date startDate, Date enDate) {
        this.courseName = courseName;
        this.topicName = topicName;
        this.courseTeacher = courseTeacher;
        this.detail = detail;
        this.startDate = startDate;
        this.enDate = enDate;
    }
}
