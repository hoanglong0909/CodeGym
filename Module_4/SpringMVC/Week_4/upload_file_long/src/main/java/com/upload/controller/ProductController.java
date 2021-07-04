package com.upload.controller;

import com.upload.model.Product;
import com.upload.model.ProductForm;
import com.upload.model.upload.UploadOneFile;
import com.upload.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/product")
@PropertySource("classpath:upload_file.properties")
public class ProductController {
   @Autowired
   private ProductService productService;


    @Value("${folder-upload}")
    private String folderUpload;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<>(productService.saveProduct(product),HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public ModelAndView listProduct(){
        ModelAndView modelAndView =new ModelAndView("/product/list");
        modelAndView.addObject("products",productService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("uploadOneFile", new UploadOneFile());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView modelAndView = new ModelAndView("/product/add");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("uploadOneFile", new UploadOneFile());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addProduct(@ModelAttribute Product product, HttpServletRequest request, @ModelAttribute("uploadOneFile") UploadOneFile uploadOneFile) {
        String uploadRootPath = request.getServletContext().getRealPath("/upload/avatar/");
        if (folderUpload.isEmpty()) {
            folderUpload = uploadRootPath;
        }
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        CommonsMultipartFile[] filesData = uploadOneFile.getFilesData();
        for (CommonsMultipartFile fileData : filesData) {
            String fileName = fileData.getOriginalFilename();
            if (fileName != null && fileName.length() > 0) {
                try {
                    File serverFile = new File(folderUpload + fileName);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    product.setAvatar(fileName);
                    productService.saveProduct(product);
                } catch (Exception e) {
                    System.out.println("Error Write file: " + fileName);
                }
            }
        }

        ModelAndView modelAndView = new ModelAndView("/product/add");
        modelAndView.addObject("product", product);
        modelAndView.addObject("success", "Created new product successfully !");
        return modelAndView;
    }



    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute ProductForm productForm) {
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(folderUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Product product = new Product(
                productForm.getName(),
                productForm.getDescription(),
                fileName
        );
        productService.saveProduct(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productForm);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

}
