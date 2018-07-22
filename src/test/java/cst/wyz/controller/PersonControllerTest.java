package cst.wyz.controller;

import com.alibaba.fastjson.JSON;
import cst.wyz.entity.Person;
import cst.wyz.test.BaseControllerTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;


public class PersonControllerTest extends BaseControllerTest {

    @Test
    @Transactional
    @Rollback(false)
    public void add() {
        Person person = new Person("jerry", 22, "634839");
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/person/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(JSON.toJSONString(person))
            ).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
