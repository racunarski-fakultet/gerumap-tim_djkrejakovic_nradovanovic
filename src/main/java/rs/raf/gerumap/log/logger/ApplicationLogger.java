package rs.raf.gerumap.log.logger;

import rs.raf.gerumap.gui.swing.view.MainWindow;
import rs.raf.gerumap.log.model.Message;

import javax.swing.JOptionPane;
import java.text.MessageFormat;

public class ApplicationLogger implements ILogger {

    @Override
    public void log(Message message) {
        if (!message.isApplicationMessage())
            return;

        String displayMessage = message.getMessage() + '.';

        String title = "GeRuMap - " + message.getSeverity().getType();

        int swingMessageType = message.getSeverity().getSwingMessageType();

        JOptionPane.showMessageDialog(MainWindow.window, displayMessage, title, swingMessageType);

    }

    @Override
    public void log(Message message, String extend) {
        if (!message.isApplicationMessage())
            return;

        String displayMessage = MessageFormat.format("{0}. ({1})", message.getMessage(), extend);

        String title = "GeRuMap - " + message.getSeverity().getType();

        int swingMessageType = message.getSeverity().getSwingMessageType();

        JOptionPane.showMessageDialog(MainWindow.window, displayMessage, title, swingMessageType);
    }

    @Override
    public void close() { }

}
