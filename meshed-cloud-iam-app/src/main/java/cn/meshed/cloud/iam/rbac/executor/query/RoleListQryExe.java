package cn.meshed.cloud.iam.rbac.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.rbac.Role;
import cn.meshed.cloud.iam.domain.rbac.gateway.RoleGateway;
import cn.meshed.cloud.iam.dto.rbac.RoleQry;
import cn.meshed.cloud.iam.dto.rbac.data.RoleDTO;
import com.alibaba.cola.dto.PageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h1></h1>
 *
 * @version 1.0
 * @author Vincent Vic
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class RoleListQryExe implements CommandExecute<RoleQry, PageResponse<RoleDTO>> {

    private final RoleGateway roleGateway;

    /**
     * @param roleQry
     * @return
     */
    @Override
    public PageResponse<RoleDTO> execute(RoleQry roleQry) {
        PageResponse<Role> response = roleGateway.searchPageList(roleQry);
        return ResultUtils.copyPage(response,RoleDTO::new);
    }
}
