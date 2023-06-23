package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Topic;
import service.Impl.CourseServiceImpl;

import model.Course;
import dao.Impl.CourseDaoImpl;
import service.Impl.TopicServiceImpl;

public class ServletEditTopic extends HttpServlet{

    private Topic topic;
    private ServletFindAllTopic servletFindAllTopic=new ServletFindAllTopic();
    private ServletSelectTopic selectOne=new ServletSelectTopic();
    private TopicServiceImpl topicServiceImpl=new TopicServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicID=Integer.parseInt(request.getParameter("topicID"));
        String courseName = request.getParameter("courseName");
        String topicName = request.getParameter("topicName");
        String courseTea = request.getParameter("courseTea");
        String detail = request.getParameter("detail");
        String start1Date = request.getParameter("startDate");
        String en1Date = request.getParameter("enDate");
        Date startDate = null;
        Date enDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("startDate"));
            enDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("enDate"));
        } catch (ParseException e) {

            e.printStackTrace();
        }

        topic=new Topic(topicID, courseName, topicName, courseTea, detail, startDate, enDate);
        int rs=topicServiceImpl.editTop(topic,start1Date,en1Date);
        if(rs>0){
            request.setAttribute("msg", "修改成功！！");
            servletFindAllTopic.doGet(request, response);
            //	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
        }else{
            request.setAttribute("msg", "修改失败！！");
            selectOne.doGet(request, response);
            //request.getRequestDispatcher("admin/editCourse.jsp").forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
