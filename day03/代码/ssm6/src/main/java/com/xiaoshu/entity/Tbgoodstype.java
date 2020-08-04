package com.xiaoshu.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tb_goodstype")
public class Tbgoodstype implements Serializable {
    @Id
    @Column(name = "t_id")
    private Integer tId;

    @Column(name = "t_typename")
    private String tTypename;

    private static final long serialVersionUID = 1L;

    /**
     * @return t_id
     */
    public Integer gettId() {
        return tId;
    }

    /**
     * @param tId
     */
    public void settId(Integer tId) {
        this.tId = tId;
    }

    /**
     * @return t_typename
     */
    public String gettTypename() {
        return tTypename;
    }

    /**
     * @param tTypename
     */
    public void settTypename(String tTypename) {
        this.tTypename = tTypename == null ? null : tTypename.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tId=").append(tId);
        sb.append(", tTypename=").append(tTypename);
        sb.append("]");
        return sb.toString();
    }
}