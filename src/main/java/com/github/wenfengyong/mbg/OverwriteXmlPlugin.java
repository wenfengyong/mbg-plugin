package com.github.wenfengyong.mbg;

import java.util.List;

import org.mybatis.generator.api.GeneratedXmlFile;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * 实现自定义补丁类，在生成xml时，使用覆盖 而非默认的追加
 * @author WenFY
 * @date 2020/7/6 17:58
 */
public class OverwriteXmlPlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }
    
    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        // 关键，默认是true,追加
        sqlMap.setMergeable(false);
        return super.sqlMapGenerated(sqlMap, introspectedTable);
    }
    
}
