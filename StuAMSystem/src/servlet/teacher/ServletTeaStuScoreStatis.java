package servlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.ScoreServiceImpl;
import model.PageBean;
import model.Score;

public class ServletTeaStuScoreStatis extends HttpServlet{

	private Score score;
	private ScoreServiceImpl scoreServiceImpl=new ScoreServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> maps =scoreServiceImpl.selectTeaScoreStatis();
		List<Object> scoreGrades = getListByMap(maps, "stuName");
		List<Object> newList = new ArrayList<Object>();
		for (Object s : scoreGrades) {
			newList.add("'" + s + "'");
		}
		request.setAttribute("stuNameList", newList);
		request.setAttribute("scoreGradeList", getListByMap(maps, "scoreGrade"));
		request.getRequestDispatcher("teacher/stuTeaScoreStatis.jsp").forward(request, response);
	}

	private List<Object> getListByMap(List<Map<String, Object>> maps, String key){
		List<Object> ret = new ArrayList<Object>();
		for (Map<String, Object> map : maps) {
			ret.add(map.get(key));
		}
		return ret;
	}
}
