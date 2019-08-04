import com.aliyuncs.exceptions.ClientException;
import com.itheima.utils.SMSUtils;

public class Test {
    @org.junit.Test
    public void test1() throws ClientException {
        SMSUtils.sendShortMessage(SMSUtils.VALIDATE_CODE, "13040825957", "1234");
    }
}
