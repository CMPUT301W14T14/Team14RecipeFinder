package model;


public class MapNode{
	private Long userId=null;
	private Long timePosted=null;
	
	public MapNode(Long userId,Long timePosted){
		this.userId=userId;
		this.timePosted=timePosted;
	}
	
	public Long getUserId(){
		return this.userId;
	}
	
	public Long getTimePosted(){
		return this.timePosted;
	}
}
