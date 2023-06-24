package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Topic;
import service.Impl.CourseServiceImpl;

import model.Course;
import dao.Impl.CourseDaoImpl;
import service.Impl.TopicServiceImpl;

public class ServletSelectTopic extends HttpServlet{

    private Topic topic;
    private ServletFindAllTopic servletFindAllTopic=new ServletFindAllTopic();
    private TopicServiceImpl topicServiceImpl=new TopicServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int topicID = Integer.parseInt(request.getParameter("topicID"));

        List rs=topicServiceImpl.findOne(topicID);
        request.setAttribute("list", rs);
        request.getRequestDispatcher("teacher/editTopic.jsp").forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
