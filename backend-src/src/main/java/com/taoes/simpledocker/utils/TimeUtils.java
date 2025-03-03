package com.taoes.simpledocker.utils;

import cn.hutool.core.date.LocalDateTimeUtil;
import java.time.LocalDateTime;

public class TimeUtils {

  public static String format(LocalDateTime time) {
    return LocalDateTimeUtil.format(time, "yyyy-MM-dd HH:mm:ss");
  }

}
