package cn.meshed.cloud.iam.rbac.executor;

import cn.meshed.cloud.iam.domain.rbac.ability.PermissionService;
import cn.meshed.cloud.iam.dto.rbac.PermissionByIdQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionBySelectQry;
import cn.meshed.cloud.iam.dto.rbac.PermissionCmd;
import cn.meshed.cloud.iam.dto.rbac.PermissionQry;
import cn.meshed.cloud.iam.dto.rbac.data.PermissionDTO;
import cn.meshed.cloud.iam.rbac.executor.command.PermissionCmdExe;
import cn.meshed.cloud.iam.rbac.executor.command.PermissionDelExe;
import cn.meshed.cloud.iam.rbac.executor.query.PermissionListQryExe;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h1>权限操作能力</h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionCmdExe permissionCmdExe;
    private final PermissionDelExe permissionDelExe;
    private final PermissionListQryExe permissionListQryExe;


    /**
     * 删除
     * @param id id
     * @return 操作结果
     */
    @Override
    public Response delete(Long id) {
        return permissionDelExe.execute(id);
    }

    /**
     * 保存
     * @param permissionCmd 保存对象
     * @return 操作结果
     */
    @Override
    public Response save(PermissionCmd permissionCmd) {
        return permissionCmdExe.execute(permissionCmd);
    }

    /**
     * @param permissionQry
     * @return
     */
    @Override
    public SingleResponse<List<PermissionDTO>> searchList(PermissionQry permissionQry) {
        return permissionListQryExe.execute(permissionQry);
    }

    /**
     * 选择列表
     *
     * @param permissionBySelectQry 查询
     * @return
     */
    @Override
    public SingleResponse<List<PermissionDTO>> select(PermissionBySelectQry permissionBySelectQry) {
        return null;
    }

    /**
     * @param permissionByIdQry
     * @return
     */
    @Override
    public SingleResponse<PermissionDTO> query(PermissionByIdQry permissionByIdQry) {
        return null;
    }
}
