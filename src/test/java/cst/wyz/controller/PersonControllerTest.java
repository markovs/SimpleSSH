package cst.wyz.controller;

import com.alibaba.fastjson.JSON;
import cst.wyz.entity.Person;
import cst.wyz.test.BaseControllerTest;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class PersonControllerTest extends BaseControllerTest {

    @Test
    @Transactional
    @Rollback()
    public void add() {
        Person person = new Person("whatever","jerry", 22, "634839");
        //System.out.println(person);
        System.out.println(JSON.toJSONString(person));
        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/person/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(JSON.toJSONString(person))
            ).andExpect(status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void get(){
        String id = "5e94cbe564c201110164c20119ac0000";
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/person/get")
                    .param("id",id)
            ).andExpect(status().isOk())
                    .andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    @Rollback()
    public void delete(){
        String id = "5e94cbe564c204170164c20420680000";
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.delete("/person/delete")
                    .param("id",id)
            ).andExpect(status().isOk()).andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    @Transactional
    public void list(){
        try{
            mockMvc.perform(
                    MockMvcRequestBuilders.get("/person/list")
            ).andExpect(status().isOk()).andDo(print());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
