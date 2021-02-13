package com.design.adapter;

public class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;
	public MediaAdapter(String audioType)
	{
		if(audioType.equalsIgnoreCase("vlc"))
		{
			advancedMediaPlayer = new VlcPlayer();
		}else if(audioType.equalsIgnoreCase("mp4"))
		{
			advancedMediaPlayer = new Mp4Player();
		}
	}
	
	public void play(String audioType,String fileName)
	{
		if(audioType.equalsIgnoreCase("vlc"))
		{
			advancedMediaPlayer.playVlc("vlc");
		}
		else if(audioType.equalsIgnoreCase("mp4"))
		{
			advancedMediaPlayer.playMp4("mp4");
		}
	}
}
