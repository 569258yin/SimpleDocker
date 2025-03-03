package com.taoes.simpledocker.dao.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 系统配置表
 *
 * @author 枕上江南 zhoutao925638@vip.qq.com
 * @date 2021/12/15 1:11 下午
 */
@Data
@TableName("system_config")
public class ConfigDao {
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 配置名
     */
    private String name;

    /**
     * 主机地址
     */
    private String value;

    /**
     * 配置版本
     */
    private String version;

}
