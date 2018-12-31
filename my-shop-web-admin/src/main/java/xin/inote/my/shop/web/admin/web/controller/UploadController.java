package xin.inote.my.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadController {
    private static final String UPLOAD_PATH = "/static/upload/";
    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropFile, HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        String fileName = dropFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        File file = new File(filePath);
        //判断文件是否存在，不存在侧创建文件夹。
        if (!file.exists()){
            file.mkdir();
        }
        file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            dropFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("errno",0);
        result.put("data",new String[]{UPLOAD_PATH+file.getName()});
        result.put("fileName",UPLOAD_PATH+file.getName());
        return result;
    }
}
