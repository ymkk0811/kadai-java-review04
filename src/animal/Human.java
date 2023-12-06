package animal;

public class Human extends Animal implements Thinkable {
    // サブクラス スーパークラスAnimal インターフェイスThinkable

    // フィールド定義 変数名任意・要カプセル化
    private String hobby;// 趣味

    // 引数なしコンストラクタ
    public Human() {

    }

    // 引数あり（名前,年齢,趣味）コンストラクタ
    public Human(String animalName, int animalAges,String hobby) {
        //スーパークラスのコンストラクタ呼び出し
        super(animalName, animalAges);
        // 自クラス内コンストラクタ
        this.hobby =hobby;
    }

    @Override
    public void think() {
        //考えるメソッドの実装
        System.out.println("私は"+hobby+"について考えています。");

    }

}
