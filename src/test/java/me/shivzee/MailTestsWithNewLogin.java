package me.shivzee;

import me.shivzee.util.JMailBuilder;
import me.shivzee.util.Message;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MailTestsWithNewLogin {
    private static String EMAIL = "aarahman@edny.net";
    private static final String PASSWORD = "Aarahman@1234";
    JMailTM jMailTM;

    @BeforeClass
    public void beforeClass() throws Exception {
        jMailTM = JMailBuilder.login(EMAIL, PASSWORD);
        MailTestModule.setJMailTm(jMailTM);
        System.out.println("BearerToken : " + jMailTM.bearerToken);
        System.out.println("ID : " + jMailTM.id);
    }

    @Test(invocationCount = 10)
    public void testFetchMessageOnANewInbox() throws Exception {
        //Created a new object everytime to avoid threading issues
        List<Message> messages = new MailTestModule().fetchMails();
        System.out.println("Mails in a new inbox : " + messages.size());
        Assert.assertEquals(messages.size(), 1, "Mails in a new inbox should be 0");
    }
}
