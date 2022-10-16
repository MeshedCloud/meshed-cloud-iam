package cn.meshed.cloud.iam.executor;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.AssertUtils;
import cn.meshed.base.utils.CopyUtils;
import cn.meshed.cloud.iam.domain.dto.cmd.DoLoginHandleCmd;
import cn.meshed.cloud.iam.domain.dto.cmd.LoginSuccessCmd;
import cn.meshed.cloud.iam.domain.dto.cmd.PasswordMatchesCmd;
import cn.meshed.cloud.iam.dto.AccountByLoginIdRequest;
import cn.meshed.cloud.iam.dto.AccountResponse;
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
public class DoLoginHandleCmdExe implements CommandExecute<DoLoginHandleCmd, Response> {

    private final AccountByLoginIdQryExe accountByLoginIdQryExe;
    private final PasswordMatchesCmdExe passwordMatchesCmdExe;
    private final LoginSuccessCmdExe loginSuccessCmdExe;
    /**
     * @param doLoginHandleCmd
     * @return
     */
    @Override
    public SingleResponse<LoginSuccessCmd> execute(DoLoginHandleCmd doLoginHandleCmd) {

        AssertUtils.isTrue(doLoginHandleCmd.verifySelf(),"登入参数不能为空");

        AccountByLoginIdRequest request = new AccountByLoginIdRequest();
        request.setLoginId(doLoginHandleCmd.getLoginName());
        SingleResponse<AccountResponse> response = accountByLoginIdQryExe.execute(request);
        if (response == null){
            return SingleResponse.buildFailure("400","账号或密码不正确");
        }
        if (!response.isSuccess()){
            return SingleResponse.buildFailure(response.getErrCode(), response.getErrMessage());
        }
        AccountResponse accountResponse = response.getData();
        if (!isLogin(doLoginHandleCmd, accountResponse.getSecretKey())) {
            return SingleResponse.buildFailure("400","登入失败");
        }
        LoginSuccessCmd loginSuccessCmd = CopyUtils.copy(accountResponse, LoginSuccessCmd.class);
        return loginSuccessCmdExe.execute(loginSuccessCmd);
    }

    private Boolean isLogin(DoLoginHandleCmd doLoginHandleCmd, String secretKey) {
        String rawPassword = doLoginHandleCmd.getPassword();
        PasswordMatchesCmd passwordMatchesCmd = new PasswordMatchesCmd();
        passwordMatchesCmd.setUnencrypted(rawPassword);
        passwordMatchesCmd.setEncrypted(secretKey);
        return passwordMatchesCmdExe.execute(passwordMatchesCmd);
    }
}
