import java.io.*;
public class A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int result;
            int code = Integer.parseInt(reader.readLine());
            int interactor = Integer.parseInt(reader.readLine());
            int checker = Integer.parseInt(reader.readLine());

            result = switch (interactor) {
                case (0):
                    if (code != 0) yield 3;
                    else yield checker;
                case (1):
                    yield checker;
                case (4):
                    if (code != 0) yield 3;
                     else yield 4;
                case (6):
                    yield 0;
                case (7):
                    yield 1;
                default:
                    yield interactor;
            };
            System.out.println(result);
        }
    }
}
