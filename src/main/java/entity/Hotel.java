package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
public class Hotel {
    private int id;
    private int smallNum;
    private int bigNum;
    private String address;
    private String phone;
    private int ownerId;
    private String introduction;
    private Collection<BookRecord> bookRecordsById;
    private User userByOwnerId;
    private Collection<Room> roomsById;
    private String name;

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
    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "introduction", nullable = true, length = 255)
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (id != hotel.id) return false;
        if (smallNum != hotel.smallNum) return false;
        if (bigNum != hotel.bigNum) return false;
        if (ownerId != hotel.ownerId) return false;
        if (address != null ? !address.equals(hotel.address) : hotel.address != null) return false;
        if (phone != null ? !phone.equals(hotel.phone) : hotel.phone != null) return false;
        if (introduction != null ? !introduction.equals(hotel.introduction) : hotel.introduction != null) return false;

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
        return result;
    }

    @OneToMany(mappedBy = "hotelByHotelId")
    public Collection<BookRecord> getBookRecordsById() {
        return bookRecordsById;
    }

    public void setBookRecordsById(Collection<BookRecord> bookRecordsById) {
        this.bookRecordsById = bookRecordsById;
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public User getUserByOwnerId() {
        return userByOwnerId;
    }

    public void setUserByOwnerId(User userByOwnerId) {
        this.userByOwnerId = userByOwnerId;
    }

    @OneToMany(mappedBy = "hotelByHotelId")
    public Collection<Room> getRoomsById() {
        return roomsById;
    }

    public void setRoomsById(Collection<Room> roomsById) {
        this.roomsById = roomsById;
    }


}
