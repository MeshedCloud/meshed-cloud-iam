package cn.meshed.cloud.iam.domain.dto.cmd;

import cn.meshed.base.cqrs.Command;
import lombok.Data;

import java.util.Set;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Data
public class LoginSuccessCmd implements Command {
    private Long id;
    private String loginId;
    private String phone;
    private String email;
    private Boolean validPhone;
    private Boolean validEmail;
    private Boolean expired;
    private Boolean locked;
    private Set<String> grantedAuthority;

    /**
     * @return
     */
    @Override
    public Boolean verifySelf() {
        return true;
    }
}
