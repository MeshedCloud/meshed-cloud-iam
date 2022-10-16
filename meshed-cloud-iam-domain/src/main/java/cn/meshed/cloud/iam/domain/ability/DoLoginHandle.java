package cn.meshed.cloud.iam.domain.ability;

import cn.meshed.cloud.iam.domain.dto.cmd.LoginSuccessCmd;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public interface DoLoginHandle {

    /**
     * 登入处理器
     * @param loginName
     * @param password
     * @return
     */
    SingleResponse<LoginSuccessCmd> loginHandle(String loginName, String password);
}
