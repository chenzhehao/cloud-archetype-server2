package com.czh.cloud.archetype.outer.service;

import com.czh.cloud.common.entity.RootResponse;
import com.czh.cloud.archetype.outer.service.impl.SwaggerServiceFailFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: zhehao.chen
 * @version: V1.0
 * @Description:
 * @date: 2018/8/9 13:15
 */
@FeignClient(value = "10030-czh-archetype2", fallbackFactory = SwaggerServiceFailFactory.class)
@RequestMapping(value = "/archetype2", headers = "[sysCode=22,token=123]", produces = "application/json;charset=UTF-8")
public interface ISwaggerServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/swagger/v1/test2")
    RootResponse<String> v1GetTest2();
}
