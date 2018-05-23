package com.winter.controller;

import com.winter.model.ParseRule;
import com.winter.model.PlatformBase;
import com.winter.model.PlatformUser;
import com.winter.service.PlatformUserService;
import com.winter.utils.ModifyContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/platform")
public class PlatformUserController {
    private static final Logger log = LoggerFactory.getLogger(PlatformUserController.class);
    @Autowired
    PlatformUserService platformUserService;


    @ResponseBody
    @RequestMapping(value = "/selectAll", produces = {"application/json;charset=UTF-8"})
    public List<PlatformUser> selectAll() {
        List<PlatformUser> platformUsers = platformUserService.selectAll();
        System.out.println(platformUserService.selectAll2().size());
        System.out.println(platformUsers.size());
        return platformUsers;
    }

    /**
     * 1.sj
     *
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "send")
    public String send(HttpServletRequest request) {
        log.info("参数：" + request.getParameter("send"));
        System.out.println(request.getParameter("send"));
        String s = null;
        try {
            String[] p = request.getParameter("send").split(",");
            String path = p[0], user = p[1], password = p[2], ip = p[3], port = p[4], name = p[5], cname = p[6], like = p[7];
            PlatformBase pbTest = platformUserService.getByCode1(name);
            PlatformBase pb = platformUserService.getByCode2(name);
            if (path.contains("src"))
                path = path.split("src")[0];

            path = path + "\\src\\main\\java\\com\\zxq\\iov\\cloud\\app\\newrvm\\service\\impl\\";

            log.info("完整path：" + path);
            File f1 = new File(path + like.toUpperCase() + "AlertServiceImpl.java");
            File f2 = new File(path + like.toUpperCase() + "InfoServiceImpl.java");
            File f3 = new File(path + like.toUpperCase() + "ReceiveMessageParseImpl.java");
            FileCopyUtils.copy(f1, new File(path + name.toUpperCase() + "AlertServiceImpl.java"));
            FileCopyUtils.copy(f2, new File(path + name.toUpperCase() + "InfoServiceImpl.java"));
            FileCopyUtils.copy(f3, new File(path + name.toUpperCase() + "ReceiveMessageParseImpl.java"));
            ModifyContent.modifyFileContent(path + name.toUpperCase() + "AlertServiceImpl.java", like.toUpperCase() + "AlertServiceImpl", name.toUpperCase() + "AlertServiceImpl");
            ModifyContent.modifyFileContent(path + name.toUpperCase() + "InfoServiceImpl.java", like.toUpperCase() + "InfoServiceImpl", name.toUpperCase() + "InfoServiceImpl");
            ModifyContent.modifyFileContent(path + name.toUpperCase() + "ReceiveMessageParseImpl.java", like.toUpperCase() + "ReceiveMessageParseImpl", name.toUpperCase() + "ReceiveMessageParseImpl");

            log.info("保存成功文件名：" + name.toUpperCase() + "AlertServiceImpl.java->" + name.toUpperCase() + "AlertServiceImpl.java->", name.toUpperCase() + "ReceiveMessageParseImpl.java");
            if (null != pb)
                return name + " 已存在";

            if (null != pbTest)
                return name + " 已存在";


            PlatformBase opbTest = platformUserService.getByCode1(like);
            PlatformBase opb = platformUserService.getByCode2(like);
            createPlatformBase(opb, name, ip, port, cname);
            createPlatformBase(opbTest, name, ip, port, cname);

            Long bidTest = opbTest.getId();
            Long bid = opb.getId();

            platformUserService.insetPlatformBase1(opbTest);//1.插PlatformBase
            platformUserService.insetPlatformBase2(opb);
            int newbidTest = Integer.parseInt(opbTest.getId().toString());
            int newbid = Integer.parseInt(opb.getId().toString());
            log.info("PlatformBase插入成功：dev id = " + newbidTest + " prd id = " + newbid);

            List<ParseRule> prTest = platformUserService.getByPid1(Integer.parseInt(bidTest.toString()));
            List<ParseRule> pr = platformUserService.getByPid2(Integer.parseInt(bid.toString()));
            pr.stream().forEach(a -> a.setPlatformBaseId(newbid));
            prTest.stream().forEach(a -> a.setPlatformBaseId(newbidTest));
            platformUserService.insetParseRule1(prTest);//2.插ParseRule
            platformUserService.insetParseRule2(pr);
            PlatformUser pu = new PlatformUser();
            PlatformUser puTest = new PlatformUser();
            log.info("-------ParseRule插入成功-----");
            String host = System.getenv("newrvm_platform_host");

            createPlatformUser(pu, name + "-app", password, user, newbid);
            createPlatformUser(puTest, host, password, user, newbidTest);
            platformUserService.insertPlatformUser2(pu);
            platformUserService.insertPlatformUser1(puTest);
            log.info("-------PlatformUser插入成功-----");
            return "ok";
        } catch (IOException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            s = "failed";
        }

        return s;
    }

    private void createPlatformBase(PlatformBase pb, String name, String ip, String port, String cname) {
        pb.setCode(name);
        pb.setPlatformName(cname);
        pb.setIsValid((byte) 1);
        pb.setSocketIp(ip);
        pb.setSocketPort(Integer.parseInt(port));
    }

    private void createPlatformUser(PlatformUser pu, String hostName, String password, String user, int id) {
        pu.setBindHostName(hostName);
        pu.setPassword(password);
        pu.setUserName(user);
        pu.setBaseId(new Long((long) id));
        pu.setIsValid((byte) 1);
        pu.setPlatformSn(1l);
        pu.setRowVersion(0);
    }


    public static void main(String[] args) {

        String s = "E:ff\\src\\main\\java\\com\\";
        System.out.println(s.split("src")[0]);
    }
}