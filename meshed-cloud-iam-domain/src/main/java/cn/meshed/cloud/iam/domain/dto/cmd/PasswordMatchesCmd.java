package cn.meshed.cloud.iam.domain.dto.cmd;

import cn.meshed.base.cqrs.Command;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
@Data
public class PasswordMatchesCmd implements Command {

    private String unencrypted;
    private String encrypted;

    /**
     * @return
     */
    @Override
    public Boolean verifySelf() {
        return StringUtils.isNotBlank(unencrypted) && StringUtils.isNotBlank(encrypted);
    }
}
