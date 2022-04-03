import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1,4));
        saveBtn.addActionListener(this::save);
        exitBtn.addActionListener(this::exit);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
    }

    private void reset(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void load(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void exit(ActionEvent actionEvent) {
        frame.dispose();
    }

    private void save(ActionEvent actionEvent) {
        frame.dispose();
    }
}
