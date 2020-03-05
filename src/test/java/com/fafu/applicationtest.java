package com.fafu;

import com.fafu.Service.NewService;
import com.fafu.domain.news.News;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class applicationtest {
    @Autowired
    private NewService newService;
    @Test
    public void text(){
//        News news = new News(1,"xxx","xxx","xxx",new Date(),new Date(),"xxx","xxx","xxx","xxx",1);
//        newService.update(news);
    }
}
