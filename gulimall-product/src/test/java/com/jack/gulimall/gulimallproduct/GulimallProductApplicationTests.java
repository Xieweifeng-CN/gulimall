package com.jack.gulimall.gulimallproduct;

import com.jack.gulimall.product.entity.BrandEntity;
import com.jack.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brand = new BrandEntity();
        brand.setDescript("中华有为");
        brand.setName("华为");
        brandService.save(brand);
        System.out.println("新增成功");
    }

}
