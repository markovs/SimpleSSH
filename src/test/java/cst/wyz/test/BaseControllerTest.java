package cst.wyz.test;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
public abstract class BaseControllerTest extends BaseUnitTest {

    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
