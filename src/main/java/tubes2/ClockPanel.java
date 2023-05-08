package tubes2;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ClockPanel extends JPanel implements Runnable {
    private final SimpleDateFormat timeFormat;
    private final SimpleDateFormat dayDateFormat;
    private final JLabel timeLabel;
    private final JLabel dayDateLabel;

    public ClockPanel() {
        // Date
        dayDateFormat = new SimpleDateFormat("E, d MMMM y");
        dayDateLabel = new JLabel();
        dayDateLabel.setPreferredSize(new Dimension(100,100));
        dayDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dayDateLabel.setFont(new Font(dayDateLabel.getFont().getName(), dayDateLabel.getFont().getStyle(), 20));


        // Time
        timeFormat = new SimpleDateFormat("HH:mm:ss");
        timeLabel = new JLabel();
        timeLabel.setPreferredSize(new Dimension(100,100));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font(timeLabel.getFont().getName(), Font.BOLD, 30));


        // Panel
        setBorder(BorderFactory.createRaisedBevelBorder());
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout(0,0));
        add(dayDateLabel, BorderLayout.NORTH);
        add(timeLabel, BorderLayout.SOUTH);
        setPreferredSize(new Dimension(400,140));
        setTime();
    }

    public void setTime() {
        Thread clockThread = new Thread(this);
        clockThread.start();
    }


    @Override
    public void run() {
        while (true) {
            // Set Date
            String dayDate = dayDateFormat.format(Calendar.getInstance().getTime());
            dayDateLabel.setText(dayDate);

            // Set Time
            String time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
