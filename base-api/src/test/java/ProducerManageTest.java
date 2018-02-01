import com.momo.BaseApiApplication;
import com.momo.api.ProducerManage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author majunjie
 * @date 2018/2/1 11:08
 */
@SpringBootTest(classes = BaseApiApplication.class)
@RunWith(SpringRunner.class)
public class ProducerManageTest {

    @Autowired
    ProducerManage manage;

    @Test
    public void publishDirect(){
        manage.publishDirect();
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void publishFanout(){
        manage.publishFanout();
        try {
            Thread.sleep(30000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
