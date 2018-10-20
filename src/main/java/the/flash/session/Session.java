package the.flash.session;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:MH
 * @Date:Created in 10:02 2018/10/20
 */
@Data
@NoArgsConstructor
public class Session {
    // 用户唯一性标识
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return userId + ":" + userName;
    }

}
