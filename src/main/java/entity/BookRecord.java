package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "book_record", schema = "hoome", catalog = "")
public class BookRecord {
    private long id;
    private int bookerId;
    private double discount;
    private double amount;
    private int hotelId;
    private byte roomStyle;
    private byte status;
    private Timestamp bookTime;
    private Timestamp inTime;
    private Timestamp outTime;
    private Byte payMethod;
    private User userByBookerId;
    private Hotel hotelByHotelId;
    private Collection<RoomCustomer> roomCustomersById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "booker_id", nullable = false)
    public int getBookerId() {
        return bookerId;
    }

    public void setBookerId(int bookerId) {
        this.bookerId = bookerId;
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
    @Column(name = "amount", nullable = false, precision = 0)
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
    @Column(name = "status", nullable = false)
    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "book_time", nullable = false)
    public Timestamp getBookTime() {
        return bookTime;
    }

    public void setBookTime(Timestamp bookTime) {
        this.bookTime = bookTime;
    }

    @Basic
    @Column(name = "in_time", nullable = true)
    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    @Basic
    @Column(name = "out_time", nullable = true)
    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    @Basic
    @Column(name = "pay_method", nullable = true)
    public Byte getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Byte payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookRecord that = (BookRecord) o;

        if (id != that.id) return false;
        if (bookerId != that.bookerId) return false;
        if (Double.compare(that.discount, discount) != 0) return false;
        if (Double.compare(that.amount, amount) != 0) return false;
        if (hotelId != that.hotelId) return false;
        if (roomStyle != that.roomStyle) return false;
        if (status != that.status) return false;
        if (bookTime != null ? !bookTime.equals(that.bookTime) : that.bookTime != null) return false;
        if (inTime != null ? !inTime.equals(that.inTime) : that.inTime != null) return false;
        if (outTime != null ? !outTime.equals(that.outTime) : that.outTime != null) return false;
        if (payMethod != null ? !payMethod.equals(that.payMethod) : that.payMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + bookerId;
        temp = Double.doubleToLongBits(discount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + hotelId;
        result = 31 * result + (int) roomStyle;
        result = 31 * result + (int) status;
        result = 31 * result + (bookTime != null ? bookTime.hashCode() : 0);
        result = 31 * result + (inTime != null ? inTime.hashCode() : 0);
        result = 31 * result + (outTime != null ? outTime.hashCode() : 0);
        result = 31 * result + (payMethod != null ? payMethod.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "booker_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByBookerId() {
        return userByBookerId;
    }

    public void setUserByBookerId(User userByBookerId) {
        this.userByBookerId = userByBookerId;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Hotel getHotelByHotelId() {
        return hotelByHotelId;
    }

    public void setHotelByHotelId(Hotel hotelByHotelId) {
        this.hotelByHotelId = hotelByHotelId;
    }

    @OneToMany(mappedBy = "bookRecordByRecordId")
    public Collection<RoomCustomer> getRoomCustomersById() {
        return roomCustomersById;
    }

    public void setRoomCustomersById(Collection<RoomCustomer> roomCustomersById) {
        this.roomCustomersById = roomCustomersById;
    }
}
