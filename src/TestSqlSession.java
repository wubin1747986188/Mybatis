import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wubin on 2019/5/8.
 * 演示
 */
public class TestSqlSession {
    public static void main(String[] args) {
        //第一步需要进行获取mybatis-config.xml的字节输入流InputStream

        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

            System.out.println(in);
            //2.通过SqlSessionFactoryBuilder对象读取这个配置文件，这个SqlSessionFactoryBuilder只是一个工具帮助我们来构建出SqlSessionFactory工厂对象
             //SqlSessionFactory对象，相当于jdbc中的连接池
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            System.out.println(sqlSessionFactory);
            //3.通过SqlSessionFactory对象来构建出Sqlsession对象
            //相当于jdbc中的连接
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
