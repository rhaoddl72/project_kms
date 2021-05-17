package day15;

//RemoteControl 인터페이스를 구현한 TvRemoteControl 구현 클래스
public class TvRemoteControl implements RemoteControl {

	private boolean power; //기본적으로 모든 리모컨에 있는 기능들을 interface에서 구현해준다.
	private int channel; // 빔프로젝트 리모콘에는 채널이 없을 수 있다.
	private final int MAX_CHANNEL = 999; //채널이 무한대로 늘어나지는 않으니까 max값 설정
	
	
	
	@Override
	public void powerOn() {
		
		power = true;
		
	}

	@Override
	public void powerOff() {
		
		power = false;
		
	}
	
	public void channelUp() {
		
		if(!power) { //파워가 꺼져 있으면 return
			return;
		}
		channel++;
		if(channel > MAX_CHANNEL) {
			//채널이 최대치 까지 가면 채널 1번으로 초기화
			channel = 1; 
		}
	}
	
	public void channelDown() {
		
		if(!power) {
			return;
		}
		channel --;
		if(channel < 1) {
			//채널이 1번보다 작아지면 맨 끝 채널로 초기화
			channel = MAX_CHANNEL;
		}
	}
	
	public void setChannel(int channel) {
		
		if(!power) {
			return;
		}
		this.channel = channel;
		if(channel < 1 || channel > MAX_CHANNEL) {
			channel = MAX_CHANNEL;
		}
		
	}
	
	
	

}
