import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FundGenerator {

    public static List<PensionFund> generate() throws IOException {

        String path = "resources/fund.txt";

        Random random = new Random();
        List<PensionFund> funds = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            funds.add(new PensionFund(
                    line,
                    String.valueOf(random.nextInt(1988, 2000)),
                    TypeOfFund.getRandomType()
            ));
        }

        bufferedReader.close();

        return funds;
    }
}
