package com.bitcamp.gabojago.vo;

public class JangSoReviewAttachedFile {
  private int recofno; // 장소후기첨부파일번호
  private int prvno; // 장소후기번호
  private String path; // 파일경로
  private String fname; // 파일이름

  public JangSoReviewAttachedFile() {}

  public JangSoReviewAttachedFile(String path, String filename) {
    this.path = path;
    this.fname = filename;
  }

  public int getRecofno() {
    return recofno;
  }

  public void setRecofno(int recofno) {
    this.recofno = recofno;
  }

  public int getPrvno() {
    return prvno;
  }

  public void setPrvno(int prvno) {
    this.prvno = prvno;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  @Override
  public String toString() {
    return "AttachedFile{" +
            "recofno=" + recofno +
            ", prvno=" + prvno +
            ", filepath='" + path + '\'' +
            ", fname='" + fname + '\'' +
            '}';
  }
}
