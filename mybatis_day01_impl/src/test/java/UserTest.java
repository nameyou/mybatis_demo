import com.lee.demo.dao.UserDao;
import com.lee.demo.dao.impl.UserImplDao;
import com.lee.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class UserTest {
    @Test
    public void testFindAll() throws IOException {
        //1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //2. 创建SqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 5. 创建UserDao的代理对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 6. 执行查询
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 7. 释放链接
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testImpl() throws IOException {
        //1.读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3. 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        // 4. 创建SqlSession对象
        UserDao userDao = new UserImplDao(sqlSession);
        //5. 执行查询
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //6. 释放资源
        sqlSession.close();
        inputStream.close();
    }

}
