package com.xwc.open.easy.batis.meta;import com.xwc.open.easy.batis.enums.IdType;import java.util.ArrayList;import java.util.List;/** * 创建人：徐卫超 * 时间：2019/8/30 11:16 * 功能： * 备注： */public class AuditorMate {    /**     * 主键信息     */    private Attribute id;    /**     * 主键类型     */    private IdType type;    private List<AuditorAttribute> auditorAttributeList = new ArrayList<>(6);    public AuditorMate(EntityMate mate) {        this.id = mate.getId();        this.type = mate.getType();        this.auditorAttributeList = mate.auditorAttributeList();    }}