package lab8;
public class RoomOccupancy {
	
	private int numberInRoom = 0;
	private static int totalNumber = 0;
	
	public void addOneToRoom() {
		this.numberInRoom++;
		this.totalNumber++;
	}
	
	public void removeOneFromRoom() {
		if(numberInRoom > 0) {	
			this.numberInRoom--;
			this.totalNumber--;
		}
	}
		
	public int getNumber() {
		return numberInRoom;
	}
	
	public static int getTotal() {
		return totalNumber;
	}
}
