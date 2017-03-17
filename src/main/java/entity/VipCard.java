package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "vip_card", schema = "hoome", catalog = "")
public class VipCard {
    private int id;
    private int userId;
    private double balance;
    private byte level;
    private int point;
    private Timestamp createdAt;
    private Timestamp expiredAt;
    private byte status;
    private Collection<Balance> balancesById;
    private Collection<Point> pointsById;
    private User userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "balance", nullable = false, precision = 0)
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "expired_at", nullable = false)
    public Timestamp getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Timestamp expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Basic
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VipCard vipCard = (VipCard) o;

        if (id != vipCard.id) return false;
        if (userId != vipCard.userId) return false;
        if (Double.compare(vipCard.balance, balance) != 0) return false;
        if (level != vipCard.level) return false;
        if (point != vipCard.point) return false;
        if (status != vipCard.status) return false;
        if (createdAt != null ? !createdAt.equals(vipCard.createdAt) : vipCard.createdAt != null) return false;
        if (expiredAt != null ? !expiredAt.equals(vipCard.expiredAt) : vipCard.expiredAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + userId;
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) level;
        result = 31 * result + point;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (expiredAt != null ? expiredAt.hashCode() : 0);
        result = 31 * result + (int) status;
        return result;
    }

    @OneToMany(mappedBy = "vipCardByVipId")
    public Collection<Balance> getBalancesById() {
        return balancesById;
    }

    public void setBalancesById(Collection<Balance> balancesById) {
        this.balancesById = balancesById;
    }

    @OneToMany(mappedBy = "vipCardByVipId")
    public Collection<Point> getPointsById() {
        return pointsById;
    }

    public void setPointsById(Collection<Point> pointsById) {
        this.pointsById = pointsById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
