package com.chuxin.study;

import com.chuxin.study.model.StudyApplication;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudyApplication.class)
public  abstract class WebControllerTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    public void buildGetRequest(String url, String params) throws Exception {
        System.out.println("请求参数体为:" + params);
        MvcResult body = mockMvc.perform(MockMvcRequestBuilders.get(url).param("body", params))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println("响应返回体为:"+ body.getResponse().getContentAsString());

    }
}
