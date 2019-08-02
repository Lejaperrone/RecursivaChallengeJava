package csvReader;

import java.io.*;

public class CSVReader {

    public void readDataFrom(String location)
    {
        final String DELIMITER = ";";
        BufferedReader fileReader = null;

        try {

            fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(location), "ISO-8859-1"));
            String line = fileReader.readLine();

            while (line != null) {

                String[] memberArray = line.split(DELIMITER);

                CSVParser CSVParser = new CSVParser();
                CSVParser.parse(memberArray);

                line = fileReader.readLine();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
