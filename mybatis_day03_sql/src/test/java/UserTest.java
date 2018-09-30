import com.lee.demo.bean.QueryVO;
import com.lee.demo.bean.User;
import com.lee.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserTest {


    private SqlSessionFactory sqlSessionFactory;
    private InputStream inputStream;
    private SqlSession sqlSession;

    @Before //就是在执行@Test方法之前执行
    public void init() throws Exception {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建sqlSessoinFactory对象
        sqlSessionFactory = builder.build(inputStream);
    }

    @After //执行@Test方法之后执行
    public void destory() throws Exception {
        // 7. 释放资源
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindAll() throws IOException {
        //4. 创建SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 5.执行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 6. 处理结果
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testSave() throws Exception {
//        sqlSession = sqlSessionFactory.openSession();
        sqlSession = sqlSessionFactory.openSession(true);//设置自动提交事务
        // 5.执行查询
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 6. 处理结果
        User user = new User();
        user.setUsername("张三丰");
        user.setAddress("武当山");
        user.setBirthday(new Date());
        user.setSex("男");
        System.out.println(user);
        mapper.saveUser(user);
        //返回主键
        System.out.println(user);
        //提交事务
        sqlSession.commit();
    }


    @Test
    public void testUpdate() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setSex("女");
        user.setUsername("小花");
        user.setAddress("花果山");
        user.setBirthday(new Date());
        mapper.updateUser(user);
        sqlSession.commit();
    }


    @Test
    public void deleteUser() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(16);
        sqlSession.commit();
    }

    @Test
    public void testFindOne() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findOne(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByUsername() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> username = mapper.findUserByUsername("%张%");
//        List<User> username = mapper.findUserByUsername("张");
        QueryVO queryVO = new QueryVO();
        User user = new User();
        user.setUsername("张");
        queryVO.setUser(user);
        List<User> queryVo = mapper.getUserByQueryVo(queryVO);
        for (User u : queryVo) {
            System.out.println(u);
        }
    }

    @Test
    public void testTotal() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer total = mapper.findTotal();
        System.out.println("总记录数=" + total);
    }

    @Test
    public void testSQL() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setUsername("张");
        user.setAddress("武当");
        List<User> userByEXample = mapper.getUserByEXample(user);
        System.out.println(userByEXample);
    }

    /**
     * 测试集合
     */
    @Test
    public void testSQL1() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList();
        ids.add(30);
        ids.add(31);
        ids.add(32);
        List<User> userList = mapper.getUserByIds(ids);
        System.out.println(userList);
    }

    /**
     * 测试包装对象中传递参数
     */
    @Test
    public void testSQL2() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        QueryVO queryVO = new QueryVO();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(32);
        ids.add(36);
        queryVO.setIds(ids);
        List<User> userList = mapper.getUserByQueryVOIds(queryVO);
        System.out.println(userList);

    }

    public static void main(String[] args) {
        int i = 9;
        long l = 2;   // 小long是基本数据类型
        System.out.println(l);
        Long o = 3L;  // 大Long是引用数据类型
        Byte b = 9;
        byte y = 0;

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));
        System.out.println(Calendar.DAY_OF_WEEK);
    }
}
