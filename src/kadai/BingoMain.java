package kadai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
		//ボールの個数
		int ballNum = 75;
		
		List <String> balls = new ArrayList<String>();
		List<List<String>> bingoCardBalls = new ArrayList<List<String>>();
		
		//各列用のボール格納先の準備
		for(int i = 0;i < 5;i++) {
			List <String> ballsCol = new ArrayList<String>();
			bingoCardBalls.add(ballsCol);
		}

		
		//boolsリストにボールを格納
		for(int i = 1;i <= ballNum;i++) {
			//0埋めして桁数をそろえる
			String bollStr = String.format("%02d", i);
			balls.add(bollStr);
			
			if(i <= 15) {
				bingoCardBalls.get(0).add(bollStr);
				//ballsCol1.add(bollStr);
			}else if(16 <= i && i <= 30) {
				bingoCardBalls.get(1).add(bollStr);
				//ballsCol2.add(bollStr);
			}else if(31 <= i && i <= 45) {
				bingoCardBalls.get(2).add(bollStr);
				//ballsCol3.add(bollStr);
			}else if(46 <= i && i <= 60) {
				bingoCardBalls.get(3).add(bollStr);
				//ballsCol4.add(bollStr);
			}else{
				bingoCardBalls.get(4).add(bollStr);
				//ballsCol5.add(bollStr);
			}
		}
		//ボールをシャッフル
		Collections.shuffle(balls);
		
		for(int i = 0;i < bingoCardBalls.size();i++) {
			Collections.shuffle(bingoCardBalls.get(i));
		}
		
		//BingoCardクラス呼び出し時にビンゴカード作成
		BingoCard bc = new BingoCard(bingoCardBalls);
		
		//ボール取り出し毎にチェックと表示
		for(int i = 0;i < balls.size();i++) {
			System.out.println("ball[" + (i+1) + "]:" + balls.get(i));
			bc.checkHitBingoCard(balls.get(i));
			bc.displayBingoCard();
		}
		
		

	}

}
