package cn.meshed.cloud.iam.domain.dto.cmd;

import cn.meshed.base.cqrs.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class DoLoginHandleCmd implements Command {

    private String loginName;
    private String password;

    /**
     * @return
     */
    @Override
    public Boolean verifySelf() {
        return StringUtils.isNotBlank(loginName) && StringUtils.isNotBlank(password);
    }
}
