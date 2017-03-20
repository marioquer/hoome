package dao;

import entity.BookRecord;

import java.util.List;

/**
 * Created by marioquer on 2017/3/17.
 */
public interface BookRecordDao {

    boolean addRecord(BookRecord bookRecord);

    boolean updateRecord(BookRecord bookRecord);

    List<BookRecord> getRecordByUser(Integer id);
}
