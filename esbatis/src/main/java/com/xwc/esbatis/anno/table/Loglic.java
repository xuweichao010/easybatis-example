package com.xwc.esbatis.anno.table;import java.lang.annotation.*;/** * 创建人：徐卫超 * 时间：2019/6/21 11:45 * 功能： * 备注： */@Documented@Target({ElementType.FIELD})     //只能使用在：类、接口、注解、枚举@Retention(RetentionPolicy.RUNTIME)     //在运行时有效public @interface Loglic {    int Valid();    int Invalid();}