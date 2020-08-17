package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentVo extends Student {
private String canme;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date start;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date end;
private Integer num;
public String getCanme() {
	return canme;
}
public void setCanme(String canme) {
	this.canme = canme;
}
public Date getStart() {
	return start;
}
public void setStart(Date start) {
	this.start = start;
}
public Date getEnd() {
	return end;
}
public void setEnd(Date end) {
	this.end = end;
}
public Integer getNum() {
	return num;
}
public void setNum(Integer num) {
	this.num = num;
}

}
