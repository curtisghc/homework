package lab8;
public class roomDriver {
	public static void main(String[] args) {
		RoomOccupancy a = new RoomOccupancy();
		a.addOneToRoom();
		a.addOneToRoom();
		a.addOneToRoom();
		a.addOneToRoom();
		a.addOneToRoom();

		a.removeOneFromRoom();
		a.removeOneFromRoom();
		a.removeOneFromRoom();
		System.out.println(a.getNumber());
		System.out.println(a.getTotal());

		RoomOccupancy b = new RoomOccupancy();
		b.addOneToRoom();
		b.addOneToRoom();
		b.removeOneFromRoom();
		b.removeOneFromRoom();
		b.removeOneFromRoom();
		b.removeOneFromRoom();
		b.removeOneFromRoom();

		System.out.println(b.getNumber());
		System.out.println(RoomOccupancy.getTotal());
	}
}
