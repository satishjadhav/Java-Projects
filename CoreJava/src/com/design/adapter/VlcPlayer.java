package com.design.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

	public void playVlc(String fileName)
	{
		System.out.println("Plyaing VLC file. Name: "+fileName);
	}
	public void playMp4(String fileName){
	}
}
