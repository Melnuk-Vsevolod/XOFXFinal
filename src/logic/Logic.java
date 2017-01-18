package logic;

public class Logic {

	public static String CPUClickedButton;
	public static boolean isCPUTurn = false;
	public static boolean isCPUFirstMove = true;
	public static Boolean whosMoveAfterRandom;
	public static String CPUClicked;
	public static String winner;
	public static boolean firstStart = true;

	public static int[] arr = new int[9];

	public static boolean lH1 = false;
	public static boolean lH2 = false;
	public static boolean lH3 = false;
	public static boolean lV1 = false;
	public static boolean lV2 = false;
	public static boolean lV3 = false;
	public static boolean lD1 = false;
	public static boolean lD2 = false;

	public static boolean random() { // who will play first CPU or Player
		double rand = (Math.random());
		if (rand < 0.5) {
			whosMoveAfterRandom = false;
			isCPUTurn = false;
			return false;

		} else {
			whosMoveAfterRandom = true;
			isCPUTurn = true;
			return true;
		}
	}

	public String CPUMMadeMove() { // cpu turn to make his move
		isCPUTurn = true;
		if (isCPUFirstMove) { // cpu first move
			if (arr[4] == 0) {
				arr[4] = 1;
				isCPUFirstMove = false;
				isCPUTurn = false;
			} else if ((arr[0] == 0) && (isCPUTurn)) {
				arr[0] = 1;
				isCPUFirstMove = false;
				isCPUTurn = false;
			}
		} else {
			if (isCPUTurn) {

				cpuNextMove();
				isCPUTurn = false;
			}
		}

		return CPUClickedButton;

	}

	public boolean cpuNextMove() {

		if (cpuWillWin()) {
			System.out.println("CPU Last Move");
			isCPUTurn = false;
			winner = "CPU";
			// disableButtons();
			return true;
		}

		if (isCPUTurn == true) {

			if (playerWillWin()) {
				System.out.println("Player Last Move");
				isCPUTurn = false;
				return true;

			} else {
				if (isCPUTurn == true) {
					if (findCorner()) {
						System.out.println("Corner");
						return true;
					} else {
						findFreeCell();
						return true;
					}
				}
			}
		}
		return false;

	}

	public boolean cpuWillWin() {
		///////////////// first horisontal

		if ((arr[0] == 0) && (arr[1] == 1) && (arr[2] == 1)) {
			arr[0] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[1] == 0) && (arr[2] == 1)) {
			arr[1] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[1] == 1) && (arr[2] == 0)) {
			arr[2] = 1;
			return true;
		}
		///////////////// second horisontal
		if ((arr[3] == 0) && (arr[4] == 1) && (arr[5] == 1)) {
			arr[3] = 1;
			return true;
		}
		if ((arr[3] == 1) && (arr[4] == 0) && (arr[5] == 1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[3] == 1) && (arr[4] == 1) && (arr[5] == 0)) {
			arr[5] = 1;
			return true;
		}
		///////////////// third horisontal
		if ((arr[6] == 0) && (arr[7] == 1) && (arr[8] == 1)) {
			arr[6] = 1;
			return true;
		}
		if ((arr[6] == 1) && (arr[7] == 0) && (arr[8] == 1)) {
			arr[7] = 1;
			return true;
		}
		if ((arr[6] == 1) && (arr[7] == 1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}

		///////////////// first vertical
		if ((arr[0] == 0) && (arr[3] == 1) && (arr[6] == 1)) {
			arr[0] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[3] == 0) && (arr[6] == 1)) {
			arr[3] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[3] == 1) && (arr[6] == 0)) {
			arr[6] = 1;
			return true;
		}

		///////////////// second vertical
		if ((arr[1] == 0) && (arr[4] == 1) && (arr[7] == 1)) {
			arr[1] = 1;
			return true;
		}
		if ((arr[1] == 1) && (arr[4] == 0) && (arr[7] == 1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[1] == 1) && (arr[4] == 1) && (arr[7] == 0)) {
			arr[7] = 1;
			return true;
		}

		///////////////// third vertical
		if ((arr[2] == 0) && (arr[5] == 1) && (arr[8] == 1)) {
			arr[2] = 1;
			return true;
		}
		if ((arr[2] == 1) && (arr[5] == 0) && (arr[8] == 1)) {
			arr[5] = 1;
			return true;
		}
		if ((arr[2] == 1) && (arr[5] == 1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}

		///////////////// left diagonal
		if ((arr[0] == 0) && (arr[4] == 1) && (arr[8] == 1)) {
			arr[0] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[4] == 0) && (arr[8] == 1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[0] == 1) && (arr[4] == 1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}
		///////////////// right diagonal
		if ((arr[2] == 0) && (arr[4] == 1) && (arr[6] == 1)) {
			arr[2] = 1;
			return true;
		}
		if ((arr[2] == 1) && (arr[4] == 0) && (arr[6] == 1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[2] == 1) && (arr[4] == 1) && (arr[6] == 0)) {
			arr[6] = 1;
			return true;
		}

		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean playerWillWin() {
		///////////////// first horisontal
		if ((arr[0] == 0) && (arr[1] == -1) && (arr[2] == -1)) {
			arr[0] = 1;

			return true;
		}
		if ((arr[0] == -1) && (arr[1] == 0) && (arr[2] == -1)) {
			arr[1] = 1;
			return true;
		}
		if ((arr[0] == -1) && (arr[1] == -1) && (arr[2] == 0)) {
			arr[2] = 1;
			return true;
		}

		///////////////// second horisontal
		if ((arr[3] == 0) && (arr[4] == -1) && (arr[5] == -1)) {
			arr[3] = 1;

			return true;
		}
		if ((arr[3] == -1) && (arr[4] == 0) && (arr[5] == -1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[3] == -1) && (arr[4] == -1) && (arr[5] == 0)) {
			arr[5] = 1;
			return true;
		}
		///////////////// third horisontal
		if ((arr[6] == 0) && (arr[7] == -1) && (arr[8] == -1)) {
			arr[6] = 1;
			return true;
		}
		if ((arr[6] == -1) && (arr[7] == 0) && (arr[8] == -1)) {
			arr[7] = 1;
			return true;
		}
		if ((arr[6] == -1) && (arr[7] == -1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}

		///////////////// first vertical
		if ((arr[0] == 0) && (arr[3] == -1) && (arr[6] == -1)) {
			arr[0] = 1;
			return true;
		}
		if ((arr[0] == -1) && (arr[3] == 0) && (arr[6] == -1)) {
			arr[3] = 1;
			return true;
		}
		if ((arr[0] == -1) && (arr[3] == -1) && (arr[6] == 0)) {
			arr[6] = 1;
			return true;
		}

		///////////////// second vertical
		if ((arr[1] == 0) && (arr[4] == -1) && (arr[7] == -1)) {
			arr[1] = 1;
			return true;
		}
		if ((arr[1] == -1) && (arr[4] == 0) && (arr[7] == -1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[1] == -1) && (arr[4] == -1) && (arr[7] == 0)) {
			arr[7] = 1;
			return true;
		}

		///////////////// third vertical
		if ((arr[2] == 0) && (arr[5] == -1) && (arr[8] == -1)) {
			arr[2] = 1;
			return true;
		}
		if ((arr[2] == -1) && (arr[5] == 0) && (arr[8] == -1)) {
			arr[5] = 1;
			return true;
		}
		if ((arr[2] == -1) && (arr[5] == -1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}

		///////////////// left diagonal
		if ((arr[0] == 0) && (arr[4] == -1) && (arr[8] == -1)) {
			arr[0] = 1;
			return true;
		}
		if ((arr[0] == -1) && (arr[4] == 0) && (arr[8] == -1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[0] == -1) && (arr[4] == 1) && (arr[8] == 0)) {
			arr[8] = 1;
			return true;
		}
		///////////////// right diagonal
		if ((arr[2] == 0) && (arr[4] == -1) && (arr[6] == -1)) {
			arr[2] = 1;
			return true;
		}
		if ((arr[2] == -1) && (arr[4] == 0) && (arr[6] == -1)) {
			arr[4] = 1;
			return true;
		}
		if ((arr[2] == -1) && (arr[4] == -1) && (arr[6] == 0)) {
			arr[6] = 1;
			return true;
		}

		return false;
	}

	//////////////////////////////////////////////////////////////////////////

	public boolean findCorner() {
		///////////////// first horisontal
		if (isCPUTurn == false) {
			return false;

		}
		if (arr[0] == 0) {
			arr[0] = 1;
			return true;
		}
		if (arr[2] == 0) {
			arr[2] = 1;
			return true;
		}
		if (arr[6] == 0) {
			arr[6] = 1;
			return true;
		}
		if (arr[8] == 0) {
			arr[8] = 1;
			return true;
		}

		return false;
	}

	public boolean findFreeCell() {
		if (isCPUTurn == false) {
			return false;

		}

		if (arr[0] == 0) {
			arr[0] = 1;
			return true;
		}
		if (arr[1] == 0) {
			arr[1] = 1;
			return true;
		}
		if (arr[2] == 0) {
			arr[2] = 1;
			return true;
		}
		if (arr[3] == 0) {
			arr[3] = 1;
			return true;
		}
		if (arr[4] == 0) {
			arr[4] = 1;
			return true;
		}
		if (arr[5] == 0) {
			arr[5] = 1;
			return true;
		}
		if (arr[6] == 0) {
			arr[6] = 1;
			return true;
		}
		if (arr[7] == 0) {
			arr[7] = 1;
			return true;
		}
		if (arr[8] == 0) {
			arr[8] = 1;
			return true;
		}

		return false;
	}

	public boolean draw() {
		if ((arr[0] == 0) || (arr[1] == 0) || (arr[2] == 0) || (arr[3] == 0) || (arr[4] == 0) || (arr[5] == 0)
				|| (arr[6] == 0) || (arr[7] == 0) || (arr[8] == 0)) {
			return false;
		}

		return true;

	}

	public void restart() {
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		arr[3] = 0;
		arr[4] = 0;
		arr[5] = 0;
		arr[6] = 0;
		arr[7] = 0;
		arr[8] = 0;

		isCPUTurn = false;
		isCPUFirstMove = true;
		whosMoveAfterRandom = null;
		winner = null;

		lH1 = false;
		lH2 = false;
		lH3 = false;
		lV1 = false;
		lV2 = false;
		lV3 = false;
		lD1 = false;
		lD2 = false;

	}

	public void putLine() {

		/// Horisontal
		if (((arr[0] == 1) && (arr[1] == 1) && (arr[2] == 1)) || ((arr[0] == -1) && (arr[1] == -1) && (arr[2] == -1))) {
			lH1 = true;
		}
		if (((arr[3] == 1) && (arr[4] == 1) && (arr[5] == 1)) || ((arr[3] == -1) && (arr[4] == -1) && (arr[5] == -1))) {
			lH2 = true;
		}
		if (((arr[6] == 1) && (arr[7] == 1) && (arr[8] == 1)) || ((arr[6] == -1) && (arr[7] == -1) && (arr[8] == -1))) {
			lH3 = true;
		}

		/// Vertical
		if (((arr[0] == 1) && (arr[3] == 1) && (arr[6] == 1)) || ((arr[0] == -1) && (arr[3] == -1) && (arr[6] == -1))) {
			lV1 = true;
		}
		if (((arr[1] == 1) && (arr[4] == 1) && (arr[7] == 1)) || ((arr[1] == -1) && (arr[4] == -1) && (arr[7] == -1))) {
			lV2 = true;
		}
		if (((arr[2] == 1) && (arr[5] == 1) && (arr[8] == 1)) || ((arr[2] == -1) && (arr[5] == -1) && (arr[8] == -1))) {
			lV3 = true;
		}

		/// Diagonal
		if (((arr[0] == 1) && (arr[4] == 1) && (arr[8] == 1)) || ((arr[0] == -1) && (arr[4] == -1) && (arr[8] == -1))) {
			lD1 = true;
		}
		if (((arr[2] == 1) && (arr[4] == 1) && (arr[6] == 1)) || ((arr[2] == -1) && (arr[4] == -1) && (arr[6] == -1))) {
			lD2 = true;
		}

	}

}///////////// CLASS END

// 1 -> "O"; -1 -> "X"
