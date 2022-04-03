import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    private JSpinner rows;
    private JSpinner cols;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        label = new JLabel("Grid size: ");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        JLabel colLabel = new JLabel("Columns: ");
        colLabel.setForeground(Color.BLACK);

        cols = new JSpinner(new SpinnerNumberModel(4, 2, 500, 1));

        JLabel rowLabel = new JLabel("Rows: ");
        rowLabel.setForeground(Color.BLACK);

        rows = new JSpinner(new SpinnerNumberModel(2,1,100,1));

        add(label);
        add(spinner);
        add(colLabel);
        add(cols);
        add(rowLabel);
        add(rows);


    }

    public Integer getRows() {
        return (Integer) rows.getValue();
    }

    public Integer getCols() {
        return (Integer) cols.getValue();
    }
}
