package com.example.RestApiSpring.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "backets")
public class BasketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String tile;
    private Boolean completed;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;



    @ManyToMany
    @JoinTable(name = "backets_products",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> productList = new ArrayList<>();



    public boolean addProductInBasket(ProductEntity product, Long quantity){
        int qty = 0;
//        for ( ProductEntity pe : this.productList){
//            if (pe.getId() == product.getId()){
//                product.setQuantity(product.getQuantity() + quantity);
//            }
//        }
        for(ProductEntity pe : this.productList){
            if (product.getId() == pe.getId()){
                qty++;
            }
            else {
                qty = 0;
            }
        }
        if ((qty + quantity) <= product.getQuantity()){
            for (int i = 0; i < quantity; i++)
            {
                productList.add(product);
            }
                return true;
        }
        else {
            return false;
        }


    }
//    public void equals(ProductEntity product){
//        this.product.stream().forEach(element -> System.out.println(element));ope
//    }

    public boolean deleteProductInBasket(ProductEntity product) {
        return this.productList.remove(product);
    }

    public boolean deleteAllProductInBasket(ProductEntity product) {

        return this.productList.removeIf(p -> p.getId() == product.getId());
    }



    public boolean deleteAllProductInBasket(BasketEntity user_basket){
        boolean isOk = true;

        Map<Long, Long> allIds = new HashMap<Long, Long>();

        for (ProductEntity p : user_basket.productList){
            allIds.put(p.getId(), p.getQuantity());
        }

        for (Long id : allIds.keySet()){
            int prCounter = 0;
            for (ProductEntity p : user_basket.productList){
                if (p.getId() == id){
                    prCounter++;
                }
                if (prCounter > allIds.get(id)){
                    isOk= false;
                }
            }
        }

        if (isOk){
            user_basket.productList.clear();
            return true;
        }
        return false;
    }

}
