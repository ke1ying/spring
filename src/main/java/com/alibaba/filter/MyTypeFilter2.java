package com.alibaba.filter;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

/**
 * 扫描包自定义规则
 * metadataReader:读取到当前正在扫描类的信息
 * metadataReaderFactory：可以获取到其他任何类的信息
 *
 * @author keying
 */
public class MyTypeFilter2 implements TypeFilter {
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
        throws IOException {
        //获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类资源信息 （比如类存在哪个盘，类的路径  ）
        Resource resource = metadataReader.getResource();
        String name = classMetadata.getClassName();
        System.out.println("Filter扫描的类名:" + name);
        if(name.contains("person")){
            return true;
        }
        return false;
    }
}
