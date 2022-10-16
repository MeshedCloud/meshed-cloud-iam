package cn.meshed.cloud.iam;

import cn.meshed.cloud.iam.domain.ability.DoLoginHandle;
import cn.meshed.cloud.iam.domain.dto.cmd.DoLoginHandleCmd;
import cn.meshed.cloud.iam.domain.dto.cmd.LoginSuccessCmd;
import cn.meshed.cloud.iam.dto.AccountByLoginIdRequest;
import cn.meshed.cloud.iam.dto.AccountResponse;
import cn.meshed.cloud.iam.executor.DoLoginHandleCmdExe;
import cn.meshed.cloud.iam.executor.query.AccountByLoginIdQryExe;
import com.alibaba.cola.dto.Response;
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
public class DoLoginHandleImpl implements DoLoginHandle {

    private final DoLoginHandleCmdExe doLoginHandleCmdExe;

    /**
     * 登入处理器
     *
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public SingleResponse<LoginSuccessCmd> loginHandle(String loginName, String password) {
        DoLoginHandleCmd doLoginHandleCmd = new DoLoginHandleCmd();
        doLoginHandleCmd.setLoginName(loginName);
        doLoginHandleCmd.setPassword(password);
        return doLoginHandleCmdExe.execute(doLoginHandleCmd);
    }
}
