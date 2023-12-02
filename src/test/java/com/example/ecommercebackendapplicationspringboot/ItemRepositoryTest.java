package com.example.ecommercebackendapplicationspringboot;

import com.example.ecommercebackendapplicationspringboot.entity.Item;
import com.example.ecommercebackendapplicationspringboot.entity.Product;
import com.example.ecommercebackendapplicationspringboot.entity.ShoppingCart;
import com.example.ecommercebackendapplicationspringboot.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    private Item createItem() {
        // Create a product
        Product product = new Product();
        product.setId(1L);

        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(1L);

        // Create an item
        Item item = new Item();
        item.setProduct(product);
        item.setShoppingCart(shoppingCart);
        item.setQuantity(5);

        return item;
    }

    @Test
    public void testCreateItem() {
        // Given
        Item item = createItem();

        // When
        Item savedItem = itemRepository.save(item);

        // Then
        assertNotNull(savedItem);
        assertNotNull(savedItem.getId());
    }
    @Test
    public void testReadItem() {
        // Given
        Item item = createItem();
        Item savedItem = itemRepository.save(item);

        // When
        Optional<Item> foundItem = itemRepository.findById(savedItem.getId());

        // Then
        assertTrue(foundItem.isPresent());
        assertEquals(savedItem.getId(), foundItem.get().getId());
        assertEquals(savedItem.getProduct(), foundItem.get().getProduct());
        assertEquals(savedItem.getShoppingCart(), foundItem.get().getShoppingCart());
        assertEquals(savedItem.getQuantity(), foundItem.get().getQuantity());
    }

    @Test
    public void testUpdateItem() {
        // Given
        Item item = createItem();
        Item savedItem = itemRepository.save(item);
        savedItem.setQuantity(10);

        // When
        Item updatedItem = itemRepository.save(savedItem);

        // Then
        assertNotNull(updatedItem);
        assertEquals(10, updatedItem.getQuantity());
    }

    @Test
    public void testDeleteItem() {
        // Given
        Item item = createItem();
        Item savedItem = itemRepository.save(item);

        // When
        itemRepository.deleteById(savedItem.getId());

        // Then
        Optional<Item> deletedItem = itemRepository.findById(savedItem.getId());
        assertFalse(deletedItem.isPresent());
    }
}
