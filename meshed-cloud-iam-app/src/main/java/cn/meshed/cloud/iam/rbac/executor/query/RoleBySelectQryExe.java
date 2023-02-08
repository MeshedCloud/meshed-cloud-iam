package cn.meshed.cloud.iam.rbac.executor.query;

import cn.meshed.base.constant.Status;
import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.rbac.Role;
import cn.meshed.cloud.iam.domain.rbac.gateway.RoleGateway;
import cn.meshed.cloud.iam.dto.rbac.RoleBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.RoleQry;
import cn.meshed.cloud.iam.dto.rbac.data.RoleOptionDTO;
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
public class RoleBySelectQryExe implements CommandExecute<RoleBySelectQry, SingleResponse<List<RoleOptionDTO>>> {

    private final RoleGateway roleGateway;

    /**
     * @param roleBySelectQry
     * @return
     */
    @Override
    public SingleResponse<List<RoleOptionDTO>> execute(RoleBySelectQry roleBySelectQry) {
        RoleQry roleQry = new RoleQry();
        roleQry.setStatus(Status.VALID);
        return ResultUtils.copyList(roleGateway.searchList(roleQry),RoleOptionDTO::new);
    }
}
