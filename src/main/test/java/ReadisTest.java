import com.alibaba.fastjson.JSON;
import com.winter.SampleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
@EnableAutoConfiguration
public class ReadisTest {


    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        Map m = new HashMap();
        m.put("3",2);
        redisTemplate.opsForZSet().add("hhhhh", JSON.toJSONString(m),33d);
//        opsForValue.set("redisKey","cluster test");
        System.out.println("11"+  redisTemplate.opsForZSet().range("hhhhh",-1,1));
    }
    @Test
public void test2(){
    System.out.println(redisTemplate.opsForValue().get("hhhhh"));
}
    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties);

    }
}