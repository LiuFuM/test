//package com.chinamobile.iot.xiaoyan.bgapi;
//
//import com.chinamobile.iot.xiaoyan.bgapi.entity.ResourceAddress;
//import com.chinamobile.iot.xiaoyan.bgapi.mapper.ResourceAddressMapper;
//import com.chinamobile.iot.xiaoyan.bgapi.service.impl.ResourceAddressServiceImpl;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ResourceMapperTester {
//
//    @Resource
//    ResourceAddressServiceImpl resourceAddressService;
//
//    @Test
//    public void testListAll() {
//        List<ResourceAddress> resourceAddress = resourceAddressService.listAll();
//        System.out.println(resourceAddress);
//        Assert.assertNotNull(resourceAddress.size());
//    }
//
//    @Test
//    public void testDelete() {
//        int result = resourceAddressService.removeResourceAddressById("1");
//        Assert.assertEquals(1, result);
//    }
//
//    @Test
//    public void testAdd() {
//        ResourceAddress resourceAddress = new ResourceAddress();
//
//        for (int i = 0; i < 100; i++) {
//            resourceAddress.setAddress("fdsafadsfasd" + i);
//            resourceAddress.setTargetId("" + i % 10);
//            resourceAddress.setDescription("pic" + i);
//            resourceAddressService.addResourceAddress(resourceAddress);
//        }
//        List<ResourceAddress> resourceAddressList = resourceAddressService.listAll();
//        System.out.println(resourceAddressList);
//
//    }
//}
