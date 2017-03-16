package entity;

import javax.persistence.*;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "vip_level", schema = "hoome", catalog = "")
public class VipLevel {
    private byte level;
    private double discount;
    private double pointLevel;
    private double require;

    @Id
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Basic
    @Column(name = "discount", nullable = false, precision = 0)
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "point_level", nullable = false, precision = 0)
    public double getPointLevel() {
        return pointLevel;
    }

    public void setPointLevel(double pointLevel) {
        this.pointLevel = pointLevel;
    }

    @Basic
    @Column(name = "require", nullable = false, precision = 0)
    public double getRequire() {
        return require;
    }

    public void setRequire(double require) {
        this.require = require;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VipLevel vipLevel = (VipLevel) o;

        if (level != vipLevel.level) return false;
        if (Double.compare(vipLevel.discount, discount) != 0) return false;
        if (Double.compare(vipLevel.pointLevel, pointLevel) != 0) return false;
        if (Double.compare(vipLevel.require, require) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) level;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pointLevel);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(require);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
