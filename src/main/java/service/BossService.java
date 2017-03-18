package service;

import java.util.Map;

/**
 * Created by marioquer on 2017/3/18.
 */
public interface BossService {
    Map<String,Object> getAllApply();

    boolean approveNew(Integer id);

    boolean approveChange(Integer id);
}
