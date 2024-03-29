package cn.meshed.cloud.iam.rbac.executor.query;

import cn.meshed.cloud.constant.Status;
import cn.meshed.cloud.cqrs.QueryExecute;
import cn.meshed.cloud.iam.domain.rbac.gateway.PermissionGateway;
import cn.meshed.cloud.iam.rbac.data.PermissionOptionDTO;
import cn.meshed.cloud.iam.rbac.query.PermissionBySelectQry;
import cn.meshed.cloud.iam.rbac.query.PermissionQry;
import cn.meshed.cloud.utils.ResultUtils;
import com.alibaba.cola.dto.MultiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class PermissionBySelectQryExe implements QueryExecute<PermissionBySelectQry, MultiResponse<PermissionOptionDTO>> {

    private final PermissionGateway permissionGateway;

    /**
     * @param permissionBySelectQry
     * @return
     */
    @Override
    public MultiResponse<PermissionOptionDTO> execute(PermissionBySelectQry permissionBySelectQry) {
        PermissionQry permissionQry = new PermissionQry();
        permissionQry.setStatus(Status.VALID);
        return ResultUtils.copyMulti(permissionGateway.searchList(permissionQry), PermissionOptionDTO::new);
    }
}
