package dao;

import java.util.List;

import model.Course;
import model.PageBean;
import model.Topic;


public interface TopicDao {
    /*
     * ��ӿγ�
     */
    int addTop(Topic topic, String startDate,String enDate);
    /*
     * ɾ���γ�
     */
    int deleteTop(int topicID);
    /*
     * �޸Ŀγ�
     */
    int editTop(Topic topic, String startDate,String enDate);
    /*
     * ��ѯ���пγ�
     */
    List findAll();
    /*
     * ��ѯһ���γ�
     */
    List findOne(int topicID);
    /*
     * ��ѯ�ÿγ��Ƿ����
     */
    Topic selectOneTop(Topic topics);
    /*
     * ��ҳ��ѯ�γ�
     */
    PageBean topicListPage(int pageNo,int pageCount);

}
