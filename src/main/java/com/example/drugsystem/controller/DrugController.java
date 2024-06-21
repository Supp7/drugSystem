package com.example.drugsystem.controller;

import com.example.drugsystem.pojo.Drug;
import com.example.drugsystem.service.DrugService;
import com.example.drugsystem.tool.Fileaddress;
import com.example.drugsystem.tool.ImgRegulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;


    @GetMapping("")
    public List<Drug> findAllDrug(){
        return drugService.findAllDrugs();

    }

    @GetMapping("/{id}")
    public Drug findDrugById(@PathVariable("id")int id){
        return drugService.findDrugById(id);
    }
    @GetMapping("/checkShoppingCart/{id}")
    public int checkShoppingCartById(@PathVariable("id")int id){
        return drugService.checkShoppingCartById(id);
    }

    @GetMapping("/purchase/{id}")
    public String purchaseDrugById(@PathVariable("id")int id){
        return drugService.purchaseDrugById(id);
    }


    @GetMapping("/shoppingCart")
    public List<Drug> shoppingCart(){
        return drugService.shoppingCart();
    }

    @GetMapping("/removePurchase/{id}")
    public String removePurchaseById(@PathVariable("id")int id){
        return drugService.removePurchaseById(id);
    }

    @PostMapping("/upload")
    public String ImgStr(@RequestParam("file") MultipartFile file,@RequestParam("id") int id) throws IOException{
        //我们简单验证一下file文件是否为空
        if (file.equals("")){return "文件为空";}
        Date date = new Date();
        Fileaddress fileaddress = new Fileaddress();
        //获取当前系统时间年月这里获取到月如果要精确到日修改("yyyy-MM-dd")
        String dateForm = new SimpleDateFormat("yyyy-MM").format(date);
        //地址合并 path.getFileimg 是存放在实体类的路径 不会写得同学可以直接写 "D:\\img" 这文件要手动创建
        String casePath = fileaddress.getFileimg()+dateForm;
        System.out.println(casePath);
        //获取图片后缀
        String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //这里我们加入了验证图片类型 这需要自己手动写 声明点这只是非常简单的验证
        //删除不影响程序运行
        /***************************************************/
        ImgRegulation regulation = new ImgRegulation();
        try{ boolean ifimg = regulation.VERIFY(imgFormat);
            if (false==ifimg){ return "1"; }
        }catch (Exception e){ return "图片格式不正确"; }
        /****************************************************/
        //判断文件是否存在
        /*************************************************/
        File f = new File(casePath);
        try {if (!f.exists()){f.mkdirs();}
        }catch (Exception e){ return "文件不存在"; }
        /*************************************************/
        //给图片重新随机生成名字
        String name= UUID.randomUUID().toString()+imgFormat;
        System.out.println(name);
        //保存图片
        file.transferTo(new File(casePath+"\\"+name));
        //拼接要保存在数据中的图片地址
        //dateForm 这是动态的文件夹所以要和地址一起存入数据库中
        String urlImg = "api/images/"+dateForm+"/"+name;
        System.out.println(urlImg);

        //上传数据库
        return drugService.uploadImgById(urlImg,id);

    }

    @PostMapping("/name")
    public String save(@RequestBody Drug user){

        return user.toString();
    }


}
