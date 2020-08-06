package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "d_dept")
public class Dept implements Serializable {
    @Id
    @Column(name = "d_depid")
    private Integer dDepid;

    @Column(name = "d_dname")
    private String dDname;

    private static final long serialVersionUID = 1L;

    /**
     * @return d_depid
     */
    public Integer getdDepid() {
        return dDepid;
    }

    /**
     * @param dDepid
     */
    public void setdDepid(Integer dDepid) {
        this.dDepid = dDepid;
    }

    /**
     * @return d_dname
     */
    public String getdDname() {
        return dDname;
    }

    /**
     * @param dDname
     */
    public void setdDname(String dDname) {
        this.dDname = dDname == null ? null : dDname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dDepid=").append(dDepid);
        sb.append(", dDname=").append(dDname);
        sb.append("]");
        return sb.toString();
    }
}