package springboot.mssion.challenge.challenge.util;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

public class UploadFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);

    public static String fileSave(String uploadPath, MultipartFile file) throws IllegalStateException, IOException {

        File uploadPathDir = new File(uploadPath);
        if (!uploadPathDir.exists()) uploadPathDir.mkdirs();

        String genId = UUID.randomUUID().toString();
        genId = genId.replace("-", "");

        String originalFileName = file.getOriginalFilename();
        String fileExtension = getExtension(originalFileName);
        String saveFileName = String.format("%s.%s", originalFileName, fileExtension);

        String savePath = calcPath(uploadPath);
        File target = new File(uploadPath + savePath, saveFileName);

        FileCopyUtils.copy(file.getBytes(), target);

        return makeFilePath(uploadPath, savePath, saveFileName);
    }

    /**
     * 파일이름으로부터 확장자를 반환
     *
     * @param fileName 확장자를 포함한 파일 명
     * @return 파일 이름에서 뒤의 확장자 이름만을 반환
     */
    public static String getExtension(String fileName) {
        int dotPosition = fileName.lastIndexOf(".");

        if (dotPosition != -1 && fileName.length() - 1 > dotPosition) {
            return fileName.substring(dotPosition + 1);
        }

        return "";
    }

    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();
        String yearPath = File.separator + cal.get(Calendar.YEAR);
        String monthPath = new StringBuilder().append(yearPath)
                .append(File.separator)
                .append(new DecimalFormat("00").format(cal.get(Calendar.MONTH)))
                .toString();
        String datePath = new StringBuilder().append(monthPath)
                .append(File.separator)
                .append(new DecimalFormat("00").format(cal.get(Calendar.DATE)))
                .toString();

        makeDir(uploadPath, yearPath, monthPath, datePath);
        return datePath;
    }

    private static void makeDir(String uploadPath, String... paths) {
        if (new File(paths[paths.length - 1]).exists()) return;

        for (String path : paths) {
            File dirPath = new File(uploadPath + path);
            if (!dirPath.exists()) dirPath.mkdir();
        }
    }

    private static String makeFilePath(String uploadPath, String path, String fileName) throws IOException {
        String filePath = new StringBuilder()
                .append(uploadPath)
                .append(path)
                .append(File.separator)
                .append(fileName)
                .toString();;
        return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }

    private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
        BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
        BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT, 100);
        String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;

        File newFile = new File(thumbnailName);
        String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
        ImageIO.write(destImg, formatName.toUpperCase(), newFile);

        return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }
}
