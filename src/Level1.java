public class Level1 {
    public static String[] ShopOLAP(int n, String[] items) {
        String[] product = new String[n];
        int[] number = new int[n];

        // разделяем строку на название товара + количество
        for (int i = 0; i < n; i++) {
            int ind = items[i].indexOf(" ");

            product[i] = items[i].substring(0, ind);

            String s = items[i].substring(ind + 1);
            number[i] = Integer.parseInt(s);
        }

        // находим одинаковые товары и суммируем их количество
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (number[i] == -1) continue;

            for (int j = i + 1; j < n; j++) {
                if (product[i].equals(product[j])) {
                    number[i] = number[i] + number[j];

                    number[j] = -1;
                    product[j] = "";
                }
            }

            count++;
        }

        String[] topSellingItems = new String[count];

        // сортируем товары по количеству по убыванию,
        // если количество товаров одинаковое,
        // сортируем по названию в порядке лексикографического возрастания
        for (int i = 0; i < product.length; i++) {
            for (int j = i + 1; j < product.length; j++) {
                if (number[i] < number[j]) {
                    int x = number[i];
                    number[i] = number[j];
                    number[j] = x;

                    String st = product[i];
                    product[i] = product[j];
                    product[j] = st;
                }

                if (number[i] == number[j] && product[i].compareTo(product[j]) > 0) {
                    String st = product[i];
                    product[i] = product[j];
                    product[j] = st;
                }
            }

            if (i < topSellingItems.length) {
                topSellingItems[i] = product[i] + " " + number[i];
            }
        }

        return topSellingItems;
    }
}
