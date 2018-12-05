import java.util.Scanner;
import java.util.ArrayList;
public class LotteryTest5{

	int[] lottery = new int[6];
	int userNum[][]=new int [3][6];
	int randomNum=0;
	int i=0;
	int winnings=0;

	Scanner input = new Scanner (System.in);

	public static void main(String[] args){

		LotteryTest5 lotteryTest5 = new LotteryTest5();
		lotteryTest5.getLottery();
		lotteryTest5.getUserNum();
		lotteryTest5.generateNumber();
		lotteryTest5.getLotteryResult();

	}

	public void getLottery(){

		for (int i = 0; i <= 5; i++) {
			randomNum = (int) (Math.random() * 40);
			for (int x = 0; x <i; x++) {
				if (lottery[x] == randomNum){

					randomNum = (int) (Math.random() * 40);
					x = -1;
				}
			}
			lottery[i] = randomNum;
		}
	}

	public void getUserNum(){
		int j = 0;
		System.out.println ("Welcome to the lottery, you degenerate gambler. Pick 6 numbers between 1 and 40:");

		while (j <= 5){
			int lineNumber = input.nextInt();

			userNum[i][j] = lineNumber;

			j++;
		}

		System.out.println ("Would you like to add another line? Go on you mad bastard! Type 1 for Yes or 2 for No followed by ENTER");

		if (i!=2){
			if (input.nextInt() == 1){

				i++;

				getUserNum();
			}

			else{
				generateNumber();
			}
		}
	}

		public void generateNumber(){

			int i = 0;
			int count = 0;

			while (i < userNum.length){
				int j = 0;
				count = 0;

				if (userNum[i][j] == 0){

					break;
				}
				while (j < userNum[i].length){
					if (checkNumber(userNum[i][j])){
						count++;
					}
					j++;
				}
				i++;


				System.out.println("You have guessed "+count+" numbers");

				if(count<3 || count >6){
					System.out.println("Better luck next time!");
				}
					else if(count==3){
						winnings=winnings+100;
						System.out.println("Congrats! You've won "+winnings+" euro!");
					}
					else if(count==4){
						winnings=winnings+250;
						System.out.println("Congrats! You've won "+winnings+" euro!");
					}
					else if(count==5){
						winnings=winnings+1000;
						System.out.println("Congrats! You've won "+winnings+" euro!");
					}
					else{
						System.out.println("You have won the Jackpot!");
					}

				System.out.println();
			}

		}

		public void getLotteryResult(){
			for (int i = 0; i < lottery.length; i++){
         		System.out.print(lottery[i] + " ");
			}
	 }

		public boolean checkNumber (int number){
			boolean check = false;
			for (int i=0; i<lottery.length; i++){
				if (lottery[i] == number){
					check = true;
				}
			}

			return check;
		}
	}