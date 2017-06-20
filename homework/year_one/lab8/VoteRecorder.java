import java.util.Scanner;
public class VoteRecorder {
	
	Scanner kb = new Scanner(System.in);

	private static String nameCandidatePresident1;
	private static String nameCandidatePresident2;
	private static String nameCandidateVicePresident1;
	private static String nameCandidateVicePresident2;

	private static int votesCandidatePresident1;
	private static int votesCandidatePresident2;
	private static int votesCandidateVicePresident1;
	private static int votesCandidateVicePresident2;

	private int myVoteForPresident;
	private int myVoteForVicePresident;
	
	/*
	public VoteRecorder() {
	}

	public VoteRecorder(String p1, String p2) {
		VoteRecorder();
		nameCandidatePresident1 = p1;
		nameCandidatePresident2 = p2;
	}
	
	public VoteRecorder(String p1, String p2, String v1, String v2) {
		VoteRecorder(p1, p2);
		nameCandidateVicePresident1 = v1;
		nameCandidateVicePresident2 = v2;
	}
	*/

	
	public static void setCandidatesPresident(String name1, String name2) {
		nameCandidatePresident1 = name1;
		nameCandidatePresident2 = name2;
	}
	
	public static void setCandidatesVicePresident(String name1, String name2) {
		nameCandidateVicePresident1 = name1;
		nameCandidateVicePresident2 = name2;
	}
	
	public static void resetVotes() {
		votesCandidatePresident1 = 0;
		votesCandidatePresident2 = 0;
		votesCandidateVicePresident1 = 0;
		votesCandidateVicePresident2 = 0;
	}
		
	public static String getCurrentVotePresident() {
		int p1 = votesCandidatePresident1;
		int p2 = votesCandidatePresident2;
		String c1 = nameCandidatePresident1 + ": " + p1;
		String c2 = nameCandidatePresident2 + ": " + p2;
		return c1 + " | " + c2;
	}

	public static String getCurrentVoteVicePresident() {
		int v1 = votesCandidateVicePresident1;
		int v2 = votesCandidateVicePresident2;
		String c1 = nameCandidateVicePresident1 + ": " + v1;
		String c2 = nameCandidateVicePresident2 + ": " + v2;
		return c1 + " | " + c2;
	}

	public void getAndConfirmVotes() {
		getVotes();
		if(confirmVotes()) {
			recordVotes();
		}
	}
	
	private int getAVote(String name1, String name2) {
		System.out.println("Who would you like to vote for?");
		System.out.println("Enter 1 or 2");
		System.out.println();
		System.out.println("1: " + name1 + " | 2: " + name2);
		int answer = kb.nextInt();
		if(answer == 1) {
			return 1;
		}
		if(answer == 2) {
			return 2;
		}else {
			return 0; 
		}
		
	}

	private void getVotes() {
		myVoteForPresident = getAVote(nameCandidatePresident1, nameCandidatePresident2);
		myVoteForVicePresident= getAVote(nameCandidateVicePresident1, nameCandidateVicePresident2);
	}

	private boolean confirmVotes() {
		boolean confirmed = false;

		String p = "";
		String v = "";

		if(myVoteForPresident == 1) {
			p = nameCandidatePresident1;
		}else if(myVoteForPresident == 2) {
			p = nameCandidatePresident2;
		}

		if(myVoteForVicePresident == 1) {
			v = nameCandidateVicePresident1;
		}else if(myVoteForVicePresident == 2) {
			v = nameCandidateVicePresident2;
		}

		System.out.println("Would you like to vote for " + p + " and " + v + "? (y/n)");
		
		String answer = kb.next();
		if(answer.equalsIgnoreCase("y")) {
			confirmed = true;
		}
		
		if(confirmed) {
			System.out.println();
			System.out.println("Votes Confirmed");
			return true;
		}else {
			System.out.println("Votes Not Confirmed");
			return false;
		}

	}

	private void recordVotes() {
		if(myVoteForPresident == 1){
			votesCandidatePresident1++;
		}else if(myVoteForPresident == 2) {
			votesCandidatePresident2++;
		}

		if(myVoteForVicePresident == 1) {
			votesCandidateVicePresident1++;
		}else if(myVoteForVicePresident == 2) {
			votesCandidateVicePresident2++;
		}
		
	}
	
	
	public static void main(String[] args) {
		VoteRecorder a = new VoteRecorder();
		a.setCandidatesPresident("Pat", "Phil");
		a.setCandidatesVicePresident("Vince", "Vinnie");
		a.getAndConfirmVotes();
		System.out.println(VoteRecorder.getCurrentVotePresident());
		System.out.println(VoteRecorder.getCurrentVoteVicePresident());
			

		
	}
}
