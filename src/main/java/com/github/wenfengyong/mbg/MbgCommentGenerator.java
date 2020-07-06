package com.github.wenfengyong.mbg;

import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;

/**
 * 继承注释生成器，对生成注释的相关方法重新实现
 * @author WenFY
 * @date 2020/6/30 19:15
 */
public class MbgCommentGenerator implements CommentGenerator {
    
    /**
     * properties配置文件
     */
    private Properties properties;
    
    /**
     * 系统的properties配置文件
     */
    private Properties systemPro;
    
    /**
     * 是否取消所有注释
     */
    private boolean suppressAllComments;
    
    public MbgCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressAllComments = false;
    }
    
    @Override
    public void addConfigurationProperties(Properties properties) {
        suppressAllComments = StringUtility.isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }
    
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        
    }
    
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
    
    }
    
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    
    }
    
    /**
     * java 的类注释
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
    
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        sb.append(" ");
        // 替换换行符号
        innerClass.addJavaDocLine(removeLineSeparator(sb.toString()));
        innerClass.addJavaDocLine(" */");
    }
    
    /**
     * 为类添加注释
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerClass.addJavaDocLine(removeLineSeparator(sb.toString()));
        // 相当于clear 操作
        sb.setLength(0);
        sb.append(" * @author ");
        sb.append(systemPro.getProperty("user.name"));
        sb.append(" ");
        innerClass.addJavaDocLine(" */");
    }
    
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
    
    }
    
    /**
     * get 方法的注释，作用不大，不做实现
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        
    }
    
    /**
     * set 方法的注释，作用不大，不做实现
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        
    }
    
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
    
    }
    
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
    
    }
    
    @Override
    public void addComment(XmlElement xmlElement) {
    
    }
    
    @Override
    public void addRootComment(XmlElement rootElement) {
    
    }
    
    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
        
    }
    
    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        
    }
    
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
        
    }
    
    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        
    }
    
    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
         
    }
    
    /**
     * 去除换行和回车符
     * @return
     */
    private String removeLineSeparator(String source) {
        return source.replace("\n", " ").replace("\r", " ");
    }
}
