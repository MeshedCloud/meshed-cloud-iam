package cn.meshed.cloud.iam.domain.rbac.ability;

import cn.meshed.base.ability.BaseAbility;
import cn.meshed.base.core.IPageList;
import cn.meshed.cloud.iam.dto.rbac.RoleByIdQry;
import cn.meshed.cloud.iam.dto.rbac.RoleBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.RoleCmd;
import cn.meshed.cloud.iam.dto.rbac.RoleGrantPermissionCmd;
import cn.meshed.cloud.iam.dto.rbac.RolePermissionByIdQry;
import cn.meshed.cloud.iam.dto.rbac.RoleQry;
import cn.meshed.cloud.iam.dto.rbac.data.RoleDTO;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface RoleService extends BaseAbility<RoleCmd,RoleCmd, Long,RoleByIdQry, Response, SingleResponse<RoleDTO>> ,
        IPageList<RoleQry, PageResponse<RoleDTO>> {

    /**
     * 授予角色权限
     *
     * @param roleGrantPermissionCmd  授权操作对象
     * @return 处理情况
     */
    Response grantPermission(RoleGrantPermissionCmd roleGrantPermissionCmd);

    /**
     * 角色权限列表
     * @param rolePermissionByIdQry 角色权限列表参数
     * @return
     */
    Response permissions(RolePermissionByIdQry rolePermissionByIdQry);

    /**
     * 角色选择列表
     *
     * @param roleBySelectQry 角色选择参数
     * @return
     */
    Response select(RoleBySelectQry roleBySelectQry);
}
