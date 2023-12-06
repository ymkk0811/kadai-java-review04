package animal;

public class Animal {
    //スーパークラス　Humanへ継承
    
    //フィールド定義　変数名任意・要カプセル化
    private String animalName;//名前
    private int animalAges;//年齢

    //引数なしコンストラクタ
    public Animal() {

    }

    //引数あり（名前,年齢）コンストラクタ
    public Animal(String animalName,int animalAges) {
       this.animalName=animalName;
       this.animalAges=animalAges;
    }

    //話すメソッド
    public void say(){
        System.out.println(animalName+"です。"+animalAges+"歳です。");

    }

}
