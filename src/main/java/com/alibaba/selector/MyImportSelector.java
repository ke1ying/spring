package com.alibaba.selector;

import com.alibaba.bean.Blue;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author keying
 * @Import
 * @date 2021/6/28
 */
public class MyImportSelector implements ImportSelector {
    /**
     * @param importingClassMetadata 当前标注@Import注解类的所有注解信息
     * @return 容器里的组件
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //可以返回空数组，不要返回null
        return new String[] {"com.alibaba.bean.Blue", "com.alibaba.bean.Yellow"};
    }
}
