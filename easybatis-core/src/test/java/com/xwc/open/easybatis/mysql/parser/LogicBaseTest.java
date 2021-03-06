package com.xwc.open.easybatis.mysql.parser;

import com.xwc.open.easybatis.core.AnnotationAssistant;
import com.xwc.open.easybatis.core.EasybatisConfiguration;
import com.xwc.open.easybatis.core.commons.Reflection;
import com.xwc.open.easybatis.core.model.MethodMeta;
import com.xwc.open.easybatis.core.model.TableMeta;
import com.xwc.open.easybatis.mysql.parser.logic.LogicBaseMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * 作者：徐卫超 cc
 * 时间：2020/12/18
 * 描述：mysql单元测试
 */
public class LogicBaseTest {


    SqlSessionFactory sqlSessionFactory;
    Configuration configuration;
    EasybatisConfiguration easybatisConfiguration;
    TableMeta tableMeta;
    AnnotationAssistant annotationAssistant;


    @Before
    public void before() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        this.configuration = this.sqlSessionFactory.getConfiguration();
        this.easybatisConfiguration = new EasybatisConfiguration(configuration);
        this.annotationAssistant = easybatisConfiguration.getAnnotationAssistant();
        this.tableMeta = annotationAssistant.parseEntityMate(Reflection.getEntityClass(LogicBaseMapper.class));
    }

    @Test
    public void selectKey() {
        Method method = chooseMethod(LogicBaseMapper.class, "selectKey");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().select(methodMeta);
        Assert.assertEquals("<script> SELECT `id`, `orgCode`, `orgName` FROM t_user <where> `id` = #{id} AND `valid` = #{valid} </where></script>", sql);
    }

    @Test
    public void update() {
        Method method = chooseMethod(LogicBaseMapper.class, "update");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().update(methodMeta);
        Assert.assertEquals("<script>" +
                " UPDATE t_user SET `orgCode` = #{orgCode}, `orgName` = #{orgName}" +
                " <where> `id` = #{id} AND `valid` = #{valid} </where></script>", sql);
    }

    @Test
    public void updateActivate() {
        Method method = chooseMethod(LogicBaseMapper.class, "updateActivate");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().update(methodMeta);
        String sqlTarget = "<script>"
                + " UPDATE t_user"
                + " <set>"
                + " <if test='orgCode != null'> `orgCode` = #{orgCode},</if>"
                + " <if test='orgName != null'> `orgName` = #{orgName},</if>"
                + " </set>"
                + " <where> `id` = #{id} AND `valid` = #{valid} </where>"
                + "</script>";
        Assert.assertEquals(sqlTarget, sql);
    }

    @Test
    public void insert() {
        Method method = chooseMethod(LogicBaseMapper.class, "insert");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().insert(methodMeta);
        String sqlTarget = "<script> INSERT INTO t_user (`id`, `orgCode`, `orgName`, `valid`) VALUES (#{id}, #{orgCode}, #{orgName}, #{valid}) </script>";
        Assert.assertEquals(sqlTarget, sql);
    }

    @Test
    public void insertBatch() {
        Method method = chooseMethod(LogicBaseMapper.class, "insertBatch");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().insert(methodMeta);
        String sqlTarget = "<script> INSERT INTO t_user (`id`, `orgCode`, `orgName`, `valid`) VALUES  <foreach item= 'item'  collection='list' separator=', '> (#{item.id}, #{item.orgCode}, #{item.orgName}, #{item.valid}) </foreach> </script>";
        Assert.assertEquals(sqlTarget, sql);
    }

    @Test
    public void delete() {
        Method method = chooseMethod(LogicBaseMapper.class, "delete");
        MethodMeta methodMeta = annotationAssistant.parseMethodMate(method,
                tableMeta);
        String sql = easybatisConfiguration.getSqlSourceGenerator().delete(methodMeta);
        System.out.println(sql);
        String sqlTarget = "<script> UPDATE t_user SET valid = #{invalid} <where> `id` = #{id} AND `valid` = #{valid} </where></script>";
        Assert.assertEquals(sqlTarget, sql);
    }


    private Method chooseMethod(Class<?> classType, String methodName) {
        Method[] declaredMethod = classType.getMethods();
        for (Method method : declaredMethod) {
            if (method.getName().equals(methodName)) {
                return method;
            }
        }
        throw new RuntimeException(" 找不到方法");
    }
}
