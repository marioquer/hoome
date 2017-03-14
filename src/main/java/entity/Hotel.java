package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    private Integer id;
    private Integer small_num;
    private Integer big_num;
    private String address;
    private String phone;
    private Integer owner_id;
    private String introduction;

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
}
