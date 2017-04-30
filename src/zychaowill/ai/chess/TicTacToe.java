package zychaowill.ai.chess;

import java.util.Random;

public class TicTacToe {
	static final char X = 'X';
	static final char O = 'O';
	static final char EMPTY = ' ';

	static final int INFINITY = 1000;
	static final int WIN = +INFINITY;
	static final int LOSE = -INFINITY;
	static final int DOUBLE_LINK = INFINITY / 2;

	static final int ON = 1;
	static final int DRAW = 0;

	static final int[][] WIN_STATUS = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
			{ 0, 4, 8 }, { 2, 4, 6 } };

	public int gameState(char[] board) {
		int result = ON;
		boolean isFull = true;
		
		// is game over?
		for (int pos = 0; pos < board.length; pos++) {
			if (isEmpty(board, pos)) {
				isFull = false;
				break;
			}
		}
		
		// is Max win/lose?
		for (int[] status : WIN_STATUS) {
			char chess = board[status[0]];
			if (isEmpty(chess)) {
				break;
			}
			
			int i = 1;
			for (; i < status.length; i++) {
				if (board[status[i]] != chess) {
					break;
				}
			}
			
			if (i == status.length) {
				result = chess == X ? WIN : LOSE;
				break;
			}
		}
		
		if (result != WIN && result != LOSE) {
			if (isFull) {
				result = DRAW;
			} else {
				// check double link
				// finds[0] -> X, finds[1] -> O
				int[] finds = new int[2];
				for (int[] status : WIN_STATUS) {
					char chess = EMPTY;
					boolean hasEmpty = false;
					int count = 0;
					
					for (int i = 0; i < status.length; i++) {
						if (board[status[i]] == EMPTY) {
							hasEmpty = true;
						} else {
							if (chess == EMPTY) {
								chess = board[status[i]];
							}
							if (board[status[i]] == chess) {
								count++;
							}
						}
					}
					
					if (hasEmpty && count > 1) {
						if (chess == X) {
							finds[0]++;
						} else if (chess == O) {
							finds[1]++;
						}
					}
				}
				// check if two in one line
				if (finds[1] > 0) {
					result = -DOUBLE_LINK;
				} else if (finds[0] > 0) {
					result = DOUBLE_LINK;
				}
			}
		}
		
		return result;
	}

	public int minMax(char[] board, int depth) {
		int[] bestMoves = new int[board.length];
		int index = 0;
		
		int bestValue = -INFINITY;
		for (int pos = 0; pos < board.length; pos++) {
			if (isEmpty(board, pos)) {
				board[pos] = X;
				
				int value = minValue(board, depth);
				if (value > bestValue) {
					bestValue = value;
					index = 0;
					bestMoves[index] = pos;
				} else if (value == bestValue) {
					index++;
					bestMoves[index] = pos;
				}
				
				board[pos] = EMPTY;
			}
		}
		
		if (index > 1) {
			index = (new Random(System.currentTimeMillis()).nextInt()>>>1) % index;
		}
		return bestMoves[index];
	}
	
	public int maxValue(char[] board, int depth) {
		int evalValue = gameState(board);

		boolean isGameOver = (evalValue == WIN || evalValue == LOSE || evalValue == DRAW);

		if (depth == 0 || isGameOver) {
			return evalValue;
		}

		int bestValue = -INFINITY;
		for (int pos = 0; pos < board.length; pos++) {
			if (isEmpty(board, pos)) {
				board[pos] = X;
				bestValue = Math.max(bestValue, minValue(board, depth - 1));
				board[pos] = EMPTY;
			}
		}
		return evalValue;
	}

	public int minValue(char[] board, int depth) {
		int evalValue = gameState(board);

		boolean isGameOver = (evalValue == WIN || evalValue == LOSE || evalValue == DRAW);

		if (depth == 0 || isGameOver) {
			return evalValue;
		}

		int bestValue = +INFINITY;
		for (int pos = 0; pos < board.length; pos++) {
			if (isEmpty(board, pos)) {
				board[pos] = O;
				bestValue = Math.min(bestValue, maxValue(board, depth - 1));
				board[pos] = EMPTY;
			}
		}
		return evalValue;
	}

	public boolean isEmpty(char[] board, int pos) {
		return isEmpty(board[pos]);
	}
	
	public boolean isEmpty(char chess) {
		return chess != X && chess != O;
	}
}
