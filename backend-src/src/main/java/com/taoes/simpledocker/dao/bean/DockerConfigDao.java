package com.taoes.simpledocker.dao.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.taoes.simpledocker.model.enums.DockerConfigType;
import lombok.Data;

/**
 * docker 服务端配置
 *
 * @author 枕上江南 zhoutao925638@vip.qq.com
 * @date 2021/12/15 1:11 下午
 */
@Data
@TableName("docker")
public class DockerConfigDao {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 配置名
     */
    private String name;

    /**
     * 主机地址
     */
    private String host;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * ssl
     */
    private Boolean ssl;

    /**
     * 配置的类型
     */
    private DockerConfigType type;

}
