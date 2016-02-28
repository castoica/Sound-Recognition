package com.Helpers;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class test {
	public static void main(String args[]){
		//Sampler sampler = new Sampler("C:\\Users\\Catalin\\Downloads\\Yamaha-TG100-Whistle-C5.wav");
		final Sampler sampler = new Sampler();
//		sampler.pickFile();
//		sampler.readAudioBytes();
		JFrame frame = new JFrame("Test");
		JPanel pannel = new JPanel(new GridBagLayout());
		final JLabel label = new JLabel("This is a label");
		JButton openButton = new JButton("Open");
		JButton playButton = new JButton("Play");
		JButton stopButton = new JButton("Stop");
		
		pannel.add(label);
		pannel.add(openButton);
		pannel.add(playButton);
		pannel.add(stopButton);
		frame.add(pannel);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		openButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				sampler.pickFile();
				label.setText(sampler.getFileName());
			}
		});
		
		playButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				sampler.readAudioBytes();
				sampler.play();

			}
		});
		
		stopButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
//				sampler.readAudioBytes();
				sampler.stop();

			}
		});
	}
}
