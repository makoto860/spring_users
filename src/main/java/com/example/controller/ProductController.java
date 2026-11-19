package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.Product;
import com.example.repository.ProductRepository;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
	// ProductRepositoryを受け取る
	public ProductController(ProductRepository productRepository) {
	    this.productRepository = productRepository;
	}

    @GetMapping("/products")
    public String index(Model model) {
        return "index";
    }

    // DB接続テスト
    @GetMapping("/products/db-test")
    @ResponseBody
    public String dbTest() {
        return "Controller is working!";
    }

    // 新規登録画面
    @GetMapping("/products/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new";
    }

    // 商品登録処理
    @PostMapping("/products")
    public String create(@ModelAttribute Product product,
                         RedirectAttributes redirectAttributes) {
        try {
            int result = productRepository.insert(product);

            if (result == 1) {
                redirectAttributes.addFlashAttribute(
                    "message", "商品を登録しました！");

                // 登録成功後は商品一覧へ
                return "redirect:/products";
            }

            redirectAttributes.addFlashAttribute(
                "error", "商品を登録できませんでした。");

            return "redirect:/products/new";

        } catch (Exception e) {
            e.printStackTrace();

            redirectAttributes.addFlashAttribute(
                "error", "商品登録に失敗しました：" + e.getMessage());

            return "redirect:/products/new";
        }
    }
}
