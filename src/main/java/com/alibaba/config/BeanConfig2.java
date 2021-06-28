package com.alibaba.config;

import com.alibaba.bean.Color;
import com.alibaba.bean.ColorFactoryBean;
import com.alibaba.bean.Person;
import com.alibaba.bean.Red;
import com.alibaba.condition.LinuxCondition;
import com.alibaba.condition.MacCondition;
import com.alibaba.filter.MyTypeFilter;
import com.alibaba.filter.MyTypeFilter2;
import com.alibaba.selector.MyImportBeanDefinition;
import com.alibaba.selector.MyImportSelector;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * @Scope
 * prototype : 多实例，每次获取bean的时候，才会创建对象
 * singleton （默认的）: 单实例，创建容器的时候直接把bean交给springIOC容器管理，
 *                     以后每次直接在IOC容器中get
 *
 * @Lazy : 懒加载，只在单例模式的情况下，懒加载是容器创建完之后，第一次获取对象的时候才，创建实例对象。
 *
 * @Import：导入组件，id默认是全类名
 *
 * @author keying
 */
@Configuration
//满足conditional条件，这个类的配置信息才可以生效
@Conditional({MacCondition.class})
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinition.class})
public class BeanConfig2 {

    @Scope
    @Lazy
    @Bean(value = "person")
    public Person getPerson(){
        System.out.println("把bean交给容器管理");
        return new Person("person2",19);
    }

    /**
     * @Conditional判断条件，满足就放入容器
     *
     */
    @Bean(value = "Mac")
    @Conditional({MacCondition.class})
    public Person getMac(){
        return new Person("Mac",1);
    }

    @Bean(value = "Linux")
    @Conditional({LinuxCondition.class})
    public Person getLinux(){
        return new Person("Linux",2);
    }

    @Bean
    public ColorFactoryBean getColorFactoryBean(){
        return new ColorFactoryBean();
    }
}
