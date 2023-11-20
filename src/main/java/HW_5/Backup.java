package HW_5;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class Backup {
    public static void main(String[] args) {
        try {
            copyFiles(new File("./src/main/java"), new File("./backup"));
            System.out.println("Резервное копирование успешно завершено.");
        } catch (IOException e) {
            System.err.println("Ошибка при копировании файлов: " + e.getMessage());
        }
    }

    /**
     * Создает резервную директорию и копирует содержимое поддиректорий, используя рекурсию
     * @param source - исходный файл
     * @param target - резервный файл
     * @throws IOException
     */
    private static void copyFiles(File source, File target) throws IOException {
        if (!target.exists()) {
            target.mkdirs();
        }

        if (source.isDirectory()) {

            File newTarget = new File(target, source.getName());
            newTarget.mkdirs();


            for (File file : Objects.requireNonNull(source.listFiles())) {
                copyFiles(file, newTarget);
            }
        } else {

            Files.copy(source.toPath(), new File(target, source.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}


