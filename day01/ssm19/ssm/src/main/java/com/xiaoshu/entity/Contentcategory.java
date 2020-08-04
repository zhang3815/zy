package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Contentcategory implements Serializable {
    @Id
    private Integer yid;

    private String yname;


    
    private String status;
  @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return yid
     */
    public Integer getYid() {
        return yid;
    }

    /**
     * @param yid
     */
    public void setYid(Integer yid) {
        this.yid = yid;
    }

    /**
     * @return yname
     */
    public String getYname() {
        return yname;
    }

    /**
     * @param yname
     */
    public void setYname(String yname) {
        this.yname = yname == null ? null : yname.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", yid=").append(yid);
        sb.append(", yname=").append(yname);
        sb.append(", status=").append(status);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}