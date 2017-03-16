package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
public class Point {
    private int id;
    private int vipId;
    private byte type;
    private int point;
    private int balance;
    private Timestamp time;
    private VipCard vipCardByVipId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vip_id", nullable = false)
    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
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
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Basic
    @Column(name = "balance", nullable = false)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point1 = (Point) o;

        if (id != point1.id) return false;
        if (vipId != point1.vipId) return false;
        if (type != point1.type) return false;
        if (point != point1.point) return false;
        if (balance != point1.balance) return false;
        if (time != null ? !time.equals(point1.time) : point1.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + vipId;
        result = 31 * result + (int) type;
        result = 31 * result + point;
        result = 31 * result + balance;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "vip_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public VipCard getVipCardByVipId() {
        return vipCardByVipId;
    }

    public void setVipCardByVipId(VipCard vipCardByVipId) {
        this.vipCardByVipId = vipCardByVipId;
    }
}
