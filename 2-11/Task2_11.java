/**
* Task2-11 : 課題内容
* Java2章中間チェックテスト
*
* 本課題では、これまでの内容の振り返りを行い知識を深めていきましょう。
* 問①から問③まであります。
* 指定された値や条件を守って記述して下さい。
*
* 問③に関しては、記述してある内容を含めて結果通りに出力されるように記載を行って下さい。
*
*/

public class Task2_11 {
    public static void main(String[] args){
    /*
    *問①
    int型の変数 a と b を宣言し、それぞれ10と3を代入して、次の演算を行い、結果を表示して下さい：
    ・a と b の和
    ・a と b の差
    ・a と b の積
    ・a と b の商
    ・a を b で割った余り
    */
   int a = 10;
   int b = 3;

   System.out.println("a + b = " + (a + b));
   System.out.println("a - b = " + (a - b));
   System.out.println("a * b = " + (a * b));
   System.out.println("a / b = " + (a / b));
   System.out.println("a % b = " + (a % b));

    /*
    * 問題②
    * int型の配列を宣言し、1から20までの偶数を格納して、ループを使用してそれらの整数を順番に表示して下さい。
    */
    int[] evenNumbers = new int[10]; // 偶数は10個
        int index = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                evenNumbers[index] = i;
                index++;
            }
        }
    System.out.print("1から20までの偶数: ");
        for (int i = 0; i < evenNumbers.length; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();

    /*
    * int型の配列「numbers」内の奇数の合計を、メソッド「sumOddNumbers」を使って表示して下さい。
    * ただし、0は偶数として扱います。
    */
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int add = sumOddNumbers(numbers);
        System.out.println("奇数の合計: " + add);
    }

    public static int sumOddNumbers(int[] numbers) {
    int add = 0;

    for (int i = 0; i < numbers.length; i++) {
    //問題③ 奇数かどうかの判定をするために、for文で取得したnumberを2で割り、余りが0にならないような条件文(if文)を記載して下さい。
        if(numbers[i] % 2 != 0){
        add += numbers[i];
        }
    }
    return add;
    }
}
