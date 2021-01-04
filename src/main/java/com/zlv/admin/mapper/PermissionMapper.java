package com.zlv.admin.mapper;





import com.zlv.admin.domain.Permission;
import com.zlv.admin.domain.PermissionVo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PermissionMapper {
    List<Permission> getAll();
    List<PermissionVo> getTree();
    int addPermission(Permission permission);
    int deletePermission(int id);
}
