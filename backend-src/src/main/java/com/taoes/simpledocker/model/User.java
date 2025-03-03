package com.taoes.simpledocker.model;

import lombok.Data;

/**
 * 用户对象
 *
 * @author 枕上江南 zhoutao925638@vip.qq.com
 * @date 2021/12/15 1:26 下午
 */
@Data
public class User {


  private Long id;

  /**
   * 用户名
   */
  private String username;


  /**
   * 创建时间
   */
  private String createdAt;

  /**
   * 更新时间
   */
  private String updatedAt;

}
