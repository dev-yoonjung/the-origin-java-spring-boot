package springboot.mission.basic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.mission.basic.controller.dto.ShopDTO;
import springboot.mission.basic.controller.dto.ShopPostDTO;
import springboot.mission.basic.controller.dto.ShopReviewDTO;
import springboot.mission.basic.service.ShopService;

import java.util.Collection;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private static final Logger logger = LoggerFactory.getLogger(ShopController.class);
    private final ShopService shopService;

    public ShopController(@Autowired ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDto){
        return ResponseEntity.ok(this.shopService.createShop(shopDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> readShop(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.shopService.readShop(id));
    }

    @GetMapping
    public ResponseEntity<Collection<ShopDTO>> readShopAll(){
        return ResponseEntity.ok(this.shopService.readShopAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateShop(@PathVariable("id") Long id, @RequestBody ShopDTO shopDto){
        this.shopService.updateShop(id, shopDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable("id") Long id) {
        this.shopService.deleteShop(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{shopId}/post")
    public ResponseEntity<ShopPostDTO> createShopPost(
            @PathVariable("shopId") Long shopId,
            @RequestBody ShopPostDTO shopPostDto){
        return ResponseEntity.ok(this.shopService.createShopPost(shopId, shopPostDto));
    }

    @GetMapping("/{shopId}/post/{postId}")
    public ResponseEntity<ShopPostDTO> readShopPost(
            @PathVariable("shopId") Long shopId, @PathVariable("postId") Long postId
    ) {
        return ResponseEntity.ok(this.shopService.readShopPost(shopId, postId));
    }

    @GetMapping("/{shopId}/post")
    public ResponseEntity<Collection<ShopPostDTO>> readShopPostAll(
            @PathVariable("shopId") Long shopId
    ) {
        return ResponseEntity.ok(this.shopService.readShopPostAll(shopId));
    }

    @PutMapping("/{shopId}/post/{postId}")
    public ResponseEntity<?> updateShopPost(
            @PathVariable("shopId") Long shopId,
            @PathVariable("postId") Long postId,
            @RequestBody ShopPostDTO shopPostDto
    ){
        this.shopService.updateShopPost(shopId, postId, shopPostDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{shopId}/post/{postId}")
    public ResponseEntity<?> deleteShopPost(
            @PathVariable("shopId") Long shopId,
            @PathVariable("postId") Long postId
    ){
        this.shopService.deleteShopPost(shopId, postId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{shopId}/review")
    public ResponseEntity<ShopReviewDTO> createShopReview(
            @PathVariable("shopId") Long shopId,
            @RequestBody ShopReviewDTO shopReviewDto){
        return ResponseEntity.ok(this.shopService.createShopReview(shopId, shopReviewDto));
    }

    @GetMapping("/{shopId}/review/{reviewId}")
    public ResponseEntity<ShopReviewDTO> readShopReview(
            @PathVariable("shopId") Long shopId,
            @PathVariable("reviewId") Long reviewId
    ) {
        return ResponseEntity.ok(this.shopService.readShopReview(shopId, reviewId));
    }

    @GetMapping("/{shopId}/review")
    public ResponseEntity<Collection<ShopReviewDTO>> readShopReviewAll(
            @PathVariable("shopId") Long shopId
    ) {
        return ResponseEntity.ok(this.shopService.readShopReviewAll(shopId));
    }

    @PutMapping("/{shopId}/review/{reviewId}")
    public ResponseEntity<?> updateShopReview(
            @PathVariable("shopId") Long shopId,
            @PathVariable("reviewId") Long reviewId,
            @RequestBody ShopReviewDTO shopReviewDto
    ){
        this.shopService.updateShopReview(shopId, reviewId, shopReviewDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{shopId}/review/{reviewId}")
    public ResponseEntity<?> deleteShopReview(
            @PathVariable("shopId") Long shopId,
            @PathVariable("reviewId") Long reviewId
    ){
        this.shopService.deleteShopReview(shopId, reviewId);
        return ResponseEntity.noContent().build();
    }
}
