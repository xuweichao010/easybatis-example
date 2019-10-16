package com.xwc.open.easy.example;import com.xwc.open.easy.example.dao.OrgMapper;import com.xwc.open.easy.example.entity.Org;import com.xwc.open.easy.example.query.SelectQuery;import org.junit.Test;import org.junit.runner.RunWith;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.test.context.SpringBootTest;import org.springframework.test.context.junit4.SpringRunner;import java.util.ArrayList;import java.util.List;/** * 创建人：徐卫超 * 时间：2019/10/15 10:20 * 功能：在自定义查询分为两类 *         对象查询： 自带动态查询 *         参数查询： 查询可以支持动态（利用SQL动态查询技术） * 备注： */@RunWith(SpringRunner.class)@SpringBootTest(classes = Application.class)public class TestSelect {    @Autowired    private OrgMapper orgMapper;    /*********************  对象查询详解      ************************/    /**     * 当查询对象中查询属性上不指定查询条件时，我们系统默认的是等价查询条件     */    @Test    public void equal(){        //query 相等查询        SelectQuery equals = new SelectQuery();        equals.setCode("200");        List<Org> list = orgMapper.query(equals);        System.out.println(list.toString());    }    /**     * 不等查询 @NotEqual     */    @Test    public void notEqual(){        SelectQuery query = new SelectQuery();        query.setNotEqualCode("200");        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    /**     * 空查询 IsNull; 在使用IsNull注解时，当参数不为空时有效，跟属性类型和属性内容无关     */    @Test    public void isNull(){        SelectQuery query = new SelectQuery();        query.setParentCodeIsNull(true);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    /**     * IN查询 In 在使用In查询的时候请需要保证 数组的成员数量不能为0     */    @Test    public void inCode(){        SelectQuery query = new SelectQuery();        List<String> incode = new ArrayList<>();        incode.add("200");        incode.add("200001");        query.setInCode(incode);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void notInCode(){        SelectQuery query = new SelectQuery();        List<String> incode = new ArrayList<>();        incode.add("200");        incode.add("200001");        query.setNotInCode(incode);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void likeCode(){        SelectQuery query = new SelectQuery();        query.setLikeCode("004");        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void leftLikeCode(){        SelectQuery query = new SelectQuery();        query.setLeftLikeCode("004");        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void rightLikeCode(){        SelectQuery query = new SelectQuery();        query.setRightLikeCode("200");        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void gtEmployeesNum50(){        SelectQuery query = new SelectQuery();        query.setGtqEmployeesNum(50);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void ltEmployeesNum50(){        SelectQuery query = new SelectQuery();        query.setLtEmployeesNum(15);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void ltqEmployeesNum50(){        SelectQuery query = new SelectQuery();        query.setLtqEmployeesNum(15);        List<Org> list = orgMapper.query(query);        System.out.println(list.toString());    }    @Test    public void listPage(){        SelectQuery query = new SelectQuery();        query.setPageNum(2);        query.setPageSize(5);        List<Org> list = orgMapper.query(query);        System.out.println(list);    }    @Test    public void listCount(){        SelectQuery query = new SelectQuery();        query.setPageNum(2);        query.setPageSize(5);        query.setCode("200");        Long count = orgMapper.count(query);        System.out.println(count);    }}