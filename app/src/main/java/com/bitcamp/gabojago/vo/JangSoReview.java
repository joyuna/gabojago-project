package com.bitcamp.gabojago.vo;

import java.sql.Date;

public class JangSoReview {

  private int prvno; // 장소후기번호
  private String cont; // 내용
  private int recno; // 코스추천글번호
  private int plno; // 장소번호

  public int getPrvno() {
    return prvno;
  }

  public void setPrvno(int prvno) {
    this.prvno = prvno;
  }

  public String getCont() {
    return cont;
  }

  public void setCont(String cont) {
    this.cont = cont;
  }

  public int getRecno() {
    return recno;
  }

  public void setRecno(int recno) {
    this.recno = recno;
  }

  public int getPlno() {
    return plno;
  }

  public void setPlno(int plno) {
    this.plno = plno;
  }

  @Override
  public String toString() {
    return "JangSoReview{" +
            "prvno=" + prvno +
            ", cont='" + cont + '\'' +
            ", recno=" + recno +
            ", plno=" + plno +
            '}';
  }
}
