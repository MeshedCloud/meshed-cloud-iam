package cn.meshed.cloud.iam.web;

import cn.meshed.cloud.iam.domain.rbac.ability.RoleService;
import cn.meshed.cloud.iam.dto.rbac.RoleByIdQry;
import cn.meshed.cloud.iam.dto.rbac.RoleBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.RoleCmd;
import cn.meshed.cloud.iam.dto.rbac.RoleGrantPermissionCmd;
import cn.meshed.cloud.iam.dto.rbac.RolePermissionByIdQry;
import cn.meshed.cloud.iam.dto.rbac.RoleQry;
import cn.meshed.cloud.iam.dto.rbac.data.RoleDTO;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("role")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("list")
    public PageResponse<RoleDTO> list(RoleQry roleQry){
        return roleService.searchPageList(roleQry);
    }

    @GetMapping("details")
    public Response details(@Validated @RequestBody RoleByIdQry roleByIdQry){
        return roleService.query(roleByIdQry);
    }

    @GetMapping("select")
    public Response select(@Validated @RequestBody RoleBySelectQry roleBySelectQry){
        return roleService.select(roleBySelectQry);
    }

    @PostMapping("save")
    public Response save(@Validated @RequestBody RoleCmd roleCmd){
        return roleService.save(roleCmd);
    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") Long id){
        return roleService.delete(id);
    }

    @GetMapping("permissions")
    public Response permissions(@Validated @RequestBody RolePermissionByIdQry rolePermissionByIdQry){
        return roleService.permissions(rolePermissionByIdQry);
    }

    @PostMapping("grant/permissions")
    public Response grantAccount(@Validated @RequestBody RoleGrantPermissionCmd roleGrantPermissionCmd){
        return roleService.grantPermission(roleGrantPermissionCmd);
    }
}
