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

public class ServletDeleteTopic extends HttpServlet{

    private Topic topic;
    private ServletFindAllTopic servletFindAllTopic=new ServletFindAllTopic();
    private TopicServiceImpl topicServiceImpl=new TopicServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicID = Integer.parseInt(request.getParameter("topicID"));

        int rs=topicServiceImpl.deleteTop(topicID);
        if(rs>0){
            request.setAttribute("msg", "É¾³ý³É¹¦£¡£¡");
            servletFindAllTopic.doGet(request, response);
            //	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
        }else{
            request.setAttribute("msg", "É¾³ýÊ§°Ü£¡£¡");
            servletFindAllTopic.doGet(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
