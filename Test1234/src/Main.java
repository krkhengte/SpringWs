import java.util.stream.Collectors;

public class Main {
    public static String reverse(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            StringBuilder sb = new StringBuilder();
                            for (int i = list.size() - 1; i >= 0; i--) {
                                sb.append(list.get(i));
                            }
                            return sb.toString();
                        }
                ));
    }

    public static void main(String[] args) {
        String reversedString = reverse("help others");
        System.out.println(reversedString);
    }
}