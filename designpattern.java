package lab4;

interface mediaplayer {
	public void play(String filename);
}

interface advancemediaplayer{
	public void playfile(String filename);
}

class mp3 implements mediaplayer{
	public void play(String filename) {
		System.out.println("mp3 is playing "+filename);
	}
}

class  mp4 implements advancemediaplayer{
	public void playfile(String filename) {
		System.out.println("mp4 is playing "+filename);
	}
}

class vlcplayer implements advancemediaplayer{
	public void playfile(String filename) {
		System.out.println("Song "+ filename+" is playing");
	}
}

class mediaplayeradapter implements mediaplayer{
	private advancemediaplayer adv;
	public mediaplayeradapter (advancemediaplayer adv) {
	this.adv=adv;
	}
	public void play(String filename) {
		System.out.println("Using mediaplayer adapter");
		adv.playfile(filename);
	}
}
public class Main {
	public static void main(String args[]) {
		mediaplayer m=new mp3();
		m.play("test.mp3");
		
		 m=new mediaplayeradapter(new mp4());
		 m.play("xyz.mp4");
		 
		 m=new mediaplayeradapter(new vlcplayer());
		 m.play("c.avi");
		
	}
}
