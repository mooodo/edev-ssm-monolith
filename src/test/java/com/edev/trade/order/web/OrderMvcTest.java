package com.edev.trade.order.web;

import com.alibaba.fastjson.JSONObject;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.support.utils.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderMvcTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSaveAndDelete() throws Exception {
        Long id = 1L;
        Order order = new Order(id,10001L,1000100L,5000D,
                DateUtils.getDate("2020-02-28","yyyy-MM-dd"),"create");
        OrderItem orderItem0 = new OrderItem(1L,id,30001L,1L,4000D,4000D);
        order.addOrderItem(orderItem0);
        OrderItem orderItem1 = new OrderItem(2L,id,30004L,2L,958D,1916D);
        order.addOrderItem(orderItem1);
        String json = JSONObject.toJSONStringWithDateFormat(order,"yyyy-MM-dd HH:ss:mm");

        mvc.perform(get("/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/order/create")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        mvc.perform(get("/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
