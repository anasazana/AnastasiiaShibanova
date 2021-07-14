package ru.training.at.hw8.data;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Map;
import ru.training.at.hw8.data.entities.MetalsAndColorsData;

public class DataParser {

    public static Object[][] getMetalsAndColorsTestData() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("JDI_ex8_metalsColorsDataSet.json");
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        StringBuilder file = new StringBuilder();
        for (String line; (line = reader.readLine()) != null;) {
            file.append(line).append('\n');
        }
        Type listType = new TypeToken<Map<String, MetalsAndColorsData>>(){}.getType();
        Map<String, MetalsAndColorsData> testData = new Gson().fromJson(file.toString(), listType);

        Object[][] result = new Object[testData.size()][1];
        int i = 0;
        for (MetalsAndColorsData metalsAndColorsData : testData.values()) {
            result[i++][0] = metalsAndColorsData;
        }

        return result;

    }
}
