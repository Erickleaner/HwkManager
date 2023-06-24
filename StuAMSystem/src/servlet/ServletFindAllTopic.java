package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.CourseServiceImpl;

import dao.Impl.CourseDaoImpl;

import model.Course;
import model.PageBean;
import service.Impl.TopicServiceImpl;

public class ServletFindAllTopic extends HttpServlet{


    private TopicServiceImpl topicServiceImpl=new TopicServiceImpl();

    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        int pageNo=1;
        int pageCount=10;

        String pageNoStr=request.getParameter("pageNo");
        String pageCountStr=request.getParameter("pageCount");
        if(pageNoStr!=null){
            pageNo=Integer.parseInt(pageNoStr);
        }
        if(pageCountStr!=null){
            pageCount=Integer.parseInt(pageCountStr);
        }

        PageBean list=topicServiceImpl.topicListPage(pageNo, pageCount);
        request.setAttribute("list", list);
        request.getRequestDispatcher("teacher/topicAllInfo.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        doGet(request,response);
    }

}
