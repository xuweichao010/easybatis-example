package com.xwc.open.easybatis.mysql.mybatis.logic;

import com.xwc.open.easybatis.core.anno.SelectSql;
import com.xwc.open.easybatis.core.anno.condition.filter.ASC;
import com.xwc.open.easybatis.core.anno.condition.filter.DESC;
import com.xwc.open.easybatis.core.anno.table.Ignore;
import com.xwc.open.easybatis.core.support.BaseMapper;
import com.xwc.open.easybatis.core.support.BaseTableMapper;
import com.xwc.open.easybatis.core.support.EasyMapper;
import com.xwc.open.easybatis.mysql.mybatis.other.OtherTableUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 创建人：徐卫超
 * 创建时间：2019/4/2  11:19
 * 业务：
 * 功能：
 */
@SuppressWarnings("unused")
@Mapper
public interface LogicTableUserMapper extends BaseTableMapper<LogicTableUser, String> {


}
