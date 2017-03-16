package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "user", schema = "hoome", catalog = "")
public class User {
    private int id;
    private String phone;
    private String name;
    private String password;
    private byte role;
    private Collection<Apply> appliesById;
    private Collection<BankCard> bankCardsById;
    private Collection<BookRecord> bookRecordsById;
    private Collection<Hotel> hotelsById;
    private Collection<VipCard> vipCardsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 11)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = false)
    public byte getRole() {
        return role;
    }

    public void setRole(byte role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) role;
        return result;
    }

    @OneToMany(mappedBy = "userByOwnerId")
    public Collection<Apply> getAppliesById() {
        return appliesById;
    }

    public void setAppliesById(Collection<Apply> appliesById) {
        this.appliesById = appliesById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<BankCard> getBankCardsById() {
        return bankCardsById;
    }

    public void setBankCardsById(Collection<BankCard> bankCardsById) {
        this.bankCardsById = bankCardsById;
    }

    @OneToMany(mappedBy = "userByBookerId")
    public Collection<BookRecord> getBookRecordsById() {
        return bookRecordsById;
    }

    public void setBookRecordsById(Collection<BookRecord> bookRecordsById) {
        this.bookRecordsById = bookRecordsById;
    }

    @OneToMany(mappedBy = "userByOwnerId")
    public Collection<Hotel> getHotelsById() {
        return hotelsById;
    }

    public void setHotelsById(Collection<Hotel> hotelsById) {
        this.hotelsById = hotelsById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<VipCard> getVipCardsById() {
        return vipCardsById;
    }

    public void setVipCardsById(Collection<VipCard> vipCardsById) {
        this.vipCardsById = vipCardsById;
    }
}
