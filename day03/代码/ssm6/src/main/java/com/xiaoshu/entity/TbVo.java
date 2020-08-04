package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbVo extends Tbgoods {
private String cname;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date end;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date start;

public Date getEnd() {
	return end;
}

public void setEnd(Date end) {
	this.end = end;
}

public Date getStart() {
	return start;
}

public void setStart(Date start) {
	this.start = start;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

}
