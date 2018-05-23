package com.winter.service;

import com.winter.model.ParseRule;
import com.winter.model.PlatformBase;
import com.winter.model.PlatformUser;

import java.util.List;

public interface PlatformUserService {
    List<PlatformUser> selectAll();
    List<PlatformUser> selectAll2();

    PlatformBase getByCode1(String name);
    PlatformBase getByCode2(String name);

    Integer insetPlatformBase1(PlatformBase pb);
    Integer insetPlatformBase2(PlatformBase pb);

    List<ParseRule> getByPid1(Integer id);
    List<ParseRule> getByPid2(Integer id);

    void insetParseRule1(List<ParseRule> pr);
    void insertPlatformUser2(PlatformUser pu);
    void insertPlatformUser1(PlatformUser pu);
    void insetParseRule2(List<ParseRule> pr);

    /**
     * 一、先复制代码
     * 二、表操作，包括正式环境
     * 1.插portalbase
     * 2.插rule
     * 2.插portaluser
     *
     * @param send
     * @return
     */
//    String doSomething(String send) throws IOException;
}