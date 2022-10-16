package cn.meshed.cloud.iam.executor;

import cn.meshed.base.cqrs.CommandExecute;
import cn.meshed.base.utils.AssertUtils;
import cn.meshed.cloud.iam.domain.dto.cmd.PasswordBuildCmd;
import cn.meshed.cloud.iam.domain.dto.cmd.PasswordMatchesCmd;
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
public class PasswordMatchesCmdExe implements CommandExecute<PasswordMatchesCmd, Boolean> {

    private final PasswordEncoder passwordEncoder;

    /**
     * @param passwordMatchesCmd
     * @return
     */
    @Override
    public Boolean execute(PasswordMatchesCmd passwordMatchesCmd) {
        AssertUtils.isTrue(passwordMatchesCmd.verifySelf(),"密码不能为空");
        return passwordEncoder.matches(passwordMatchesCmd.getUnencrypted(),passwordMatchesCmd.getEncrypted());
    }
}
