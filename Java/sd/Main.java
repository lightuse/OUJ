package sd;

public class Main {
    public static void main(String[] args) {
        // データ上限数
        final int k = 200;
        // 各点数
        double ten[] = new double[k];
        // 偏差値
        double hensachi[] = new double[k];
        // 合計点
        double total = 0.0f;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n = 0;
        for (n = 0; n < k; n++) {
            System.out.println("点数を入力してください．");
            final int t = scan.nextInt();
            if (t < 0) break;
            ten[n] = (double)t;
            total += ten[n];
        }
        //平均の計算
        final double heikin = total /= n;
        System.out.println("平均=" + heikin);
        //標準偏差の計算
        double sigma = 0.0f;
        for (int i = 0; i < n; i++) {
            sigma += (ten[i] - heikin) * (ten[i] - heikin);
        }
        sigma /= n;
        sigma = Math.sqrt(sigma);
        System.out.println("標準偏差=" + sigma);
        //偏差値の計算
        for (int i = 0; i < n; i++) {
            hensachi[i] = (ten[i] - heikin) / sigma * 10 + 50;
        }
        System.out.println("点数     偏差値");
        for (int i = 0; i < n; i++) {
            System.out.println(ten[i] + ", " + hensachi[i]);
        }
    }
}
