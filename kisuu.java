package kissuu;
import java.util.Scanner;//キーボードからの読み取りが組み込まれる
class kisuu {
		static int cardConvR(int x, int r, char[] d){//基数変換
				int digits = 0; //変換後の桁数
				String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				//配列へ文字列を格納
				do{
						d[digits++] = dchar.charAt(x%r);
						//基数rで整数xを割った余剰を文字列として格納。後置インクリメントに注意
						x /= r;
				}while (x != 0);//ゼロで終了、異なるなら繰り返す。
				return digits;//変換後の桁数を返す
		}

		public static void main (String[] args){ //メイン関数
			Scanner stdIn = new Scanner(System.in);
			//スキャナクラスのインスタンス作成
			int n;//変換対象。キーボードより入力
			int d;//基数。今回は2,8,16のいずれか
			int m;//変換結果桁数
			int retry;//繰り返し確認
			char[] r = new char[32];//変換後の各桁を格納する配列

			System.out.println("１０進数の基数変換");
			do{
					do{//変換対象の読み込み
						System.out.print("変換する非負の整数：");
						n = stdIn.nextInt();
					}while(n<0);//ゼロ未満なら繰り返し

					do{
							System.out.print("何進数へ変換(2,8,16)：");
							d = stdIn.nextInt();//キーボードより基数を受け取る
					}while (d!=2&&d!=8&&d!=16);//指定数以外ならやり直し

					m = cardConvR(n,d,r);//基数変換

					System.out.print(d + "進数ならば");
					for(int i=m;i>=0;i--)//上位の桁から順に表示
							System.out.print(r[i]);//□が何故か入るが原因不明。要調査
					System.out.print("となる。");

					System.out.print("再思考するか？(1:再思考する　2:再思考しない)：");
					retry = stdIn.nextInt();
				}while(retry == 1);
			}
		}


