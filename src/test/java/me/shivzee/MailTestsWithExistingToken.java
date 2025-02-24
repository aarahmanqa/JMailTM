package me.shivzee;

import me.shivzee.util.Message;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MailTestsWithExistingToken {
    private static String EMAIL = "aarahman@edny.net";
    private static final String PASSWORD = "Aarahman@1234";
    JMailTM jMailTM;

    @BeforeClass
    public void beforeClass() throws Exception {
        jMailTM = new JMailTM("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpYXQiOjE3NDAzMTkxNzksInJvbGVzIjpbIlJPTEVfVVNFUiJdLCJhZGRyZXNzIjoiYWFyYWhtYW5AZWRueS5uZXQiLCJpZCI6IjY3Yjk5MjliNjg2YjRjNDBiNTA1YzYyZSIsIm1lcmN1cmUiOnsic3Vic2NyaWJlIjpbIi9hY2NvdW50cy82N2I5OTI5YjY4NmI0YzQwYjUwNWM2MmUiXX19.jtR4UD6tJwPH6K1iv7fBMdmDBu6RvJbNe4HmDmit1byCkM4MnUox3vqxI1GH-w4N4tpFK1LFful4cGHd3jsNAA", "67b9929b686b4c40b505c62e");
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
