package cn.meshed.cloud.iam.rbac.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.rbac.Permission;
import cn.meshed.cloud.iam.domain.rbac.gateway.PermissionGateway;
import cn.meshed.cloud.iam.dto.rbac.PermissionQry;
import cn.meshed.cloud.iam.dto.rbac.data.PermissionDTO;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class PermissionListQryExe implements CommandExecute<PermissionQry, SingleResponse<List<PermissionDTO>>> {

    private final PermissionGateway permissionGateway;

    /**
     * @param permissionQry
     * @return
     */
    @Override
    public SingleResponse<List<PermissionDTO>> execute(PermissionQry permissionQry) {
        List<Permission> permissionVOList = permissionGateway.searchList(permissionQry);
        return ResultUtils.copyList(permissionVOList,PermissionDTO::new);
    }
}
