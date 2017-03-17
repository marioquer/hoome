package entity;

import javax.persistence.*;

/**
 * Created by marioquer on 2017/3/15.
 */
@Entity
@Table(name = "room_customer", schema = "hoome", catalog = "")
public class RoomCustomer {
    private long id;
    private long recordId;
    private String name;
    private byte gender;
    private String identityId;
    private BookRecord bookRecordByRecordId;

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
    @Column(name = "record_id", nullable = false)
    public long getRecordId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "identity_id", nullable = false, length = 20)
    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomCustomer that = (RoomCustomer) o;

        if (recordId != that.recordId) return false;
        if (gender != that.gender) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (identityId != null ? !identityId.equals(that.identityId) : that.identityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (recordId ^ (recordId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (identityId != null ? identityId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "record_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public BookRecord getBookRecordByRecordId() {
        return bookRecordByRecordId;
    }

    public void setBookRecordByRecordId(BookRecord bookRecordByRecordId) {
        this.bookRecordByRecordId = bookRecordByRecordId;
    }
}
