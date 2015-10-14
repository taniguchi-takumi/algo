package eratosthenes;//プログラムごとにパッケージは変更している

public class PrimeNumber {//クラス名宣言
	public static void main(String[] args){
		final int range = 1000; //検査対象の最大数
		int counter = 0;//乗除算回数を係数するためのカウンタ
		int ptr = 0;//素数の個数
		int[] prime = new int[500];//素数を格納する配列

		prime[ptr++] = 2;//素数２を配列にカウント
		prime[ptr++] = 3;//素数３を配列にカウント

		for (int n=5;n<=range;n+=2){
			//素数５以降を調査しカウント。奇数のみを対象に1000まで
			boolean flag = false;//素数か否かの判定フラグ
			for(int i=1;prime[i]*prime[i]<=n;i++){
				//nの平方根以下のいずれの素数でも割り切れないか検査
				//素数のi個目とi個目をかけて検査中の数以下なら繰り返す
				counter += 2;//for文の乗算、if文の除算をカウント
				if(n%prime[i]==0){//割り切れるとき素数ではない
					flag = true;
					break;//ループ解除
				}
			}
			if(!flag){//最後まで割り切れないならば素数
					prime[ptr++] = n;//素数を配列にカウント
					counter++;//for文がクリアできなかった時のカウント
			}
		}

		for(int i = 0; i < ptr; i++)//素数一覧表示
				System.out.println(prime[i]);
		System.out.println("乗除算回数："+counter);//計算数がここに出る
	}

}
