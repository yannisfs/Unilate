import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.math.*;

class Unilate implements Runnable{

    private JFrame window;

    private int height;
    private int width;

    public Unilate(){
        height = 400;
        width = 600;
    }

    public void setup(){
        this.window = new JFrame("Unilate");
        this.window.setSize(width, height);
        this.window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void run(){
        setup();

        JLabel unit1 = new JLabel("");
        JLabel unit2 = new JLabel("");
    
        JPanel dropdownPanel = new JPanel();

        JTextField unit1Field = new JTextField("");
        JTextField unit2Field = new JTextField("");

        JPanel unit1Panel = new JPanel();
        JPanel unit2Panel = new JPanel();

        JPanel factorPanel = new JPanel();

        JLabel factorLabel = new JLabel("");

        UnilateFormatter formatter = new UnilateFormatter();

        ArrayList<String> results = formatter.readCSV("CSV-files/book.csv");
        String[] choices = new String[results.size() / 4];
        for (int i = 4; i <= results.size(); i += 4){
            choices[i / 4 -1] = results.get(i -1);
        }



        final JComboBox<String> cb = new JComboBox<String>(choices);

        JSlider decPlaces = new JSlider(1, 10, 5);

        decPlaces.setPaintTicks(true);
        decPlaces.setMajorTickSpacing(5);
        decPlaces.setMinorTickSpacing(1);

        unit1.setText(results.get((cb.getSelectedIndex() + 1) * 4 - 4));
        unit2.setText(results.get((cb.getSelectedIndex() + 1) * 4 - 2));
        
        factorLabel.setText(":  <- " + results.get((cb.getSelectedIndex() + 1) * 4 -3) + " ->  *");
        
        unit1Panel.add(unit1);
        unit1Panel.add(unit1Field);
        unit2Panel.add(unit2);
        unit2Panel.add(unit2Field);

        factorPanel.add(factorLabel);

        dropdownPanel.add(cb);
        dropdownPanel.add(decPlaces);

        this.window.setLayout(null);
        this.window.add(dropdownPanel);
        this.window.add(unit1Panel);
        this.window.add(unit2Panel);
        this.window.add(factorPanel);

        unit1Panel.setLayout(null);
        unit2Panel.setLayout(null);
        factorLabel.setLayout(null);
        dropdownPanel.setLayout(null);


        unit1.setBounds(0, 0, 100, 30);
        unit2.setBounds(0, 0, 100, 30);

        unit1Field.setBounds(0, 30, 100, 30);
        unit2Field.setBounds(0, 30, 100, 30);

        factorLabel.setBounds(100, 0, 200, 100);

        factorPanel.setBounds(150, 230, 300, 200);

        unit1Panel.setBounds(100, 200, 130, 200);
        unit2Panel.setBounds(400, 200, 130, 200);

        cb.setBounds(0, 0, 200, 30);
        decPlaces.setBounds(230, 0, 150, 30);

        dropdownPanel.setBounds(100, 100, 380, 100);

        window.setVisible(true);

        cb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedIndex = (cb.getSelectedIndex() + 1) * 4;
                unit1.setText(results.get(selectedIndex - 4));
                unit2.setText(results.get(selectedIndex - 2));
                factorLabel.setText(":  <- " + results.get(selectedIndex -3) + " ->  *");
            }
        });
        
        unit1Field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    double result = Double.parseDouble(unit1Field.getText()) * Double.parseDouble(results.get((cb.getSelectedIndex() + 1) * 4 -3));
                    double scale = Math.pow(10, decPlaces.getValue());
                    unit2Field.setText(String.valueOf(Math.round(result * scale) / scale));
                } catch (Exception exc) {
                    unit1Field.setText("");
                    
                }
            }
        });

        unit2Field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    double result = Double.parseDouble(unit2Field.getText()) / Double.parseDouble(results.get((cb.getSelectedIndex() + 1) * 4 -3));
                    double scale = Math.pow(10, decPlaces.getValue());
                    unit1Field.setText(String.valueOf(Math.round(result * scale) / scale));
                } catch (Exception exc) {
                    unit2Field.setText("");
                    
                }
            }
        });
    }


    
}