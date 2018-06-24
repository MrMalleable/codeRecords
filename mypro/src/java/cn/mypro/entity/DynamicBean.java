package cn.mypro.entity;

import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by MrBread on 2017/7/20.
 */
//构造一个动态类用于添加动态属性
public class DynamicBean{
    //实体Object
    private Object object=null;
    //属性map
    private BeanMap beanMap=null;

    //构造函数
    public DynamicBean(){
        super();
    }

    public DynamicBean(Map propertyMap){
        this.object=generateBean(propertyMap);
        this.beanMap=BeanMap.create(this.object);
    }

    /**
     * 给bean属性赋值
     * @param property
     * @param value
     */
    public void setValue(String property,Object value){
        beanMap.put(property,value);
    }

    /**
     * 通过属性名得到属性值
     * @param property
     * @return
     */
    public Object getValue(String property){
        return beanMap.get(property);
    }

    /**
     *得到该实体bean对象
     * @return
     */
    public Object getObject(){
        return this.object;
    }

    private Object generateBean(Map propertyMap){
        BeanGenerator generator=new BeanGenerator();
        Set keySet=propertyMap.keySet();
        for(Iterator i = keySet.iterator(); i.hasNext();){
            String key=(String)i.next();
            generator.addProperty(key,(Class)propertyMap.get(key));
        }
        return generator.create();
    }
}
