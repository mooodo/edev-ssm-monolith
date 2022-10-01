package com.edev.trade.product.web;

import com.alibaba.fastjson.JSONObject;
import com.edev.trade.product.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductMvcTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testSaveAndDelete() throws Exception {
        Long id = 1L;
        Product product = new Product(id,"BookNode",8000D,"unit","electric");
        String json = JSONObject.toJSONString(product);

        mvc.perform(get("/product/deleteProduct")
                .param("id", id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/product/saveProduct")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/product/getProduct")
                .param("id",id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        product.setImage("/img/NodeBook");
        product.setOriginalPrice(8000D);
        product.setPrice(7500D);
        product.setTip("自营");
        String json1 = JSONObject.toJSONString(product);
        mvc.perform(post("/product/saveProduct")
                .content(json1).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/product/getProduct")
                .param("id",id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json1));

        mvc.perform(get("/product/deleteProduct")
                .param("id",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/product/getProduct")
                .param("id",id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
