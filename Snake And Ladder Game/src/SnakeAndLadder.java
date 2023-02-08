import java.util.Scanner;

public class SnakeAndLadder {
	static int b = 111;
	static int laddercount, snakecount;

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner obj = new Scanner(System.in);

		System.out.println("\t\t\t\t\t\t.    Snakes And Ladders\n\n");
		System.out.println("\t\t\t\t\t\t\tInstructions:");
		System.out.println("\t\t\t This program will simulate a regular snakes and ladders game, where you will be");
		System.out.println("\t\t\t facing the computer. You and the computer start at square 0, and the first one to");
		System.out.println(
				"\t\t\t square 100 wins, however, there will be preset squares which will be the snakes or ladders.");
		System.out.println("\t\t\t Once you land on top of a snake you go down a few squares, and move up if you land");
		System.out.println("\t\t\t\t\t\t on the bottom of a ladder. Good Luck and Have FUN!!!");

		System.out.println("				in easy mode there is more number of ladders tham snake");
		System.out.println("				in medium mode there is equal number of ladders and snake");
		System.out.println("				in difficult mode there is less number of ladders tham snake");
		System.out.println("						Your position is denoted by YP");
		System.out.println("						Computer position is denoted by CP");
		System.out.println("						Good Luck and Have FUN!!!");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------");

		System.out.println();

		System.out.println();
		System.out.println(
				"------------------------------------------------------------Board-----------------------------------------------------------------------------");

		String sGame = "yes";

		System.out.print("Do you want to play YES or NO     >  ");
		sGame = obj.next();
		System.out.print("\n\n\n");

		while (sGame.equals("yes") || sGame.equals("YES") || sGame.equals("Y") || sGame.equals("y")) {
			sGame = startGame(sGame);

		}
		System.out.println("\n\n\n\n\t\tYou Exited The Game!!");
	}

	// -------------------------------------------------------------------All
	// definitions-----------------------------------------------------------------------------

	public static String startGame(String start) {

		@SuppressWarnings("resource")
		Scanner myInput = new Scanner(System.in);
		String playAgainSL = "yes";
		while (playAgainSL.equals("yes") || playAgainSL.equals("YES") || playAgainSL.equals("Y")
				|| playAgainSL.equals("y")) {
			System.out.println("Type the level you want to play /n 1.EASY /n 2. MEEDIUM /n 3.HARD /n 4. EXIT ");
			String level = myInput.next();
			if (level.equalsIgnoreCase("easy")) {
				laddercount = 6;
				snakecount = 2;

			} else if (level.equalsIgnoreCase("medium")) {
				laddercount = 4;
				snakecount = 4;
			} else if (level.equalsIgnoreCase("hard")) {
				laddercount = 2;
				snakecount = 6;

			} 
			
			else {
				laddercount = 4;
				snakecount = 4;
				System.out.println("	you entered the wrong level so medium level is automatically selected");
			}

			int[] LadderStart = generateRandomNumbers(laddercount, 5, 1, 85, 80, 35, 30);
			int[] LaddersEnd = generateRandomNumbers(laddercount, 80, 70, 100, 90, 60, 45);
			int[] SnakeStart = generateRandomNumbers(snakecount, 90, 71, 100, 60, 99, 96);
			int[] SnakeEnd = generateRandomNumbers(snakecount, 10, 5, 70, 19, 30, 25);

			int a[][] = new int[10][10];
			for (int i = 0; i <= 9; i++) {
				if (i % 2 == 0) {
					System.out.println();
					b = b - 11;
					for (int k = 0; k <= 9; k++) {
						a[i][k] = b;
						if (a[i][k] == 1) {
							System.out.print(a[i][k] + "yp cp\t");
						} else {
							System.out.print(a[i][k] + "\t");
						}
						b = b - 1;
					}
				} else {
					b = b - 9;
					System.out.println();
					for (int k = 0; k <= 9; k++) {
						a[i][k] = b;
						if (a[i][k] == 1) {
							System.out.print(a[i][k] + "yp,cp\t");
						} else {
							System.out.print(a[i][k] + "\t");
						}
						b = b + 1;
					}
				}

			}

			System.out.println("\n");
			if (level.equalsIgnoreCase("easy")) {
				for (int i = 0; i <= 5; i++) {
					System.out.println("\t\t\tLadderStart[" + i + "]:" + LadderStart[i] + "\t\tLadderEnd[" + i + "]:"
							+ LaddersEnd[i]);
				}
				for (int i = 0; i <= 1; i++) {
					System.out.println(
							"\t\t\tSnakeStart[" + i + "]:" + SnakeStart[i] + "\t\tSnakeEnd[" + i + "]:" + SnakeEnd[i]);
				}

			} else if (level.equalsIgnoreCase("hard")) {
				for (int i = 0; i <= 1; i++) {
					System.out.println("\t\t\tLadderStart[" + i + "]:" + LadderStart[i] + "\t\tLadderEnd[" + i + "]:"
							+ LaddersEnd[i]);
				}

				for (int i = 0; i <= 5; i++) {
					System.out.println(
							"\t\t\tSnakeStart[" + i + "]:" + SnakeStart[i] + "\t\tSnakeEnd[" + i + "]:" + SnakeEnd[i]);
				}

			} else {
				for (int i = 0; i <= 3; i++) {
					System.out.println("\t\t\tLadderStart[" + i + "]:" + LadderStart[i] + "\t\tLadderEnd[" + i + "]:"
							+ LaddersEnd[i]);
				}
				for (int i = 0; i <= 3; i++) {
					System.out.println(
							"\t\t\tSnakeStart[" + i + "]:" + SnakeStart[i] + "\t\tSnakeEnd[" + i + "]:" + SnakeEnd[i]);
				}

			}
			System.out.println();
			System.out.println();
			int compPosition = 0;
			int userPosition = 0;
			int computerRoll = 1;
			int userRoll = 1;
			int diceRoll = 0;

			String playAgain = "yes";

			while (playAgain.equals("yes") || playAgain.equals("YES") || playAgain.equals("Y")
					|| playAgain.equals("y")) {
				computerRoll = getDice(diceRoll);
				userRoll = getDice(diceRoll);

				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------------");
				System.out.println("\t\t\t\t\t------------------------------------------");
				if (userRoll > 6 && userRoll < 12) {
					System.out.println("			on first dice when player rolled 6 comes so dice is rolled again");
					System.out.println("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|");

				} else if (userRoll == 0) {
					System.out.println(
							"		on first dice when player rolled 6 comes so dice is rolled again and 6 comes again");
					System.out.println("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|");
				} else {
					System.out.println("\t\t\t\t\t|\tYou Rolled a " + userRoll + "\t\t|");
				}
				if (computerRoll > 6 && computerRoll < 12) {
					System.out
							.println("			on first dice  when computer rolled 6 comes so dice is rolled again");

					System.out.println("\t\t\t\t\t|\tThe Computer Rolled a " + computerRoll + "\t|");
				} else if (computerRoll == 0) {
					System.out.println(
							"		on first dice when computer rolled 6 comes so dice is rolled again and 6 comes again");
					System.out.println("\t\t\t\t\t|\tYou Rolled a " + computerRoll + "\t\t|");
				} else {
					System.out.println("\t\t\t\t\t|\tThe Computer Rolled a " + computerRoll + "\t|");
				}

				System.out.println("\t\t\t\t\t------------------------------------------");
				compPosition = compPosition + computerRoll;
				userPosition = userPosition + userRoll;

				compPosition = compgetP(compPosition, computerRoll, LadderStart, LaddersEnd, SnakeStart, SnakeEnd);
				userPosition = getP(userPosition, userRoll, LadderStart, LaddersEnd, SnakeStart, SnakeEnd,
						compPosition);

				System.out.println("\t\t\t");
				System.out.println("\t\t\t*\t\tYou are currently on square " + userPosition + "\t\t\t*");
				System.out.println("\t\t\t*\t\tThe Computer is currently on square " + compPosition + "\t\t*");
				b = 111;
				for (int i = 0; i <= 9; i++) {
					if (i % 2 == 0) {
						System.out.println();
						b = b - 11;
						for (int k = 0; k <= 9; k++) {
							a[i][k] = b;

							if (a[i][k] == compPosition && userPosition != compPosition) {
								System.out.print(a[i][k] + " cp\t");
							} else if (a[i][k] == userPosition && userPosition != compPosition) {
								System.out.print(a[i][k] + " yp\t");
							} else if (a[i][k] == userPosition && userPosition == compPosition) {
								System.out.print(a[i][k] + " cp,yp\t");
							} else {
								System.out.print(a[i][k] + "\t");
							}

							b = b - 1;
						}
					} else {
						b = b - 9;
						System.out.println();
						for (int k = 0; k <= 9; k++) {
							a[i][k] = b;

							if (a[i][k] == compPosition) {
								System.out.print(a[i][k] + " cp\t");
							} else if (a[i][k] == userPosition) {
								System.out.print(a[i][k] + " yp\t");
							} else {
								System.out.print(a[i][k] + "\t");
							}
							b = b + 1;
						}
					}

				}
				System.out.println("\t\t\t");

				if (userPosition == 100 || compPosition == 100) {
					compPosition = 1;
					userPosition = 1;

					System.out.print("Do you want to play same level? YEs or N0     >  ");
					playAgain = myInput.next();
					System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
				} else {

					System.out.print("Do you want to play ? YEs or NO      >  ");
					playAgain = myInput.next();
					
					
					
					

				}

			}
			b = 111;
		}
		return playAgainSL;

	}

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}

	private static void exit() {
		// TODO Auto-generated method stub
		
	}

	// -------------------------------------------------------------------Generate
	// Snake and Ladder
	// Method------------------------------------------------------------------------------

	private static int[] generateRandomNumbers(int size, int max1, int min1, int max2, int min2, int max3, int min3) {
		int[] numbers = new int[size];

		for (int i = 0; i < size; i++) {
			numbers[i] = (int) (Math.random() * (max1 - min1 + 1) + min1);

			if (i % 2 == 1 && i < size - 2) {
				numbers[i] = (int) (Math.random() * (max2 - min2 + 1) + min2);
			} else if (i == 4 || i == 5) {
				numbers[i] = (int) (Math.random() * (max3 - min3 + 1) + min3);

			}
		}

		return numbers;
	}

	// -------------------------------------------------------------------get Dice
	// Method------------------------------------------------------------------------------

	public static int getDice(int diceRoll) {

		diceRoll = (int) (Math.random() * (6 - 1 + 1) + 1);

		if (diceRoll == 6) {

			int diceRolll = (int) (Math.random() * (6 - 1 + 1) + 1);
			int step = diceRoll + diceRolll;
			if (step == 12) {
				return step = 0;
			}
			return step;
		} else {
			int diceRolll = 0;
			int step = diceRoll + diceRolll;
			if (step == 12) {
				return step = 0;
			}
			return step;
		}
	}
	// -------------------------------------------------------------------compgetP
	// Method------------------------------------------------------------------------------

	public static int compgetP(int compPosition, int compRoll, int LadderStart[], int LaddersEnd[], int SnakeStart[],
			int SnakeEnd[]) {
		if (snakecount == 4) {

			for (int i = 0; i < 4; i++) {
				if (compPosition == SnakeStart[i]) {
					compPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~Computer Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 4; j++) {
				if (compPosition == LadderStart[j]) {
					compPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~Computer Got A Ladder~~~~~~~~");
				}
			}

			if (compPosition > 100) {
				compPosition = compPosition - compRoll;
				System.out.println("OHHH Computer cant jump");

			} else if (compPosition == 100) {
				System.out.println("THE COMPUTER WON, YOU FAILED!!!");
				System.out.println("    .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :           `    :\r\n" + " |                |      \r\n" + " :    .------.    :\r\n"
						+ "  \\  '      '  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}
		} else if (snakecount == 2) {

			for (int i = 0; i < 2; i++) {
				if (compPosition == SnakeStart[i]) {
					compPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~Computer Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 6; j++) {
				if (compPosition == LadderStart[j]) {
					compPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~Computer Got A Ladder~~~~~~~~");
				}
			}

			if (compPosition > 100) {
				compPosition = compPosition - compRoll;
				System.out.println("OHHH Computer cant jump");

			} else if (compPosition == 100) {
				System.out.println("THE COMPUTER WON, YOU FAILED!!!");
				System.out.println("    .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :           `    :\r\n" + " |                |      \r\n" + " :    .------.    :\r\n"
						+ "  \\  '      '  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}
		} else if (snakecount == 6) {

			for (int i = 0; i < 6; i++) {
				if (compPosition == SnakeStart[i]) {
					compPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~Computer Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 2; j++) {
				if (compPosition == LadderStart[j]) {
					compPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~Computer Got A Ladder~~~~~~~~");
				}
			}

			if (compPosition > 100) {
				compPosition = compPosition - compRoll;
				System.out.println("OHHH Computer cant jump");

			} else if (compPosition == 100) {
				System.out.println("THE COMPUTER WON, YOU FAILED!!!");
				System.out.println("    .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :           `    :\r\n" + " |                |      \r\n" + " :    .------.    :\r\n"
						+ "  \\  '      '  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}

		}
		return compPosition;
	}

	// -------------------------------------------------------------------getP
	// Method------------------------------------------------------------------------------

	public static int getP(int userPosition, int userRoll, int LadderStart[], int LaddersEnd[], int SnakeStart[],
			int SnakeEnd[], int compPosition) {
		if (snakecount == 4) {
			for (int i = 0; i < 4; i++) {
				if (userPosition == SnakeStart[i]) {
					userPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~~~You Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 4; j++) {
				if (userPosition == LadderStart[j]) {
					userPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~~You Got A Ladder~~~~~~~~");

				}
			}
			if (userPosition > 100) {
				userPosition = userPosition - userRoll;
				System.out.println("OHHH You cant jump");

			} else if (userPosition == 100 && compPosition != 100) {
				System.out.println("YOU WON!!!");
				System.out.println("   .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :                :\r\n" + " |                |        \r\n" + " : ',          ,' :\r\n"
						+ "  \\  '-......-'  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}
		}
		if (snakecount == 6) {
			for (int i = 0; i <6; i++) {
				if (userPosition == SnakeStart[i]) {
					userPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~~~You Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 2; j++) {
				if (userPosition == LadderStart[j]) {
					userPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~~You Got A Ladder~~~~~~~~");

				}
			}
			if (userPosition > 100) {
				userPosition = userPosition - userRoll;
				System.out.println("OHHH You cant jump");

			} else if (userPosition == 100 && compPosition != 100) {
				System.out.println("YOU WON!!!");
				System.out.println("   .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :                :\r\n" + " |                |        \r\n" + " : ',          ,' :\r\n"
						+ "  \\  '-......-'  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}
		} else if (snakecount == 2) {
			for (int i = 0; i < 2; i++) {
				if (userPosition == SnakeStart[i]) {
					userPosition = SnakeEnd[i];
					System.out.println("\t\t\t\t~~~~~~You Got Bit By A Snake~~~~~~");
				}
			}
			for (int j = 0; j < 6; j++) {
				if (userPosition == LadderStart[j]) {
					userPosition = LaddersEnd[j];
					System.out.println("\t\t\t\t~~~~~~You Got A Ladder~~~~~~~~");

				}
			}
			if (userPosition > 100) {
				userPosition = userPosition - userRoll;
				System.out.println("OHHH You cant jump");

			} else if (userPosition == 100 && compPosition != 100) {
				System.out.println("YOU WON!!!");
				System.out.println("   .-\"\"\"\"\"\"-.\r\n" + "   .'          '.\r\n" + "  /   O      O   \\\r\n"
						+ " :                :\r\n" + " |                |        \r\n" + " : ',          ,' :\r\n"
						+ "  \\  '-......-'  /\r\n" + "   '.          .'\r\n" + "     '-......-'");

			}
		}

		return userPosition;
	}
}