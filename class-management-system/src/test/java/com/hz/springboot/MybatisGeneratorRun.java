package com.hz.springboot;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan
 * @create 2017/11/17.
 */
public class MybatisGeneratorRun {

    /**
     *
     *   自动生成pojo对象，使用前请确认路径，注意不要覆盖已有Mapper ！！
     *
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        List<String> warnings = new ArrayList<String>();
//        ConfigurationParser cp = new ConfigurationParser(warnings);
//        Configuration config = cp.parseConfiguration(MybatisGeneratorRun.class.getClassLoader().getResourceAsStream("generatorConfigW.xml"));
//
//        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
//
//        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
//        myBatisGenerator.generate(null);
//        for (String string : warnings) {
//            System.out.println(string);
//        }
//    }

}