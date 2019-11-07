import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

import java.util.Collections;

public class HelloIgnite {
    public static void main(String[] args) {
        //IgniteConfiguration cnf = new IgniteConfiguration();
        try (Ignite ignite = Ignition.start()) {
            IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCacheName"); //создание кэша структуры ключ значение
            for (int i = 0; i < 100; i++)
                cache.put(i, Integer.toString(i)); //заполняем кэш данными где ключ от 0 до 100 и значение те же самое что и ключи только переводим из Integer в String.
            for (int i = 0; i < 100; i++)
                System.out.println("Got [key=" + i + ", val=" + cache.get(i) + ']'); //выводим на экран записанные значения в кэш
        }
    }
}