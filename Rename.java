// Java program to illustrate
// how to rename Multiple Files
// together using single program

import java.io.File;
import java.io.IOException;

public class Rename {
    public static void main(String[] argv) throws IOException {
        // Path of folder where files are located
        String folder_path = "C:\\Users\\ymred\\Downloads\\Songs\\";
        filerecursive(folder_path);

    }

    private static void filerecursive(String folder_path) {
        // creating new folder
        File myfolder = new File(folder_path);
        File[] file_array = myfolder.listFiles();
        for (int i = 0; i < file_array.length; i++) {

            if (file_array[i].isDirectory()) {
                filerecursive(file_array[i].getPath());
            } else if (file_array[i].isFile() ) {
                renameFile(file_array[i], folder_path);
            }
        }
    }

    public static void renameFile(File file, String folder_path) {
        File myfile = new File(folder_path + "\\" + file.getName());
        String old_file_name = file.getName();
        String new_file_name = old_file_name.startsWith("[iSongs.info]") ? old_file_name.replace("[iSongs.info] ", "").trim() : old_file_name.trim();

        //rename files
        myfile.renameTo(new File(folder_path + "\\" + new_file_name.trim()));
        System.out.println(old_file_name + "  renamed as " + new_file_name);
    }


}
