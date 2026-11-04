package app;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Використання: java -jar importer.jar <вхідний_файл> <вихідний_файл>");
            return;
        }

        String inputPath = args[0];
        String outputPath = args[1];

        BookingImporter.process(inputPath, outputPath);
    }
}
