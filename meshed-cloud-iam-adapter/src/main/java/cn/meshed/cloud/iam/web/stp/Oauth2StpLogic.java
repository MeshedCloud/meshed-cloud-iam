package cn.meshed.cloud.iam.web.stp;

import cn.dev33.satoken.stp.StpLogic;

/**
 * <h1></h1>
 *
 * @author Vincent Vic
 * @version 1.0
 */
public class Oauth2StpLogic extends StpLogic {
    /**
     * 初始化StpLogic, 并指定账号类型
     *
     */
    public Oauth2StpLogic() {
        super("oauth2");
    }
}
