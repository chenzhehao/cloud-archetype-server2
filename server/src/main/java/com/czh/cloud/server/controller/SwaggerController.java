package com.czh.cloud.server.controller;

import com.czh.cloud.common.controller.RootController;
import com.czh.cloud.common.entity.RootResponse;
import com.czh.cloud.outer.entity.request.SwaggerReq;
import com.czh.cloud.outer.entity.response.SwaggerRep;
import com.czh.cloud.outer.util.SwaggerServiceUtil;
import com.czh.cloud.server.mapper.PDoctorMapper;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhehao.chen
 * @version: V1.0
 * @Description:
 * @date: 2018/9/5 11:16
 */
@RestController
@RequestMapping("/swagger")
@Api(value = "swagger", description = "swagger controller接口样例")
public class SwaggerController extends RootController {

    @Autowired
    PDoctorMapper doctorMapper;

    @ApiOperation(value = "test1测试接口功能描述", response = String.class, notes = "此处描述的返回对象为data内容，外层有code和message")
    @RequestMapping(value = "/v1/test1", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public RootResponse<String> v1GetTest1() {
        return SwaggerServiceUtil.v1GetTest2();
    }

    @ApiOperation(value = "test2测试接口功能描述", response = String.class, notes = "此处描述的返回对象为data内容，外层有code和message")
    @RequestMapping(value = "/v1/test2", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public RootResponse<String> v1GetTest2() {
        RootResponse<String> response = RootResponse.instance();
        response.setData(doctorMapper.selectByPrimaryKey(1384).getName());
        return response;
    }

    @ApiOperation(value = "get接口功能描述", response = SwaggerRep.class, notes = "此处描述的返回对象为data内容，外层有code和message")
    @RequestMapping(value = "/v1/swagger/{type}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public RootResponse<SwaggerRep> v1Get(@ApiParam(name = "token", value = "用户token值", example = "123", required = true) @RequestHeader(value = "token") String token,
                                          @ApiParam(name = "type", value = "类型 ", example = "1", required = true) @PathVariable Integer type,
                                          @ApiParam(name = "resultCheckStatus", value = "请求值", example = "123ds", required = true) @RequestParam String resultCheckStatus,
                                          @ApiParam(name = "swaggerReq", value = "样例对象", required = true) @RequestBody SwaggerReq swaggerReq) {
        return null;
    }

    @ApiOperation(value = "post接口功能描述", response = SwaggerRep.class, notes = "此处描述的返回对象为data内容，外层有code和message")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", dataType = "String", name = "token", value = "用户token值", required = true),
            @ApiImplicitParam(paramType = "path", dataType = "Long", name = "type", value = "类型", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "resultCheckStatus", value = "请求值", required = true)})
    @RequestMapping(value = "/v1/swagger/{type}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public RootResponse<SwaggerRep> v1Post(@RequestHeader(value = "token") String token,
                                           @PathVariable Integer type,
                                           @RequestParam String resultCheckStatus,
                                           @RequestBody SwaggerReq swaggerReq) {
        return null;
    }
}