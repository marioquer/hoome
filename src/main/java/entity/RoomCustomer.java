package entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by marioquer on 2017/3/14.
 */
@Entity
@Table(name = "room_customer")
public class RoomCustomer {
    private Integer record_id;
    private String name;
    private Integer gender;//0女，1男
    private String identity_id;

    public Integer getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Integer record_id) {
        this.record_id = record_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdentity_id() {
        return identity_id;
    }

    public void setIdentity_id(String identity_id) {
        this.identity_id = identity_id;
    }
}
