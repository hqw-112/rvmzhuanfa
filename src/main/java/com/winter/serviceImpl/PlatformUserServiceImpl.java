package com.winter.serviceImpl;

import com.winter.ds.DS;
import com.winter.mapper.ParseRuleMapper;
import com.winter.mapper.PlatformBaseMapper;
import com.winter.mapper.PlatformUserMapper;
import com.winter.model.ParseRule;
import com.winter.model.PlatformBase;
import com.winter.model.PlatformUser;
import com.winter.service.PlatformUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PlatformUserServiceImpl implements PlatformUserService {
    @Autowired
    PlatformUserMapper platformUserMapper;
    @Autowired
    PlatformBaseMapper platformBaseMapper;
    @Autowired
    ParseRuleMapper parseRuleMapper;

    @Override
    @DS("datasource1")
    public List<PlatformUser> selectAll() {
        return platformUserMapper.selectAll();

    }

    @Override
    @DS("datasource2")
    public List<PlatformUser> selectAll2() {
        return platformUserMapper.selectAll();

    }

    @Override
    @DS("datasource2")
    public PlatformBase getByCode2(String name) {
        return platformBaseMapper.getByCode(name);
    }

    @Override
    @DS("datasource1")
    public PlatformBase getByCode1(String name) {
        return platformBaseMapper.getByCode(name);
    }

    @Override
    @DS("datasource1")
    public Integer insetPlatformBase1(PlatformBase pb) {
        return platformBaseMapper.insert(pb);
    }
    @Override
    @DS("datasource2")
    public Integer insetPlatformBase2(PlatformBase pb) {
        return platformBaseMapper.insert(pb);
    }

    @DS("datasource2")
    @Override
    public List<ParseRule> getByPid2(Integer id) {
        return parseRuleMapper.getByPid(id);
    }
    @DS("datasource1")
    @Override
    public List<ParseRule> getByPid1(Integer id) {
        return parseRuleMapper.getByPid(id);
    }

    @Override
    @DS("datasource1")
    public void insetParseRule1(List<ParseRule> pr) {
        parseRuleMapper.inserts(pr);
    }
    @Override
    @DS("datasource2")
    public void insetParseRule2(List<ParseRule> pr) {
        parseRuleMapper.inserts(pr);
    }

    void createPlatformBase(PlatformBase pb, String name, String ip, String port, String cname) {
        pb.setCode(name);
        pb.setPlatformName(cname);
        pb.setIsValid((byte) 1);
        pb.setSocketIp(ip);
        pb.setSocketPort(Integer.parseInt(port));
    }

    void createPlatformUser(PlatformUser pu, String hostName, String password, String user, int id) {
        pu.setBindHostName(hostName);
        pu.setPassword(password);
        pu.setUserName(user);
        pu.setBaseId(new Long((long) id));
        pu.setIsValid((byte) 1);
        pu.setRowVersion(0);
    }

//    @Override
//    public String doSomething(String send) throws IOException {
//        String[] p = send.split(",");
//        String path = p[0], user = p[1], password = p[2], ip = p[3], port = p[4], name = p[5], cname = p[6], like = p[7];
//        PlatformBase pb = getByCode(name);
//        PlatformBase pbTest = platformBaseMapper.getByCode(name);
//        path = path+"\\src\\main\\java\\com\\zxq\\iov\\cloud\\app\\newrvm\\service\\impl\\";
//
//        File f1 = new File(path+like.toUpperCase()+"AlertServiceImpl.java");
//        File f2 = new File(path+like.toUpperCase()+"InfoServiceImpl.java");
//        File f3 = new File(path+like.toUpperCase()+"ReceiveMessageParseImpl.java");
//        FileCopyUtils.copy(f1,new File(path+name.toUpperCase()+"AlertServiceImpl.java"));
//        FileCopyUtils.copy(f2,new File(path+name.toUpperCase()+"InfoServiceImpl.java"));
//        FileCopyUtils.copy(f3,new File(path+name.toUpperCase()+"ReceiveMessageParseImpl.java"));
//        if (null != pb)
//            return name + " 已存在";
//
//        if (null != pbTest)
//            return name + " 已存在";
//
//
//        PlatformBase opb = getByCode(like);
//        PlatformBase opbTest = platformBaseMapper.getByCode(like);
//        createPlatformBase(opb, name, ip, port, cname);
//        createPlatformBase(opbTest, name, ip, port, cname);
//
//        int id = insetPlatformBase(opb);//1.插PlatformBase
//        int idTest = platformBaseMapper.insert(opbTest);
//
//        Long bidTest = opbTest.getId();
//        Long bid = opb.getId();
//        List<ParseRule> pr = getByPid(Integer.parseInt(bidTest.toString()));
//        List<ParseRule> prTest = parseRuleMapper.getByPid(Integer.parseInt(bid.toString()));
//        prTest.stream().forEach(a -> a.setPlatformBaseId(idTest));
//        pr.stream().forEach(a -> a.setPlatformBaseId(id));
//        insetParseRule(pr);//2.插ParseRule
//        parseRuleMapper.inserts(prTest);
//        PlatformUser pu = new PlatformUser();
//        PlatformUser puTest = new PlatformUser();
//
//        String host = System.getenv("newrvm_platform_host");
//
//        createPlatformUser(pu, name + "-app", password, user, id);
//        createPlatformUser(puTest, host, password, user, idTest);
//        platformUserMapper.insert(puTest);
//        insertPlatformUser(pu);
//        return "ok";
//    }

    @DS("datasource1")
    public void insertPlatformUser1(PlatformUser pu) {
        platformUserMapper.insert(pu);
    }
    @DS("datasource2")
    public void insertPlatformUser2(PlatformUser pu) {
        platformUserMapper.insert(pu);
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(System.getenv());
        FileCopyUtils.copy(new File("C:\\Users\\T460s\\Desktop\\421"),new File("C:\\Users\\T460s\\Desktop\\5555"));
    }
}