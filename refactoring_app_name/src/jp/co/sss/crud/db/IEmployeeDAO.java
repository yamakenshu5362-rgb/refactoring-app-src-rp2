package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;


public class IEmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 */
	public List<Employee> allSearch() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			//resultSetの結果Setがない場合はfalse
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.gaitouNasi);
				return null;
			}

			// DTOにDBから取得したデータを格納
			System.out.println(ConstantMsg.recordTitle);
			while (resultSet.next()) {
				
				Employee e = new Employee();
				
				e.setEmpId(resultSet.getInt(ConstantMsg.alEmpId));
				e.setEmpName(resultSet.getString(ConstantMsg.alEmpName));
				e.setGender(resultSet.getInt(ConstantMsg.alGender));
				e.setBirthday(resultSet.getString(ConstantMsg.alBirthday));
				e.setDeptName(resultSet.getString(ConstantMsg.alDeptName));
				employees.add(e);
				
			}
			
			return employees;
			
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}
	
	

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> syainSearch() throws ClassNotFoundException, SQLException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 検索ワード
		String searchWord = br.readLine();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, ConstantMsg.parsent + searchWord + ConstantMsg.parsent);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.gaitouNasi);
				return null;
			}

			System.out.println(ConstantMsg.recordTitle);
			while (resultSet.next()) {
				
				Employee e = new Employee();
				
				e.setEmpId(resultSet.getInt(ConstantMsg.alEmpId));
				e.setEmpName(resultSet.getString(ConstantMsg.alEmpName));
				e.setGender(resultSet.getInt(ConstantMsg.alGender));
				e.setBirthday(resultSet.getString(ConstantMsg.alBirthday));
				e.setDeptName(resultSet.getString(ConstantMsg.alDeptName));
				employees.add(e);

			}

			return employees;

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public List<Employee> busyoSearch(String syainId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, Integer.parseInt(syainId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			if (!resultSet.isBeforeFirst()) {
				System.out.println(ConstantMsg.gaitouNasi);
				return null;
			}

			System.out.println(ConstantMsg.recordTitle);
			while (resultSet.next()) {
				
				Employee e = new Employee();
				
				e.setEmpId(resultSet.getInt(ConstantMsg.alEmpId));
				e.setEmpName(resultSet.getString(ConstantMsg.alEmpName));
				e.setGender(resultSet.getInt(ConstantMsg.alGender));
				e.setBirthday(resultSet.getString(ConstantMsg.alBirthday));
				e.setDeptName(resultSet.getString(ConstantMsg.alDeptName));
				employees.add(e);
				
			}

			return employees;
			
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public void insert(String empName, String gender, String birthday, String syainId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.one, empName);
			preparedStatement.setInt(ConstantValue.two, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantMsg.formatDate);
			preparedStatement.setObject(ConstantValue.three, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.four, Integer.parseInt(syainId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.syainTouroku);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public void update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);
			System.out.print(ConstantMsg.syainName);
			String emp_name = br.readLine();
			// 性別を入力
			System.out.print(ConstantMsg.genderSelect);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(ConstantMsg.birthday);
			String birthday = br.readLine();
			// 部署IDを入力
			System.out.print(ConstantMsg.busyoSelect);
			String syainId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.one, emp_name);
			preparedStatement.setInt(ConstantValue.two, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantMsg.formatDate);
			preparedStatement.setObject(ConstantValue.three, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.four, Integer.parseInt(syainId));
			preparedStatement.setInt(ConstantValue.five, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.syainDelete);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			// Statementをクローズ
			try {
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// DBとの接続を切断
		}
	}
}
