package cn.meshed.cloud.iam.account.executor.command;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.ResultUtils;
import cn.meshed.cloud.iam.dto.account.LoginSuccessCmd;
import cn.meshed.cloud.iam.dto.account.data.LoginSuccessDTO;
import com.alibaba.cola.dto.SingleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class LoginSuccessCmdExe implements CommandExecute<LoginSuccessCmd, SingleResponse<LoginSuccessDTO>> {
    /**
     * @param loginSuccessCmd
     * @return
     */
    @Override
    public SingleResponse<LoginSuccessDTO> execute(LoginSuccessCmd loginSuccessCmd) {

        return ResultUtils.copy(loginSuccessCmd,LoginSuccessDTO.class);
    }
}
