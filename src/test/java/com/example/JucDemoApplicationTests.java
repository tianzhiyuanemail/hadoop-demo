package com.example;

import com.example.entity.User;
import com.example.service.HdfsService;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.fs.BlockLocation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class JucDemoApplicationTests {

    @Resource
    private HdfsService hdfsService;

    @Test
    void contextLoads() {


    }

    /**
     * 创建文件夹
     * @return
     * @throws Exception
     */
    @Test
    public void mkdir() throws Exception {
        String path ="/user/yuan/0814/2";
        // 创建空文件夹
        boolean isOk = hdfsService.mkdir(path);

        System.out.println(isOk);
       
    }

    /**
     * 读取HDFS目录信息
     * @return
     * @throws Exception
     */
    @Test
    public void readPathInfo() throws Exception {
        String path ="/user/yuan/0814";
        List<Map<String, Object>> list = hdfsService.readPathInfo(path);

        System.out.println(list);
    }

    /**
     * 获取HDFS文件在集群中的位置
     * @return
     * @throws Exception
     */
    @Test
    public void getFileBlockLocations() throws Exception {
        String path ="/user/yuan/0814";

        BlockLocation[] blockLocations = hdfsService.getFileBlockLocations(path);

        System.out.println(blockLocations);
    }

    /**
     * 创建文件
     * @param path
     * @return
     * @throws Exception
     */
//    @PostMapping("/createFile")
    public void createFile(@RequestParam("path") String path, @RequestParam("file") MultipartFile file)
            throws Exception {
        
        hdfsService.createFile(path, file);

    }

    @Test
    public void createFile()
            throws Exception {

        hdfsService.createLocalFile();

    }

    /**
     * 读取HDFS文件内容
     * @return
     * @throws Exception
     */
    @Test
    public void readFile() throws Exception {
        String path ="/user/yuan/0814";

        String targetPath = hdfsService.readFile(path);
    }

    /**
     * 读取HDFS文件转换成Byte类型
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/openFileToBytes")
    public void openFileToBytes(@RequestParam("path") String path) throws Exception {
        byte[] files = hdfsService.openFileToBytes(path);
    }

    /**
     * 读取HDFS文件装换成User对象
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/openFileToUser")
    public void openFileToUser(@RequestParam("path") String path) throws Exception {
        User user = hdfsService.openFileToObject(path, User.class);
    }

    /**
     * 读取文件列表
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/listFile")
    public void listFile(@RequestParam("path") String path) throws Exception {
       
        List<Map<String, String>> returnList = hdfsService.listFile(path);
    }

    /**
     * 重命名文件
     * @param oldName
     * @param newName
     * @return
     * @throws Exception
     */
    @PostMapping("/renameFile")
    public void renameFile(@RequestParam("oldName") String oldName, @RequestParam("newName") String newName)
            throws Exception {
         
        boolean isOk = hdfsService.renameFile(oldName, newName);
        
    }

    /**
     * 删除文件
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/deleteFile")
    public void deleteFile(@RequestParam("path") String path) throws Exception {
        boolean isOk = hdfsService.deleteFile(path);
         
    }

    /**
     * 上传文件
     * @param path
     * @param uploadPath
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    public void uploadFile(@RequestParam("path") String path, @RequestParam("uploadPath") String uploadPath)
            throws Exception {
        hdfsService.uploadFile(path, uploadPath);
    }

    /**
     * 下载文件
     * @param path
     * @param downloadPath
     * @return
     * @throws Exception
     */
    @PostMapping("/downloadFile")
    public void downloadFile(@RequestParam("path") String path, @RequestParam("downloadPath") String downloadPath)
            throws Exception {
        hdfsService.downloadFile(path, downloadPath);
    }

    /**
     * HDFS文件复制
     * @param sourcePath
     * @param targetPath
     * @return
     * @throws Exception
     */
    @PostMapping("/copyFile")
    public void copyFile(@RequestParam("sourcePath") String sourcePath, @RequestParam("targetPath") String targetPath)
            throws Exception {
        hdfsService.copyFile(sourcePath, targetPath);
    }

    /**
     * 查看文件是否已存在
     * @param path
     * @return
     * @throws Exception
     */
    @PostMapping("/existFile")
    public void existFile(@RequestParam("path") String path) throws Exception {
        boolean isExist = hdfsService.existFile(path);
    }
}
