package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
public class Apply {
    private int id;
    private int smallNum;
    private int bigNum;
    private String address;
    private String phone;
    private int ownerId;
    private String introduction;
    private Timestamp applyTime;
    private byte type;
    private Byte status;
    private User userByOwnerId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "small_num", nullable = false)
    public int getSmallNum() {
        return smallNum;
    }

    public void setSmallNum(int smallNum) {
        this.smallNum = smallNum;
    }

    @Basic
    @Column(name = "big_num", nullable = false)
    public int getBigNum() {
        return bigNum;
    }

    public void setBigNum(int bigNum) {
        this.bigNum = bigNum;
    }

    @Basic
    @Column(name = "address", nullable = false, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "owner_id", nullable = false)
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "introduction", nullable = false, length = 255)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Basic
    @Column(name = "apply_time", nullable = false)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Apply apply = (Apply) o;

        if (id != apply.id) return false;
        if (smallNum != apply.smallNum) return false;
        if (bigNum != apply.bigNum) return false;
        if (ownerId != apply.ownerId) return false;
        if (type != apply.type) return false;
        if (address != null ? !address.equals(apply.address) : apply.address != null) return false;
        if (phone != null ? !phone.equals(apply.phone) : apply.phone != null) return false;
        if (introduction != null ? !introduction.equals(apply.introduction) : apply.introduction != null) return false;
        if (applyTime != null ? !applyTime.equals(apply.applyTime) : apply.applyTime != null) return false;
        if (status != null ? !status.equals(apply.status) : apply.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + smallNum;
        result = 31 * result + bigNum;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + ownerId;
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (int) type;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByOwnerId() {
        return userByOwnerId;
    }

    public void setUserByOwnerId(User userByOwnerId) {
        this.userByOwnerId = userByOwnerId;
    }
}
