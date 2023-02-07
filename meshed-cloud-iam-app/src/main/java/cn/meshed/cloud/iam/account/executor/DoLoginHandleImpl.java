package cn.meshed.cloud.iam.account.executor;

import cn.meshed.cloud.iam.account.executor.command.DoLoginHandleCmdExe;
import cn.meshed.cloud.iam.domain.account.ability.DoLoginHandle;
import cn.meshed.cloud.iam.dto.account.DoLoginHandleCmd;
import cn.meshed.cloud.iam.dto.account.data.LoginSuccessDTO;
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
    public SingleResponse<LoginSuccessDTO> loginHandle(String loginName, String password) {
        DoLoginHandleCmd doLoginHandleCmd = new DoLoginHandleCmd();
        doLoginHandleCmd.setLoginName(loginName);
        doLoginHandleCmd.setPassword(password);
        return doLoginHandleCmdExe.execute(doLoginHandleCmd);
    }
}
