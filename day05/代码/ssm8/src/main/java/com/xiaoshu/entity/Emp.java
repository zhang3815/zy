package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "e_emp")
public class Emp implements Serializable {
    @Id
    @Column(name = "e_id")
    private Integer eId;

    @Column(name = "e_name")
    private String eName;
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private Integer age;

    private String pic;

    @Column(name = "d_depid")
    private Integer dDepid;

    private String hobby;

    private static final long serialVersionUID = 1L;

    /**
     * @return e_id
     */
    public Integer geteId() {
        return eId;
    }

    /**
     * @param eId
     */
    public void seteId(Integer eId) {
        this.eId = eId;
    }

    /**
     * @return e_name
     */
    public String geteName() {
        return eName;
    }

    /**
     * @param eName
     */
    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    /**
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * @param pic
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

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
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eId=").append(eId);
        sb.append(", eName=").append(eName);
        sb.append(", birthday=").append(birthday);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", pic=").append(pic);
        sb.append(", dDepid=").append(dDepid);
        sb.append(", hobby=").append(hobby);
        sb.append("]");
        return sb.toString();
    }
}