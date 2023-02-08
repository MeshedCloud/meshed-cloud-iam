package cn.meshed.cloud.iam.account.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.account.gateway.AccountGateway;
import cn.meshed.cloud.iam.domain.rbac.Permission;
import cn.meshed.cloud.iam.dto.account.GrantedAuthorityQry;
import cn.meshed.cloud.iam.dto.rbac.data.PermissionDTO;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class GrantedAuthorityQryExe implements CommandExecute<GrantedAuthorityQry, SingleResponse<Set<PermissionDTO>>> {

    private final AccountGateway accountGateway;

    /**
     * @param grantedAuthorityQry 权限查询对象
     * @return
     */
    @Override
    public SingleResponse<Set<PermissionDTO>> execute(GrantedAuthorityQry grantedAuthorityQry) {
        Set<Permission> grantedAuthority = accountGateway.getGrantedAuthority(grantedAuthorityQry.getAccountId());
        return ResultUtils.copySet(grantedAuthority,PermissionDTO::new);
    }
}
