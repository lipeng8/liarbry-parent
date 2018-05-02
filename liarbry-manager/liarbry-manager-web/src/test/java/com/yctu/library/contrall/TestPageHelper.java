package com.yctu.library.contrall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yctu.liarbry.mapper.YctuLiarbryBooksMapper;
import com.yctu.liarbry.mapper.YctuLiarbryOutMapper;
import com.yctu.liarbry.pojo.YctuLiarbryBooks;
import com.yctu.liarbry.pojo.YctuLiarbryBooksExample;
import com.yctu.liarbry.pojo.YctuLiarbryOut;
import com.yctu.liarbry.pojo.YctuLiarbryOutExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author:LiPeng
 * @Date:2018/4/22--20:04
 */
public class TestPageHelper {
    @Test
    public void testPageHelper(){
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获取mapper代理对象
        YctuLiarbryBooksMapper yctuLiarbryBooksMapper = applicationContext.getBean(YctuLiarbryBooksMapper.class);
        //执行查询 分页
        YctuLiarbryBooksExample example = new YctuLiarbryBooksExample();
        //分页处理
        PageHelper.startPage(1,10);
       List<YctuLiarbryBooks> yctuLiarbryBooksList = yctuLiarbryBooksMapper.selectByExample(example);

       for (YctuLiarbryBooks yctuLiarbryBooks: yctuLiarbryBooksList){
           System.out.println(yctuLiarbryBooks.getBookName());
       }
        PageInfo<YctuLiarbryBooks>  pageInfo = new PageInfo<>(yctuLiarbryBooksList);
        long total = pageInfo.getTotal();
        System.out.println(total);
    }

    @Test
    public void doubleqry(){
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        //从spring容器中获取mapper代理对象
        YctuLiarbryOutMapper mapper = applicationContext.getBean(YctuLiarbryOutMapper.class);
        YctuLiarbryOutExample example = new YctuLiarbryOutExample();
        YctuLiarbryOutExample.Criteria criteria = example.createCriteria();
        criteria.andOutStIdEqualTo(14263223);
        criteria.andBookIdEqualTo(10000001);
        YctuLiarbryOut out = new YctuLiarbryOut();
        out.setOutStaus(0);
         mapper.updateByExample(out,example);

    }
}
