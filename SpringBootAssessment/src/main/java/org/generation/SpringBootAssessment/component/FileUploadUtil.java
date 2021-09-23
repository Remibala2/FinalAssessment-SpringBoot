package org.generation.SpringBootAssessment.component;

import org.springframework.web.multipart.*;

import java.io.*;
import java.nio.file.*;

public class FileUploadUtil {
    public static void saveFile(String uploadDir1, String fileName, MultipartFile multipartFile) throws IOException
    {
        //directory - productImages/images/ -- String convert to a path
        Path uploadPath1 = Paths.get(uploadDir1);
        try (InputStream inputStream = multipartFile.getInputStream())
        {
            //getInputSteam() method to read the bytes from multipartFile object
            //Then we will need  to create a file and OutputStream to write the content
            //fileName - T-shirtNew.jpg - -- convert into a path
            //productImages/images/T-shirtNew.jpg

            Path filePath1 = uploadPath1.resolve(fileName);

            //Copy a file to a target file
            Files.copy(inputStream, filePath1, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException ioe)
        {
            throw new IOException("Could not save image file"+ fileName, ioe);
        }
    }
}
