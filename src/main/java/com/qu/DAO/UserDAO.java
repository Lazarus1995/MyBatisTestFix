package com.qu.DAO;


import com.qu.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.InputStream;
import java.util.List;

/**
 * Created by Qu on 2017/6/3.
 */
public class UserDAO {
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try{
            InputStream inputStream= Resources.getResourceAsStream("mybatis_config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

//    static {
//        try {
//            InputStream inputStream = Resources.getResourceAsStream("com/qu/mybatis_config.xml");
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    static{
        try{
            InputStream inputStream=Resources.getResourceAsStream("mybat is_config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        UserDAO userDAO=new UserDAO();
        userDAO.getUserByID(1);
    }
    public void getUserByID(int userID){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserImp userImp=sqlSession.getMapper(UserImp.class);
            User user=userImp.selectUserByID(userID);
            if(user!=null){
                System.out.println(user.getId()+" : "+user.getUsername()+" : "+user.getUseraddress());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    public void getUserList(String username){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserImp userImp=sqlSession.getMapper(UserImp.class);
            List<User> users=userImp.selectUsersByName(username);
            for(User user:users){
                System.out.println(user.getId()+" : "+user.getUserage()+" : "+user.getUseraddress());
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void addUser(){
        User user=new User();
        user.setUsername("test");
        user.setUserage(15);
        user.setUseraddress("changchun");
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserImp userImp=sqlSession.getMapper(UserImp.class);
            userImp.addUser(user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserImp userImp=sqlSession.getMapper(UserImp.class);
            User user=userImp.selectUserByID(1);
            if(user!=null){
                user.setUseraddress("anywhere");
                user.setUserage(213);
                userImp.updateUser(user);
                sqlSession.commit();
            }
        }catch(Exception e){

            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try{
            UserImp userImp=sqlSession.getMapper(UserImp.class);
            User user=userImp.selectUserByID(3);
            userImp.deleteUser(user);
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
