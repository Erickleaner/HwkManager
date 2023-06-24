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

import dao.Impl.CourseDaoImpl;

import model.Course;
import model.Student;
import model.User;
import service.Impl.TopicServiceImpl;

public class ServletAddTopic extends HttpServlet{

    private Topic topic;
    private ServletFindAllTopic servletFindAllTopic=new ServletFindAllTopic();
    private TopicServiceImpl topicServiceImpl=new TopicServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        topic=new Topic(courseName, topicName, courseTea, detail, startDate, enDate);
        //��֤�Ƿ���ڸý�ʦ�γ�
        Topic top=topicServiceImpl.selectOneTop(topic);
        if(top==null){
            int rs=topicServiceImpl.addTop(topic,start1Date,en1Date);
            if(rs>0){
                request.setAttribute("msg", "��ӳɹ�����");
                servletFindAllTopic.doGet(request, response);
                //	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
            }else{
                request.setAttribute("msg", "���ʧ�ܣ���");
                request.getRequestDispatcher("teacher/addTopic.jsp").forward(request, response);
            }
        }else{
            request.setAttribute("msg", "�ÿγ���¼�룬���������룡��");
            request.getRequestDispatcher("teacher/addTopic.jsp").forward(request, response);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
