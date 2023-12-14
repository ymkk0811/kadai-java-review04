package kadai05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Review05 {

    public static void main(String[] args) {
        // データベースkadaidbのpersonテーブルからidを条件に1件のデータを取得するプログラム
        // idはキーボード入力を採用
        // プリペアードステートメントを使用
        // キーボード入力されたデータはStringであるため、数値に変換したのちsetIntメソッドにて値をセットする

        // 3. データベース接続と結果取得のための変数宣言
        Connection con = null;
        PreparedStatement pstmt = null;// 更新前、更新後の検索用
        ResultSet rs = null;

        try {
            // 1. ドライバのクラスをJava上で読み込む
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DBと接続する
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/kadaidb?useSSL=false&allowPublicKeyRetrieval=true", "root", "Org66288Ugg&");

            // 4. DBとやりとりする窓口（PreparedStatementオブジェクト）の作成
            // 検索用SQL及び検索用PreparedStatementオブジェクトを取得
            String selectSql = "SELECT * FROM person WHERE id = ?";
            pstmt = con.prepareStatement(selectSql);

            // idを入力
            System.out.print("検索キーワードを入力してください > ");
            int num1 = keyInNum();

            // 入力されたidをPreparedStatementオブジェクトの？に値をセット//
            pstmt.setInt(1, num1);

            // 5,6.Select文の実行と結果を格納/代入
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
            }
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        finally
        {
            // 8. 接続を閉じる
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.err.println("ResultSetを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }

            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.err.println("PreparedStatementを閉じるときにエラーが発生しました。");
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("データベースの切断時にエラーが発生しました。");
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * キーボードから入力された値をStringで返す 引数：なし 戻り値：入力された文字列
     */
    private static String keyIn() {
        String line = null;
        try {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            line = key.readLine();

        } catch (IOException e) {

        }
        return line;

    }

    /*
     * キーボードから入力された値をintで返す 引数：なし 戻り値：int
     */
    private static int keyInNum() {
        int result = 0;
        try {
            result = Integer.parseInt(keyIn());

        } catch (NumberFormatException e) {

        }
        return result;

    }
}
