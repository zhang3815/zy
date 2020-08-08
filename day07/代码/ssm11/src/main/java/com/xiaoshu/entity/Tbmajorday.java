package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_major_day")
public class Tbmajorday implements Serializable {
    @Id
    @Column(name = "md_id")
    private Integer mdId;

    private String mdname;

    private static final long serialVersionUID = 1L;

    /**
     * @return md_id
     */
    public Integer getMdId() {
        return mdId;
    }

    /**
     * @param mdId
     */
    public void setMdId(Integer mdId) {
        this.mdId = mdId;
    }

    /**
     * @return mdname
     */
    public String getMdname() {
        return mdname;
    }

    /**
     * @param mdname
     */
    public void setMdname(String mdname) {
        this.mdname = mdname == null ? null : mdname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mdId=").append(mdId);
        sb.append(", mdname=").append(mdname);
        sb.append("]");
        return sb.toString();
    }
}