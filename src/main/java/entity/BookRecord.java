package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name = "book_record")
public class BookRecord {
    @Id
    private Integer id;
    private Integer booker_id;
    private Double discount;
    private Double amount;
    private Integer hotel_id;
    private Integer room_style;//0单人房，1双人房
    private Integer status;//0已预订，1已入住，2已退房，-1已取消
    private Date book_time;
    private Date in_time;
    private Date out_time;
    private Integer pay_method;//0现金，1会员卡支付

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBooker_id() {
        return booker_id;
    }

    public void setBooker_id(Integer booker_id) {
        this.booker_id = booker_id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBook_time() {
        return book_time;
    }

    public void setBook_time(Date book_time) {
        this.book_time = book_time;
    }

    public Date getIn_time() {
        return in_time;
    }

    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }

    public Date getOut_time() {
        return out_time;
    }

    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }

    public Integer getPay_method() {
        return pay_method;
    }

    public void setPay_method(Integer pay_method) {
        this.pay_method = pay_method;
    }
}

