public class Level1 {
    public static String[] ShopOLAP(int n, String[] items) {
        String[] str = new String[n];
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            int ind = items[i].indexOf(" ");

            str[i] = items[i].substring(0, ind);

            String t = items[i].substring(ind + 1, items[i].length());
            num[i] = Integer.parseInt(t);
        }

        for (int i = 0; i < n; i++) {
            if (num[i] == -1) continue;

            for (int j = i + 1; j < n; j++) {
                if (num[j] == -1) continue;

                if (str[i].equals(str[j])) {
                    num[i] = num[i] + num[j];

                    num[j] = -1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] != -1) count++;
        }

        String[] fin = new String[count];

        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (num[i] < num[j]) {
                    int x = num[i];
                    num[i] = num[j];
                    num[j] = x;

                    String st = str[i];
                    str[i] = str[j];
                    str[j] = st;
                }
            }
        }

        for (int i = 0; i < fin.length; i++) {
            fin[i] = str[i] + " " + num[i];
        }

        for (int i = 0; i < fin.length; i++) {
            for (int j = i + 1; j < fin.length; j++) {
                if (num[i] == num[j] && fin[i].compareTo(fin[j]) > 0) {
                    String t = fin[i];
                    fin[i] = fin[j];
                    fin[j] = t;
                }
            }
        }

        return fin;
    }

    public static void main(String[] args) {
        String[] str = {"платье1 5", "сумка32 2", "платье1 1", "сумка23 2", "сумка128 4"};
        ShopOLAP(5, str);
    }
}
