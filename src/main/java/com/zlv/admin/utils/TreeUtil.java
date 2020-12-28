package com.zlv.admin.utils;


import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class TreeUtil<T> {
    //存储非根节点
    List<T> tempList=new ArrayList<>();
    //存储最终的结果
    List<T> resultList=new ArrayList<>();
    public  List<T> getTree(List<T> sqlData, String idName, String pidName) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {

        //遍历数据库查询数据集合,如果父id==-1 代表根节点 添加到最终结果中,否则为非根节点添加到临时节点

        for (T menu : sqlData) {
            Class<?>  clazz= menu.getClass();
            Object t= clazz.newInstance();
            Field fieldTag = clazz.getDeclaredField(pidName);
            fieldTag.setAccessible(true);
            int pid = (int) fieldTag.get(menu);
            if(pid==0){
                resultList.add(menu);
            }else{
                tempList.add(menu);
            }
        }
        //遍历所有的根节点,通过根节点和非根节点集合,找到这个根节点的所有子节点
        for (T t : resultList) {
            this.getChildNode(tempList,t,idName,pidName);
        }

        return resultList;

    }
    public void getChildNode(List<T> tempList,T fatherNode,String idName,String pidName ) throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException {
        Class<?>  parentClazz= fatherNode.getClass();
        Field parentField = parentClazz.getDeclaredField(idName);
        parentField.setAccessible(true);
        int id = (int) parentField.get(fatherNode);
        for (T t : tempList) {
            //如果该节点的父id为传进来父节点的id 那么就为其子节点
            Class<?>  clazz= t.getClass();
            Field fieldTag = clazz.getDeclaredField(pidName);
            fieldTag.setAccessible(true);
            int pid = (int) fieldTag.get(t);
            if(id==pid){
                Field fieldChildren = parentClazz.getDeclaredField("children");
                fieldChildren.setAccessible(true);
                List<T> children= (List<T>)fieldChildren.get(fatherNode);
                //添加到子节点数组
                children.add(t);
                //递归调用 继续找该子节点  是否还有子节点
                getChildNode(tempList,t,idName,pidName);
            }
        }
    }

}