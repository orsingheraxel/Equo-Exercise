package equo.exercise.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderService {

    public Scanner readFile(String filePath) throws FileNotFoundException {
        File inputFile = new File(filePath);
        return new Scanner(inputFile);
    }
}
