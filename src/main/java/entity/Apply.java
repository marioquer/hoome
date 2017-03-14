package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name="apply")
public class Apply {
    @Id
    private Integer id;
    private Integer small_num;
    private Integer big_num;
    private String address;
    private String phone;
    private Integer owner_id;
    private String introduction;
    private Date apply_time;
    private Integer type;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSmall_num() {
        return small_num;
    }

    public void setSmall_num(Integer small_num) {
        this.small_num = small_num;
    }

    public Integer getBig_num() {
        return big_num;
    }

    public void setBig_num(Integer big_num) {
        this.big_num = big_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getApply_time() {
        return apply_time;
    }

    public void setApply_time(Date apply_time) {
        this.apply_time = apply_time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
