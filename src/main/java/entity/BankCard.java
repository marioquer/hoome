package entity;

import javax.persistence.*;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "bank_card", schema = "hoome", catalog = "")
public class BankCard {
    private String id;
    private int userId;
    private String bank;
    private User userByUserId;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    @Column(name = "bank", nullable = false, length = 60)
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankCard bankCard = (BankCard) o;

        if (userId != bankCard.userId) return false;
        if (id != null ? !id.equals(bankCard.id) : bankCard.id != null) return false;
        if (bank != null ? !bank.equals(bankCard.bank) : bankCard.bank != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + userId;
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        return result;
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
