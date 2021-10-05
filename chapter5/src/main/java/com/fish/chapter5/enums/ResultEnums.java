package com.fish.chapter5.enums;

public enum ResultEnums {
  SUCCESS(0, "请求成功"), BAD_ARGUMENT(401, "参数不对"), BAD_ARGUMENT_VALUE(402, "参数值不对"), SERIOUS(500, "系统内部错误");

  private int code;

  private String msg;

  ResultEnums(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
