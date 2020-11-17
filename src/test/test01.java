import com.ah.pojo.User;
import com.ah.service.UserService;
import com.ah.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class test01 {
    @Resource
    private UserService userService;

    @Test
    public void test01() {
        List<User> all = userService.findAll();
        for (User user : all
        ) {
            System.out.println("user = " + user);
        }
    }
}
