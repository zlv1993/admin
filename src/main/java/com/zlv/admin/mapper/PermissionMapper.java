package com.zlv.admin.mapper;





import com.zlv.admin.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface PermissionMapper {
    List<Permission> getAll();
    List<Permission> getTree();
}
