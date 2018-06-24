//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import cn.hsu.crud.bean.Employee;
import com.github.pagehelper.PageInfo;
import java.util.Iterator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
    locations = {"classpath:../resources/applicationContext.xml", "classpath:dispatcherServlet-servlet.xml"}
)
public class MvcTest {
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;

    public MvcTest() {
    }

    @Before
    public void initMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testPage() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/emps", new Object[0]).param("pn", new String[]{"1"})).andReturn();
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo)request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pi.getPageNum());
        System.out.println("总页码：" + pi.getPages());
        System.out.println("总记录数：" + pi.getTotal());
        System.out.println("在页面需要连续显示的页数");
        int[] nums = pi.getNavigatepageNums();
        int[] var8 = nums;
        int var7 = nums.length;

        for(int var6 = 0; var6 < var7; ++var6) {
            int i = var8[var6];
            System.out.print(" " + i + " ");
        }

        System.out.println();
        List<Employee> list = pi.getList();
        Iterator var11 = list.iterator();

        while(var11.hasNext()) {
            Employee emp = (Employee)var11.next();
            System.out.println("ID: " + emp.getdId() + "==>Name: " + emp.getEmpName());
        }

    }
}
