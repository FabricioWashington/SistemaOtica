package Sistema.FrontEnd.Componentes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void sendEmail(String to, String subject, String body) {
        // Configurações para o Gmail
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Informações de login do Gmail
        String username = "W4sh1ngtonTechnology@gmail.com";
        String password = "favx aktt tgkj bitp";

        // Cria uma sessão com autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Cria a mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Envia a mensagem
            Transport.send(message);

            System.out.println("E-mail enviado com sucesso para: " + to);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
          // Obter a data e hora atuais
    Calendar calendarioAtual = Calendar.getInstance();
    Date dataAtual = calendarioAtual.getTime();

    // Adicionar uma hora à hora atual para obter o horário de expiração
    Calendar calendarioExpiracao = Calendar.getInstance();
    calendarioExpiracao.add(Calendar.HOUR_OF_DAY, 1);
    Date dataExpiracao = calendarioExpiracao.getTime();

    // Converter as datas para o formato desejado
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    String expirationDate = sdf.format(dataExpiracao);

    String to = "destinatario@example.com";
    String subject = "Assunto do e-mail";
    String body = "Corpo do e-mail";

        sendEmail(to, subject, body);
    }
}
