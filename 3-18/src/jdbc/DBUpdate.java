package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ■ データベースに接続するプログラム
 * データベースに接続し、テーブルの内容を変更する処理。
 *
 * 問①〜問⑥までを回答し、データベースと接続してみましょう。
 * カリキュラム「データベースを扱うための準備」を参考にして下さい。
 *
 * 実行結果の提出に関しては、
 * いつも通りソースをコミットしていただきますが、
 * 今回は実行結果のスクリーンショットも合わせて提出していただきます。
 * 画像名はDBUpdate.pngとして、3-18フォルダの中に入れ、これまでと同様に提出して下さい。
 *
 */

public class DBUpdate {

    /** ドライバーのクラス名 */
    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    /** ・JDMC接続先情報 */
    // 問① データベースのホスト名・データベース名を定数にしなさい。
    private static final String JDBC_CONNECTION ="jdbc:postgresql://localhost:5432/jdbc_db";
    /** ・ユーザー名 */
    // 問② データベースのユーザー名を定数にしなさい
    private static final String USER = "postgres";
    /** ・パスワード */
    // 問③ データベースのパスワードを定数にしなさい。
    private static final String PASS = " postgres";

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBCドライバの読み込み
            Class.forName(POSTGRES_DRIVER);

            // 問④ DBに接続
            connection = DriverManager.getConnection(
                    JDBC_CONNECTION, USER, PASS);

            // SQLを実行するためのStatement作成
            statement = connection.createStatement();

            // 問⑤ 商品ID020の商品名を変更
            String SQL =
                "UPDATE SHOHIN_TB SET SHOHIN_NAME = '商品20' WHERE SHOHIN_ID = '020'";

            // 問⑥ UPDATE文を実行
            statement.executeUpdate(SQL);

            // 一覧表示
            String SQLselect = "SELECT * FROM SHOHIN_TB";
            resultSet = statement.executeQuery(SQLselect);

            while (resultSet.next()) {
                String column1 = resultSet.getString("SHOHIN_ID");
                String column2 = resultSet.getString("SHOHIN_NAME");
                int column3 = resultSet.getInt("TANKA");

                System.out.print(column1 + ",");
                System.out.print(column2 + ",");
                System.out.println(column3);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}