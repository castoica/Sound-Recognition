package com.Helpers;

import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFileChooser;

public class Sampler {
	private File file = null;
	private final JFileChooser fileChooser = new JFileChooser();
	private AudioInputStream audioInputStream = null;
	private Clip clip = null;
	
	
	public Sampler(String path){
		this.file =  new File(path);
	}
	public Sampler(){
		
	}
	
	public void readAudioBytes(){
		int totalFramesRead = 0;
			int bytesPerFrame = this.audioInputStream.getFormat().getFrameSize();
			if(bytesPerFrame == AudioSystem.NOT_SPECIFIED){
				bytesPerFrame = 1;
			}
			
			int numberOfBytes = 1024 * bytesPerFrame;
			byte[] audioBytes = new byte[numberOfBytes];
			
			try{
				int numberOfBytesRead = 0;
				int numberOfFramesRead = 0;
				//Read bytes from file
				while((numberOfBytesRead = audioInputStream.read(audioBytes)) != -1){
					numberOfFramesRead = numberOfBytesRead/bytesPerFrame;
					totalFramesRead += numberOfFramesRead;
//						for(byte i:audioBytes){
//							System.out.print(i + " ");
//						}
//						System.out.println();
					Log.console("Read Frames: " + totalFramesRead);
					Log.console("First byte: "+ audioBytes[0]);
				}
			}catch(Exception ex){
				
			}

			
		
	}
	
	public void pickFile(){
		fileChooser.showOpenDialog(null);
		this.file = fileChooser.getSelectedFile();
		try{
		this.audioInputStream = AudioSystem.getAudioInputStream(this.file);
		this.clip = AudioSystem.getClip();
		this.clip.open(this.audioInputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void play(){
		try{
		this.clip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getFileName(){
		return this.file.getName();
	}

	public void stop(){
		try{
			this.clip.stop();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
