package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "room", schema = "hoome", catalog = "")
public class Room {
    private int id;
    private int hotelId;
    private byte roomStyle;
    private int remain;
    private double price;
    private Double specialPrice;
    private Timestamp specialTime;
    private Hotel hotelByHotelId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotel_id", nullable = false)
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room_style", nullable = false)
    public byte getRoomStyle() {
        return roomStyle;
    }

    public void setRoomStyle(byte roomStyle) {
        this.roomStyle = roomStyle;
    }

    @Basic
    @Column(name = "remain", nullable = false)
    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "special_price", nullable = true, precision = 0)
    public Double getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(Double specialPrice) {
        this.specialPrice = specialPrice;
    }

    @Basic
    @Column(name = "special_time", nullable = true)
    public Timestamp getSpecialTime() {
        return specialTime;
    }

    public void setSpecialTime(Timestamp specialTime) {
        this.specialTime = specialTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (hotelId != room.hotelId) return false;
        if (roomStyle != room.roomStyle) return false;
        if (remain != room.remain) return false;
        if (Double.compare(room.price, price) != 0) return false;
        if (specialPrice != null ? !specialPrice.equals(room.specialPrice) : room.specialPrice != null) return false;
        if (specialTime != null ? !specialTime.equals(room.specialTime) : room.specialTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = hotelId;
        result = 31 * result + (int) roomStyle;
        result = 31 * result + remain;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (specialPrice != null ? specialPrice.hashCode() : 0);
        result = 31 * result + (specialTime != null ? specialTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }
}
