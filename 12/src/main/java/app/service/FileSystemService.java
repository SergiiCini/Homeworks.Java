package app.service;

import java.io.*;

public class FileSystemService {
    public Object getDataFromFile(String fileName) throws IOException, ClassNotFoundException {

        // Let's check if file exist first:
        File file = new File(fileName);
        boolean fileIsFound = file.isFile();
        if (!fileIsFound) {
            System.out.println("Can not received data from " + fileName + " file.");
            throw new IOException();
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object receivedData = ois.readObject();
        System.out.println("!!!!!!!!" + receivedData);


        ois.close();
        fis.close();

        return receivedData;
    }

    public void saveDataToFile(String fileName, Object data) throws IOException {
        System.out.println("Data" + data);
        File file = new File(fileName);
        boolean fileIsFound = file.isFile();
        if (!fileIsFound) {
            throw new IOException("It was an error when we try to save data in " + fileName + " file.");
        }

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(data);
        oos.close();
        fos.close();
    }
}
