import com.ah.pojo.Trans;
import com.ah.service.impl.TransServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TransTest {
    @Resource
    private TransServiceImpl transService;

    @Test
    public void test01() {
        Trans trans = new Trans("狗嗨", "球球", 20);
        transService.transMoney(trans);
    }
}
