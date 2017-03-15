package entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name = "room")
public class Room {
    private Integer hotel_id;
    private Integer room_style;//0单人房，1双人房
    private Integer remain;
    private Double price;
    private Double special_price;
    private Date special_time;

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_style() {
        return room_style;
    }

    public void setRoom_style(Integer room_style) {
        this.room_style = room_style;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSpecial_price() {
        return special_price;
    }

    public void setSpecial_price(Double special_price) {
        this.special_price = special_price;
    }

    public Date getSpecial_time() {
        return special_time;
    }

    public void setSpecial_time(Date special_time) {
        this.special_time = special_time;
    }
}
