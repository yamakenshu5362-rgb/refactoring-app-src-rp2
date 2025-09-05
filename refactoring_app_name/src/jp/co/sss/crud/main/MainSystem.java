package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 *初回のコード変更
 *developブランチを使用したコード変更
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = ConstantValue.zero;

		do {
			// メニューの表示
			System.out.println(ConstantMsg.syainKanri);
			System.out.println(ConstantMsg.zenkenHyouji);
			System.out.println(ConstantMsg.syainmeiKensaku);
			System.out.println(ConstantMsg.busyoIdKensaku);
			System.out.println(ConstantMsg.sinnkiTouroku);
			System.out.println(ConstantMsg.kousin);
			System.out.println(ConstantMsg.sakujo);
			System.out.println(ConstantMsg.syuryo);
			System.out.println(ConstantMsg.menuNumIrai);
			
			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.one:
				// 全件表示機能の呼出
				DBController.allSearch();
				break;

			case ConstantValue.two:
				// 社員名検索
				System.out.print(ConstantMsg.syainName);

				// 検索機能の呼出
				DBController.syainSearch();
				break;

			case ConstantValue.three:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.busyoSelect);
				String busyoId = br.readLine();

				// 検索機能の呼出
				DBController.busyoSearch(busyoId);
				break;

			case ConstantValue.four:
				// 登録する値を入力
				System.out.print(ConstantMsg.syainName);
				String emp_name = br.readLine();
				System.out.print(ConstantMsg.genderSelect);
				String Seibetsu = br.readLine();
				System.out.print(ConstantMsg.birthday);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.busyoSelect);
				String busyoId2 = br.readLine();

				// 登録機能の呼出
				DBController.insert(emp_name, Seibetsu, birthday, busyoId2);
				break;

			case ConstantValue.five:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.syainIdIrai);

				// 更新する値を入力する
				String syainId = br.readLine();
				Integer.parseInt(syainId);

				// 更新機能の呼出
				DBController.update(syainId);
				System.out.println(ConstantMsg.syainDataUpdate);

				break;

			case ConstantValue.six:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.syainDeleteIrai);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != ConstantValue.seven);
		System.out.println(ConstantMsg.systemEnd);
	}
}
