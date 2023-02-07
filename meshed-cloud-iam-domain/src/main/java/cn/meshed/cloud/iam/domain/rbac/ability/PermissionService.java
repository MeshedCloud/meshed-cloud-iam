package cn.meshed.cloud.iam.domain.rbac.ability;

import cn.meshed.base.ability.BaseAbility;
import cn.meshed.base.core.IList;
import cn.meshed.cloud.iam.dto.rbac.PermissionByIdQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionCmd;
import cn.meshed.cloud.iam.dto.rbac.PermissionQry;
import cn.meshed.cloud.iam.dto.rbac.data.PermissionDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

import java.util.List;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface PermissionService
        extends BaseAbility<PermissionCmd, PermissionCmd, Long, PermissionByIdQry, Response, SingleResponse<PermissionDTO>>,
        IList<PermissionQry, SingleResponse<List<PermissionDTO>>> {

    /**
     * 选择列表
     *
     * @param permissionBySelectQry 查询
     * @return
     */
    SingleResponse<List<PermissionDTO>> select(PermissionBySelectQry permissionBySelectQry);
}
