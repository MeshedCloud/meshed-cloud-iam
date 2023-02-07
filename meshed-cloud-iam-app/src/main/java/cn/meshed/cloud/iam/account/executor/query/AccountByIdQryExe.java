package cn.meshed.cloud.iam.account.executor.query;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.domain.account.Account;
import cn.meshed.cloud.iam.domain.account.gateway.AccountGateway;
import cn.meshed.cloud.iam.dto.account.AccountByIdQry;
import cn.meshed.cloud.iam.dto.account.data.AccountDTO;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class AccountByIdQryExe implements CommandExecute<AccountByIdQry, SingleResponse<AccountDTO>> {

    private final AccountGateway accountGateway;

    /**
     * 查询账号角色ID列表
     * @param accountRoleIdQry
     * @return
     */
    @Override
    public SingleResponse<AccountDTO> execute(AccountByIdQry accountRoleIdQry) {
        Account account = accountGateway.query(accountRoleIdQry.getId());
        //消除密码
        account.setSecretKey(null);
        return ResultUtils.copy(account,AccountDTO.class);
    }
}
