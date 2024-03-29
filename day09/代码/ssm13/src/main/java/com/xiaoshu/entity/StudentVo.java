package com.xiaoshu.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.StreamingHttpOutputMessage;

public class StudentVo extends Student {
private String cname;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date start;
@DateTimeFormat(pattern="yyyy-MM-dd")
private Date end;
private String num;

public String getNum() {
	return num;
}

public void setNum(String num) {
	this.num = num;
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

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

}
