package kadai;

import java.util.List;

public class BingoCard {

	String[][] bingoCard = new String[5][5];
	int reachNum = 0;
	int bingoNum = 0;

	public BingoCard(List<List<String>> bingoCardBalls) {
		//ビンゴカードの作成
		for (int i = 0; i < bingoCard.length; i++) {

			for (int j = 0; j < bingoCard.length; j++) {
				String ball = " " + bingoCardBalls.get(i).get(j) + " ";
				bingoCard[j][i] = ball;
			}
		}
		//真ん中はFREE
		bingoCard[2][2] = "FREE";

	}

	//ビンゴカード表示メソッド
	public void displayBingoCard() {
		for (int i = 0; i < bingoCard.length; i++) {
			for (int j = 0; j < bingoCard.length; j++) {
				System.out.print(bingoCard[i][j]);
			}
			System.out.println();
		}
		checkLineBingoCard();
		System.out.println();
		System.out.println("REACH: " + reachNum);
		System.out.println("BINGO: " + bingoNum);
		System.out.println("--------------------");
	}

	//リーチ・ビンゴの確認
	public void checkLineBingoCard() {
		//穴の開いた箇所の数
		int hit = 0;
		//リーチ数・ビンゴ数のリセット
		reachNum = 0;
		bingoNum = 0;
		//横方向のチェック
		for (int i = 0; i < bingoCard.length; i++) {
			hit = 0;
			for (int j = 0; j < bingoCard.length; j++) {
				if (bingoCard[i][j].matches("\\(.*\\)")
						|| bingoCard[i][j].equals("FREE")) {
					hit++;
				}
			}
			judgeReachOrBingo(hit);
		
		}

		//縦方向のチェック
		for (int i = 0; i < bingoCard.length; i++) {
			hit = 0;
			for (int j = 0; j < bingoCard.length; j++) {
				if (bingoCard[i][j].matches("\\(.*\\)")
						|| bingoCard[j][i].equals("FREE")) {
					hit++;
				}
			}
			judgeReachOrBingo(hit);
		
		}

		//左上から右下の斜めチェック
		hit = 0;
		for (int i = 0; i < bingoCard.length; i++) {
			if (bingoCard[i][i].matches("\\(.*\\)")
					|| bingoCard[i][i].equals("FREE")) {
				hit++;
			}
		}
		judgeReachOrBingo(hit);

		//左下から右上の斜めチェック
		hit = 0;
		for (int i = 1; i <= bingoCard.length; i++) {
			if (bingoCard[bingoCard.length - i][i - 1].matches("\\(.*\\)")
					|| bingoCard[bingoCard.length - i][i - 1].equals("FREE")) {
				hit++;
			}
		}
		judgeReachOrBingo(hit);
	}

	public void checkHitBingoCard(String ball) {
		for (int i = 0; i < bingoCard.length; i++) {
			for (int j = 0; j < bingoCard.length; j++) {
				if (bingoCard[i][j].trim().equals(ball)) {
					bingoCard[i][j] = "(" + bingoCard[i][j].trim() + ")";
				}
			}
		}
	}
	//リーチかビンゴか判定する
	public void judgeReachOrBingo(int hit){
		if (hit == 4) {
			reachNum++;
		} else if (hit == 5) {
			bingoNum++;
		}

	}
}
