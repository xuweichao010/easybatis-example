package com.xwc.esbatis.anno.table;import com.xwc.esbatis.meta.FieldType;import org.springframework.core.annotation.AliasFor;import java.lang.annotation.*;/** * 创建人：徐卫超 * 时间：2019/6/21 13:50 * 功能： * 备注： */@Documented@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})     //只能使用在：类、接口、注解、枚举@Retention(RetentionPolicy.RUNTIME)     //在运行时有效@Inheritedpublic @interface Operation {    FieldType value();    boolean selectHide() default true;}