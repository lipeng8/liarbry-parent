import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/20--20:16
 */
public class test {
    @Test
    public void time(){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");//可以方便地修改日期格式

        String time = dateFormat.format( now );
        System.out.println(time);
    }
    @Test
    public void list(){
        List  list = new ArrayList();
        System.out.println(list.size());
    }
}
