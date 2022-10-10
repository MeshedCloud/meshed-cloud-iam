package cn.meshed.cloud.iam.gatewayimpl.database.dataobject;

import cn.meshed.cloud.iam.domain.dto.enums.IAMStatus;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author by Vincent Vic
 * @since 2022-10-04
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("m_account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;


    /**
     * 账号登入主名称
     */
    private String loginId;

    /**
     * 账号手机号
     */
    private String phone;

    /**
     * 账号邮箱
     */
    private String email;

    /**
     * 账号手机号是否有效 0 否 1 是
     */
    @TableField("is_valid_phone")
    private Boolean validPhone;

    /**
     * 账号有效是否有效  0 否 1 是
     */
    @TableField("is_valid_email")
    private Boolean validEmail;

    /**
     * 账号加密后的密码
     */
    private String secretKey;


    /**
     * 是否过期 0 否 1 是
     */
    @TableField("is_expired")
    private Boolean expired;

    /**
     * 是否锁定 0 否 1 是
     */
    @TableField("is_locked")
    private Boolean locked;

    /**
     * 状态
     */
//    @TableField(value = "status",typeHandler = EnumOrdinalTypeHandler.class)
    private Integer status;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
