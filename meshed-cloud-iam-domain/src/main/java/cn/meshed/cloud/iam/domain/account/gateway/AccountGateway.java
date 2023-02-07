package cn.meshed.cloud.iam.domain.account.gateway;

import cn.meshed.base.core.IPageList;
import cn.meshed.base.gateway.BaseGateway;
import cn.meshed.cloud.iam.domain.account.Account;
import cn.meshed.cloud.iam.domain.rbac.Permission;
import cn.meshed.cloud.iam.domain.rbac.Role;
import cn.meshed.cloud.iam.dto.account.AccountQry;
import com.alibaba.cola.dto.PageResponse;

import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface AccountGateway extends BaseGateway<Account, Account, Long, Long,Boolean,Account>,
        IPageList<AccountQry, PageResponse<Account>> {

    /**
     * 根据登入ID获取账号消息  todo 解决敏感信息RPC调用
     *
     * @param loginId 登入ID也就是登入名称
     * @return {@link Account}
     */
    Account getAccountByLoginId(String loginId);

    /**
     * 授权用户角色
     *
     * @param accountId 账号ID
     * @param roleIds   角色ID
     * @return 处理结果
     */
    Boolean grantRole(Long accountId, Set<Long> roleIds);


    /**
     * 获取账号权限
     *
     * @param accountId 权限账号
     * @return 权限字符集
     */
    Set<Permission> getGrantedAuthority(Long accountId);

    /**
     * 根据账号获取角色集合
     *
     * @param accountId 账号
     * @return 权限集合
     */
    Set<Long> getAccountRoleIdSet(Long accountId);

    /**
     * 根据账号获取角色集合
     *
     * @param accountId 账号
     * @return 权限集合
     */
    Set<Role> getAccountRoleSet(Long accountId);

}
