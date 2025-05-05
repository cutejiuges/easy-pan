package com.easy_pan.back.biz.service;

import com.cutejiuge.base.BaseResp;

public interface BackService {
    void checkParams(Object req) throws Exception;
    void checkPermission(Object req) throws Exception;
    void packResponse(Exception e, BaseResp baseResp);
    Object Process(Object req) throws Exception;
}
