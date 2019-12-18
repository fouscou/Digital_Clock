package com.fouscou.app;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel dateArea, hourArea, minuteArea, secondArea;
    JPanel datePanel, hourPanel, panel;
    BoxLayout boxLayout, hourBoxLayout;
    Format dateFormat;
    Calendar now;
    Timer timer;
    ActionListener actionListener;


    public View() {
        initComponent();
        actionListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                now = Calendar.getInstance();
                updateView();
            };
        };
        timer = new Timer(1000, actionListener);
        timer.setInitialDelay(0);
        timer.start();
    }

    public void updateView(){
        dateArea.setText(dateFormat.format(new Date()));

        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minutes = now.get(Calendar.MINUTE);
        int secondes = now.get(Calendar.SECOND);

        if(hour < 10){
            hourArea.setText("0"+String.valueOf(hour) + " : ");
        }else{
            hourArea.setText(String.valueOf(hour) + " : ");
        }

        if(minutes < 10){
            minuteArea.setText("0"+String.valueOf(minutes) + " : ");
        }else{
            minuteArea.setText(String.valueOf(minutes) + " : ");
        }

        if(secondes < 10){
            secondArea.setText("0"+String.valueOf(secondes));    
        }else{
            secondArea.setText(String.valueOf(secondes));
        }
        
    }

    private void initComponent(){
        this.setTitle("Digital Clock");
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        dateFormat = new SimpleDateFormat("EEE, dd/MM/yyyy");

        dateArea = new JLabel();
        dateArea.setSize(300, 20);

        hourArea = new JLabel();
        hourArea.setSize(100,20);

        minuteArea = new JLabel();
        minuteArea.setSize(100,20);

        secondArea = new JLabel();
        secondArea.setSize(100,20);

        datePanel = new JPanel();
        hourPanel = new JPanel();
        panel = new JPanel();

        boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);

        hourBoxLayout = new BoxLayout(hourPanel, BoxLayout.X_AXIS);
        hourPanel.setLayout(hourBoxLayout);

        datePanel.add(dateArea);
        
        hourPanel.add(hourArea);
        hourPanel.add(minuteArea);
        hourPanel.add(secondArea);
        
        panel.add(datePanel);
        panel.add(hourPanel);
        
        this.add(panel);
    }

}