import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays; 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class secretSanta {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter list of participants: ");
		String s = br.readLine();
		String[] splited = s.split("\\s+");
        ArrayList<String> participants = new ArrayList<String>();
        for (int i = 0; i < splited.length; i++) {
        	participants.add(splited[i]);
        }
        secretSanta.maxSize(participants.size());
		secretSanta.suffleSecretSantas(participants);
	}

	public static int maxSize;

	public static void maxSize(int max) {
		maxSize = max;
	}

	public static void suffleSecretSantas(ArrayList<String> participants) {
		Random randomNum = new Random(); 
		ArrayList<String> participantsCpy = new ArrayList<String>(participants);
		ArrayList<String> pairs = new ArrayList<String>(participants.size());

		for (int i = 0; i < maxSize; i++) {
			int randomPosition = randomNum.nextInt(participantsCpy.size());
			String name = participantsCpy.get(randomPosition);
			pairs.add(name);
			participantsCpy.remove(name);
		}

		for(int j=0; j < maxSize; j++) {
			Random ran = new Random();
			int ranNum = ran.nextInt(pairs.size());
			System.out.println("");
			String participant = participants.get(j);
			String pair = pairs.get(ranNum);
			if(participant != pair) {
				System.out.println(participant + ", you have been chosen to be the Secret Santa for " + pair);
			} else {
				pair = pairs.get(ranNum + 1);
				System.out.println(participant + ", you have been chosen to be the Secret Santa for " + pair);
			}
			pairs.remove(pair);
		}

	}
}