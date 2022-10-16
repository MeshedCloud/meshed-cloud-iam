package cn.meshed.cloud.iam.executor;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.AssertUtils;
import cn.meshed.cloud.iam.domain.dto.cmd.PasswordBuildCmd;
import com.alibaba.cola.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@RequiredArgsConstructor
@Component
public class PasswordBuildCmdExe implements CommandExecute<PasswordBuildCmd, String> {

    private final PasswordEncoder passwordEncoder;

    /**
     * @param passwordBuildCmd
     * @return
     */
    @Override
    public String execute(PasswordBuildCmd passwordBuildCmd) {
        AssertUtils.isTrue(passwordBuildCmd.verifySelf(),"密码不能为空");
        return passwordEncoder.encode(passwordBuildCmd.getUnencrypted());
    }
}
