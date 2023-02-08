package cn.meshed.cloud.iam.web;

import cn.meshed.cloud.iam.domain.rbac.ability.PermissionService;
import cn.meshed.cloud.iam.dto.rbac.PermissionByIdQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionCmd;
import cn.meshed.cloud.iam.dto.rbac.PermissionQry;
import cn.meshed.cloud.iam.dto.rbac.data.PermissionDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("permission")
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("list")
    public SingleResponse<List<PermissionDTO>> list(PermissionQry permissionQry){
        return permissionService.searchList(permissionQry);
    }

    @GetMapping("select")
    public SingleResponse<List<PermissionDTO>> select(PermissionBySelectQry permissionBySelectQry){
        return permissionService.select(permissionBySelectQry);
    }

    @GetMapping("details")
    public Response details(@Validated @RequestBody PermissionByIdQry permissionByIdQry){
        return permissionService.query(permissionByIdQry);
    }

    @PostMapping("save")
    public Response save(@Validated @RequestBody PermissionCmd permissionCmd){
        return permissionService.save(permissionCmd);
    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable("id") Long id){
        return permissionService.delete(id);
    }

}
