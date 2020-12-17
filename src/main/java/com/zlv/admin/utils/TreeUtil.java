package com.zlv.admin.utils;


import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;
import java.util.ArrayList;
import java.util.List;


public class TreeUtil {
    public static List<PermissionVo> getTree(List<Permission> sqlData){
        //存储非根节点
        List<PermissionVo> tempList=new ArrayList<>();
        //存储最终的结果
        List<PermissionVo> resultList=new ArrayList<>();
        //遍历数据库查询数据集合,如果父id==-1 代表根节点 添加到最终结果中,否则为非根节点添加到临时节点

        for (Permission menu : sqlData) {
            PermissionVo permissionVo =new PermissionVo(menu.getId(),menu.getPid(), menu.getUrl(), menu.getPath(), menu.getComponent(), menu.getName(), menu.getIcon(), menu.getType(), menu.getCreateTime(), menu.getUpdateTime(),menu.getRoles());
            if(menu.getPid()==0){

                resultList.add(permissionVo);
            }else{
                tempList.add(permissionVo);
            }
        }
        //遍历所有的根节点,通过根节点和非根节点集合,找到这个根节点的所有子节点
        for (PermissionVo PermissionVo : resultList) {
            getChildNode(tempList,PermissionVo);
        }

        return resultList;

    }
    public  static   void getChildNode(List<PermissionVo> tempList,PermissionVo fatherNode  ){
        for (PermissionVo PermissionVo : tempList) {
            //如果该节点的父id为传进来父节点的id 那么就为其子节点
            if(PermissionVo.getPid()==fatherNode.getId()){
                //添加到子节点数组
                fatherNode.getChildren().add(PermissionVo);
                //递归调用 继续找该子节点  是否还有子节点
                getChildNode(tempList,PermissionVo);
            }
        }
    }

}
