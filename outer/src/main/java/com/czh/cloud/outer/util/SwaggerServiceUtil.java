package com.czh.cloud.outer.util;

import com.czh.cloud.common.entity.RootException;
import com.czh.cloud.common.entity.RootResponse;
import com.czh.cloud.common.entity.RootResultCode;
import com.czh.cloud.outer.service.ISwaggerServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zhehao.chen
 * @version: V1.0
 * @Description:
 * @date: 2018/8/17 14:31
 */
@Component
public class SwaggerServiceUtil {
    public static final Logger logger = LoggerFactory.getLogger(SwaggerServiceUtil.class);

    private static ISwaggerServiceClient swaggerServiceClient;

    @Autowired
    public SwaggerServiceUtil(ISwaggerServiceClient swaggerServiceClient) {
        SwaggerServiceUtil.swaggerServiceClient = swaggerServiceClient;
    }

    public static RootResponse<String> v1GetTest2() {
        RootResponse<String> response;
        try {
            logger.info("调用swagger访问外部系统get params：");
            response = swaggerServiceClient.v1GetTest2();
            logger.info("调用swagger访问外部系统get response：" + response);
        } catch (Exception e) {
            throw new RootException(RootResultCode.SYSTEM_INNER_BUSY.code(), e.getMessage());
        }
        if (!RootResultCode.SUCCESS.code().equals(response.getCode())) {
            throw new RootException(response.getCode(), response.getMessage());
        }
        return response;

    }
}
