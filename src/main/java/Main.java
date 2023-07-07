import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        StringBuffer log = new StringBuffer();

        mkdir("src", log);

        mkdir("res", log);

        mkdir("savegames", log);

        mkdir("temp", log);

        mkdir("src//main", log);

        mkdir("src//test", log);

        createFile("src//main//Main.java", log);

        createFile("src//main//Utils.java", log);

        mkdir("res//drawables", log);

        mkdir("res//vectors", log);

        mkdir("res//icons", log);

        try (BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("C://Games//temp//temp.txt")))) {

            bwr.write(log.toString());

            bwr.flush();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static void mkdir(String path, StringBuffer log) {

        File dir = new File("C://Games//" + path);

        if (dir.mkdir()) {

            log.append("Создана директория ").append(path).append("\n");
        } else {

            log.append("Не удалось создать директорию ").append(path).append("\n");
        }
    }

    private static void createFile(String path, StringBuffer log) {

        File file = new File("C://Games//" + path);

        try {


            if (file.createNewFile()) {

                log.append("Создан файл ").append(path).append("\n");
            } else {

                log.append("Не удалось создать файл ").append(path).append("\n");
            }
        } catch (IOException e) {

            log.append("Ошибка при создании файла ").append(path).append("\n");
        }
    }
}
