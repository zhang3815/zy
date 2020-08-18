package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "jiyun_person")
public class Person implements Serializable {
    @Id
    @Column(name = "p_id")
    private Integer pId;

    @Column(name = "b_id")
    private Integer bId;

    @Column(name = "p_name")
    private String pName;

    @Column(name = "p_age")
    private String pAge;

    @Column(name = "p_sex")
    private String pSex;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createtime;

    @Column(name = "p_like")
    private String pLike;

    @Column(name = "p_count")
    private String pCount;

    private static final long serialVersionUID = 1L;

    /**
     * @return p_id
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * @param pId
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * @return b_id
     */
    public Integer getbId() {
        return bId;
    }

    /**
     * @param bId
     */
    public void setbId(Integer bId) {
        this.bId = bId;
    }

    /**
     * @return p_name
     */
    public String getpName() {
        return pName;
    }

    /**
     * @param pName
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * @return p_age
     */
    public String getpAge() {
        return pAge;
    }

    /**
     * @param pAge
     */
    public void setpAge(String pAge) {
        this.pAge = pAge == null ? null : pAge.trim();
    }

    /**
     * @return p_sex
     */
    public String getpSex() {
        return pSex;
    }

    /**
     * @param pSex
     */
    public void setpSex(String pSex) {
        this.pSex = pSex == null ? null : pSex.trim();
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

    /**
     * @return p_like
     */
    public String getpLike() {
        return pLike;
    }

    /**
     * @param pLike
     */
    public void setpLike(String pLike) {
        this.pLike = pLike == null ? null : pLike.trim();
    }

    /**
     * @return p_count
     */
    public String getpCount() {
        return pCount;
    }

    /**
     * @param pCount
     */
    public void setpCount(String pCount) {
        this.pCount = pCount == null ? null : pCount.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pId=").append(pId);
        sb.append(", bId=").append(bId);
        sb.append(", pName=").append(pName);
        sb.append(", pAge=").append(pAge);
        sb.append(", pSex=").append(pSex);
        sb.append(", createtime=").append(createtime);
        sb.append(", pLike=").append(pLike);
        sb.append(", pCount=").append(pCount);
        sb.append("]");
        return sb.toString();
    }
}