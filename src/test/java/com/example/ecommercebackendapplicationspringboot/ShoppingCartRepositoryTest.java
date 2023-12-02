package com.example.ecommercebackendapplicationspringboot;

import com.example.ecommercebackendapplicationspringboot.entity.ShoppingCart;
import com.example.ecommercebackendapplicationspringboot.entity.User;
import com.example.ecommercebackendapplicationspringboot.repository.ShoppingCartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ShoppingCartRepositoryTest {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    private ShoppingCart createShoppingCart() {
        // Create a user
        User user = new User();
        user.setId(1L);

        // Create a shopping cart
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);

        return shoppingCart;
    }



    @Test
    public void testCreateShoppingCart() {
        // Given
        ShoppingCart shoppingCart = createShoppingCart();

        // When
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);

        // Then
        assertNotNull(savedShoppingCart);
        assertNotNull(savedShoppingCart.getId());
    }

    @Test
    public void testReadShoppingCart() {
        // Given
        ShoppingCart shoppingCart = createShoppingCart();
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);

        // When
        Optional<ShoppingCart> foundShoppingCart = shoppingCartRepository.findById(savedShoppingCart.getId());

        // Then
        assertTrue(foundShoppingCart.isPresent());
        assertEquals(savedShoppingCart.getId(), foundShoppingCart.get().getId());
        assertEquals(savedShoppingCart.getUser(), foundShoppingCart.get().getUser());
    }

    @Test
    public void testUpdateShoppingCart() {
        // Given
        ShoppingCart shoppingCart = createShoppingCart();
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);


        User newUser = new User();
        newUser.setId(2L); // assuming user with id 2 exists
        savedShoppingCart.setUser(newUser);

        // When
        ShoppingCart updatedShoppingCart = shoppingCartRepository.save(savedShoppingCart);

        // Then
        assertNotNull(updatedShoppingCart);
        assertEquals(newUser, updatedShoppingCart.getUser());
    }

    @Test
    public void testDeleteShoppingCart() {
        // Given
        ShoppingCart shoppingCart = createShoppingCart();
        ShoppingCart savedShoppingCart = shoppingCartRepository.save(shoppingCart);

        // When
        shoppingCartRepository.deleteById(savedShoppingCart.getId());

        // Then
        Optional<ShoppingCart> deletedShoppingCart = shoppingCartRepository.findById(savedShoppingCart.getId());
        assertFalse(deletedShoppingCart.isPresent());
    }
}
