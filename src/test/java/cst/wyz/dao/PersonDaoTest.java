package cst.wyz.dao;


import cst.wyz.entity.Person;
import cst.wyz.service.PersonService;
import cst.wyz.test.BaseUnitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class PersonDaoTest extends BaseUnitTest {

    @Autowired
    private PersonService personService;

    @Test
    @Transactional
    @Rollback(false)
    public void addTest(){
        System.out.println("添加用户测试：");
        Person person = new Person("zhu",22,"18270884839");
        try {
            personService.add(person);
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

    /**
     * 空的用户类型
     */
    @Test
    @Transactional
    public void addTestError(){

        try{
            personService.add(null);
            assert false;
        }catch (Exception e){
            assert true;
            e.printStackTrace();
        }

    }

    @Test
    @Transactional
    @Rollback(false)
    public void listTest(){
        System.out.println("查找用户测试：");
        List<Person> persons = personService.list();
        for (Person person: persons) {
            System.out.println(person);
        }
    }


    @Test
    @Transactional
    public void getTest(){
        String id = "5e94cbe564c140210164c14025420000";
        Person person = personService.getById(id);
        System.out.println(person);
    }

    /**
     * 错误或者不存在的 id 号
     */

    @Test
    @Transactional
    public void getTestError(){
         String  id = "error";
         Person person = personService.getById(id);
         System.out.println(person);
    }

}
