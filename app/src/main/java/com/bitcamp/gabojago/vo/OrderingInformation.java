package com.bitcamp.gabojago.vo;

import java.util.Date;

public class OrderingInformation {
  
  int extkno;
  
  String id;
  
  int exno;
  
  int cnt;
  
  String purDate;
  
  String payment;
  
  Date ccDate;
  
  public int getExtkno() {
    return extkno;
  }

  public void setExtkno(int extkno) {
    this.extkno = extkno;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getExno() {
    return exno;
  }

  public void setExno(int exno) {
    this.exno = exno;
  }

  public int getCnt() {
    return cnt;
  }

  public void setCnt(int cnt) {
    this.cnt = cnt;
  }

  public String getPurDate() {
    return purDate;
  }

  public void setPurDate(String purDate) {
    this.purDate = purDate;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  public Date getCcDate() {
    return ccDate;
  }

  public void setCcDate(Date ccDate) {
    this.ccDate = ccDate;
  }
}
