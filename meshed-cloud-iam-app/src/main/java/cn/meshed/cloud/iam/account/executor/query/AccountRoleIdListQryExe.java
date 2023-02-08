package cn.meshed.cloud.iam.account.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.account.gateway.AccountGateway;
import cn.meshed.cloud.iam.dto.account.AccountByIdQry;
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
public class AccountRoleIdListQryExe implements CommandExecute<AccountByIdQry, SingleResponse<Set<Long>>> {

    private final AccountGateway accountGateway;

    /**
     * @param accountByIdQry
     * @return
     */
    @Override
    public SingleResponse<Set<Long>> execute(AccountByIdQry accountByIdQry) {
        Set<Long> roleIdSet = accountGateway.getAccountRoleIdSet(accountByIdQry.getId());
        return ResultUtils.of(roleIdSet);
    }
}
