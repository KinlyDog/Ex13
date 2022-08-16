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
                    str[j] = "";
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

                if (num[i] == num[j] && str[i].compareTo(str[j]) > 0) {
                    String t = str[i];
                    str[i] = str[j];
                    str[j] = t;
                }
            }

            if (i < fin.length) {
                fin[i] = str[i] + " " + num[i];
            }
        }

        return fin;
    }
}
