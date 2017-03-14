package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name = "vip_level")
public class VipLevel {
    private Integer level;
    private Double discount;
    private Double point_level;
    private Double require;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getPoint_level() {
        return point_level;
    }

    public void setPoint_level(Double point_level) {
        this.point_level = point_level;
    }

    public Double getRequire() {
        return require;
    }

    public void setRequire(Double require) {
        this.require = require;
    }
}
