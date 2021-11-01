package com.xz.parking.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Set;


/**
 * t_admin
 * 管理员表 系统管理者
 *
 * @author User(EMAIL) 2021/10/13 15:02:02
 * @version 1.0
 * Generated by javascript
 * <p>
 * t_admin(管理员表)
 * //系统管理者
 * -------------------------------------------
 * id(编号)                   PKInteger   //<<自增长>>
 * employee_no(人员编号)      Integer     //<<普通索引,非空>>当前用户ID
 * passwd(登录口令)           String(255)
 * name(名称)                 String(255)
 * is_enable(是否启用)        Bool        //<<非空,缺省值:0>>0=false,1=true
 * create_date(创建日期)      Date        //<<缺省值:sysdate>>默认为当前时间
 * update_date(更新时间)      Date        //修改时间
 */


/**
 * 管理员表 系统管理者
 */
@Data
public class AdminPo implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 人员编号 当前用户ID
     */
    private String employeeNo;
    /**
     * 登录口令
     */
    private String passwd;
    /**
     * 名称
     */
    private String name;
    /**
     * 是否启用 0=false,1=true
     */
    private Boolean isEnable;
    /**
     * 创建日期 默认为当前时间
     */
    private Date createDate;
    /**
     * 更新时间 修改时间
     */
    private Date updateDate;

    /**
     * 角色列表
     */
    private Set<RolePo> roles;
}

