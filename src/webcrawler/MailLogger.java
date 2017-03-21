package webcrawler;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailLogger implements Logger {
    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String FROM = "webcrawlernotify@gmail.com";
    private static final String PASSWORD = "BardzoTrudneHaslo123";
    private static final String TO = "webcrawlernotify@gmail.com";
    @Override
    public void log(String status, Student student){
        Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtps");
        properties.put("mail.smtps.auth","true");
        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);

        try
        {
            message.setSubject("Student " +status);
            message.setContent(student.getMark() + " " + student.getFirstName() + " " + student.getLastName() + " " + student.getAge(), "text/plain; charset=ISO-8859-2");
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TO));
            Transport transport = mailSession.getTransport();
            transport.connect(HOST, PORT, FROM, PASSWORD);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
