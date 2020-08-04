package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "tb_goods")
public class Tbgoods implements Serializable {
    @Id
    @Column(name = "g_id")
    private Integer gId;

    @Column(name = "t_id")
    private Integer tId;

    private String name;

    private Integer price;
    	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    private static final long serialVersionUID = 1L;

    /**
     * @return g_id
     */
    public Integer getgId() {
        return gId;
    }

    /**
     * @param gId
     */
    public void setgId(Integer gId) {
        this.gId = gId;
    }

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
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
        sb.append(", gId=").append(gId);
        sb.append(", tId=").append(tId);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", createtime=").append(createtime);
        sb.append("]");
        return sb.toString();
    }
}