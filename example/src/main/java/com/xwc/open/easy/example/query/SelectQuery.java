package com.xwc.open.easy.example.query;import com.xwc.open.easy.batis.anno.condition.filter.IsNull;import com.xwc.open.easy.batis.anno.condition.filter.NotEqual;import com.xwc.open.easy.batis.anno.condition.filter.NotNull;/** * 创建人：徐卫超 * 时间：2019/10/15 10:29 * 功能： * 备注： */public class SelectQuery {    private String code;    @NotEqual("code")    private String notEqualCode;    @IsNull("parent_code")    private boolean parentCodeIsNull;    @NotNull("parent_code")    private Boolean parentCodeNotNull;    public String getCode() {        return code;    }    public void setCode(String code) {        this.code = code;    }    public String getNotEqualCode() {        return notEqualCode;    }    public void setNotEqualCode(String notEqualCode) {        this.notEqualCode = notEqualCode;    }    public boolean isParentCodeIsNull() {        return parentCodeIsNull;    }    public void setParentCodeIsNull(boolean parentCodeIsNull) {        this.parentCodeIsNull = parentCodeIsNull;    }    public Boolean getParentCodeNotNull() {        return parentCodeNotNull;    }    public void setParentCodeNotNull(Boolean parentCodeNotNull) {        this.parentCodeNotNull = parentCodeNotNull;    }}