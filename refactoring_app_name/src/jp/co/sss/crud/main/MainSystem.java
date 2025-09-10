package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
		EmployeeAllFindService eafService = new EmployeeAllFindService();
		EmployeeFindByEmpNameService efenService = new EmployeeFindByEmpNameService();
		EmployeeFindByDeptIdService efbdIService = new EmployeeFindByDeptIdService();
		EmployeeRegisterService erService = new EmployeeRegisterService();
		EmployeeUpdateService euService = new EmployeeUpdateService();
		EmployeeDeleteService edService = new EmployeeDeleteService();
		
		MenuNoReader mnReader = new MenuNoReader();
		EmployeeDeptIdReader ediReader = new EmployeeDeptIdReader();
		EmployeeNameReader enReader = new EmployeeNameReader();
		EmployeeGenderReader egReader = new EmployeeGenderReader();
		
		
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
			
			//メニュー番号の入力チェック
			if(!mnReader.isValid(menuNoStr)) {
				System.out.println(ConstantMsg.MENU_NO_ERROR);
				continue;
			}

			// 機能の呼出
			switch (menuNo) {
			case ConstantValue.one:
				
				try {
					// 全件表示機能の呼出
					eafService.allSearch();
					break;

				}catch (SystemErrorException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
					break; 
				}

			case ConstantValue.two:
				// 社員名検索
				System.out.print(ConstantMsg.syainName);

				// 検索機能の呼出
				try {
					efenService.syainSearch();
					break;
				} catch (IllegalInputException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					continue;
				}catch (SystemErrorException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
					break; 
				
				}


			case ConstantValue.three:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.busyoSelect);
				String busyoId = br.readLine();

				// 検索機能の呼出
				try {
					if(!(ediReader.isValid(busyoId))) {
						throw new IllegalInputException(ConstantMsg.SYAIN_DEPTID_RANGE_ERROR);
					}
					efbdIService.busyoSearch(busyoId);
					break;
				} catch (IllegalInputException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					continue;
				}catch (SystemErrorException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
					break; 
				}
				

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

				try {
					if(enReader.isValid()) {
						
					}
					// 登録機能の呼出
					erService.insert(emp_name, Seibetsu, birthday, busyoId2);
					break;
				} catch (IllegalInputException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					continue;
				}catch (SystemErrorException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
					break; 
				}
			

			case ConstantValue.five:
			
			try {
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.syainIdIrai);

				// 更新する値を入力する
				String syainId = br.readLine();
				Integer.parseInt(syainId);

				// 更新機能の呼出
				euService.update(syainId);
				System.out.println(ConstantMsg.syainDataUpdate);

				break;
				
			}catch (SystemErrorException e) {
				System.out.println(e.getMessage()); 
				e.printStackTrace(); 
				break; 
			}

			case ConstantValue.six:
				
				try {
					// 削除する社員IDを入力
					System.out.print(ConstantMsg.syainDeleteIrai);
	
					// 削除機能の呼出
					edService.delete();
					break;
				}catch (SystemErrorException e) {
					System.out.println(e.getMessage()); 
					e.printStackTrace(); 
					break; 
				}

			}
			
		} while (menuNo != ConstantValue.seven);
		System.out.println(ConstantMsg.systemEnd);
	}
}
