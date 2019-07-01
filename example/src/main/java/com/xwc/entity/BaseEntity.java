package com.xwc.entity;import com.xwc.esbatis.anno.table.Loglic;import com.xwc.esbatis.anno.table.Operation;import com.xwc.esbatis.meta.FieldType;import java.util.Date;/** * 创建人：徐卫超 * 时间：2019/6/25 16:46 * 功能： * 备注： */public class BaseEntity {    /**     * 是否有效     */    @Loglic(valid = 0, invalid = 1)    private Integer valid;    /**     * 创建时间     */    @Operation(FieldType.CREATE_TIME)    private Date createTime;    /**     * 创建ID     */    @Operation(FieldType.CREATE_ID)    private Long createId;    /**     * 创建名字     */    @Operation(FieldType.CREATE_NAME)    private String createName;    /**     * 更新时间     */    @Operation(FieldType.UPDATE_TIME)    private Date updateTime;    /**     * 更想ID     */    @Operation(FieldType.UPDATE_ID)    private Long updateId;    /**     * 更新名字     */    @Operation(FieldType.UPDATE_NAME)    private String updateName;    public Integer getValid() {        return valid;    }    public void setValid(Integer valid) {        this.valid = valid;    }    public Date getCreateTime() {        return createTime;    }    public void setCreateTime(Date createTime) {        this.createTime = createTime;    }    public Long getCreateId() {        return createId;    }    public void setCreateId(Long createId) {        this.createId = createId;    }    public String getCreateName() {        return createName;    }    public void setCreateName(String createName) {        this.createName = createName;    }    public Date getUpdateTime() {        return updateTime;    }    public void setUpdateTime(Date updateTime) {        this.updateTime = updateTime;    }    public Long getUpdateId() {        return updateId;    }    public void setUpdateId(Long updateId) {        this.updateId = updateId;    }    public String getUpdateName() {        return updateName;    }    public void setUpdateName(String updateName) {        this.updateName = updateName;    }}