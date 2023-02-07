package cn.meshed.cloud.iam.domain.account.ability;

import cn.meshed.base.ability.BaseAbility;
import cn.meshed.base.core.IPageList;
import cn.meshed.cloud.iam.dto.account.AccountAddCmd;
import cn.meshed.cloud.iam.dto.account.AccountByIdQry;
import cn.meshed.cloud.iam.dto.account.AccountGrantRoleCmd;
import cn.meshed.cloud.iam.dto.account.AccountLockCmd;
import cn.meshed.cloud.iam.dto.account.AccountQry;
import cn.meshed.cloud.iam.dto.account.data.AccountDTO;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface AccountService
        extends BaseAbility<AccountAddCmd, AccountAddCmd, Long, AccountByIdQry, Response, SingleResponse<AccountDTO>>,
        IPageList<AccountQry, PageResponse<AccountDTO>> {

    /**
     * 授权用户角色
     *
     * @param accountGrantRoleCmd 授权请求对象
     * @return 处理结果
     */
    Response grantAccount(AccountGrantRoleCmd accountGrantRoleCmd);

    /**
     * 授权用户角色
     *
     * @param accountByIdQry 账号ID查询对象
     * @return 处理结果
     */
    SingleResponse<Set<Long>> getAccountRoles(AccountByIdQry accountByIdQry);

    /**
     * 账号的锁定和解锁
     *
     * @param accountLockCmd 操作参数
     * @return 处理结果
     */
    Response operateLock(AccountLockCmd accountLockCmd);
}
