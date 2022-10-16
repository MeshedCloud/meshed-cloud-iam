package cn.meshed.cloud.iam.executor;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.cloud.iam.domain.dto.cmd.LoginSuccessCmd;
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
public class LoginSuccessCmdExe implements CommandExecute<LoginSuccessCmd, SingleResponse<LoginSuccessCmd>> {
    /**
     * @param loginSuccessCmd
     * @return
     */
    @Override
    public SingleResponse<LoginSuccessCmd> execute(LoginSuccessCmd loginSuccessCmd) {

        System.out.println(loginSuccessCmd);
        return SingleResponse.of(loginSuccessCmd);
    }
}
