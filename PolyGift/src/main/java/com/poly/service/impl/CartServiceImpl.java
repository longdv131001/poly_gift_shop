package com.poly.service.impl;

import com.poly.config.exception.AppException;
import com.poly.entity.Account;
import com.poly.entity.Cart;
import com.poly.entity.Product;
import com.poly.repository.AccountRepository;
import com.poly.repository.CartRepository;
import com.poly.repository.ProductRepository;
import com.poly.request.CartRequest;
import com.poly.response.CartResponse;
import com.poly.service.CartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    private final AccountRepository accountRepository;

    private final ProductRepository productRepository;

    private final ModelMapper mapper;

    @Override
    public List<CartResponse> getCartByUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            return cartRepository.findByUsername(username)
                    .stream()
                    .map(cart -> mapper.map(cart, CartResponse.class))
                    .collect(Collectors.toList());
        } else {
            throw new AppException("User not login", 401);
        }
    }

    @Override
    public CartResponse createCart(CartRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException("Product not found", 404));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Account account = accountRepository.findById(username)
                    .orElseThrow(() -> new AppException("Account not found", 404));
            Cart cart = cartRepository.save(Cart.builder()
                    .account(account)
                    .product(product)
                    .quantity(request.getQuantity())
                    .build());

            product.setQuantity(product.getQuantity() - request.getQuantity());
            productRepository.save(product);
            return mapper.map(cart, CartResponse.class);
        } else {
            throw new AppException("User not login", 401);
        }
    }

    @Override
    public CartResponse updateCart(int id, CartRequest request) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new AppException("Cart not found", 404));
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException("Product not found", 404));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Account account = accountRepository.findById(username)
                    .orElseThrow(() -> new AppException("Account not found", 404));

            cart.getProduct().setQuantity(product.getQuantity() + cart.getQuantity());
            cartRepository.save(cart);
            product.setQuantity(product.getQuantity() - cart.getQuantity());
            productRepository.save(product);
            Cart cartNew = cartRepository.save(Cart.builder()
                    .account(account)
                    .product(product)
                    .quantity(request.getQuantity())
                    .build());
            return mapper.map(cartNew, CartResponse.class);
        } else {
            throw new AppException("User not login", 401);
        }
    }

    @Override
    public void deleteCartByUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        cartRepository.deleteByUsername(username);
    }

    @Override
    public CartResponse findById(Integer id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new AppException("Cart not found", 404));
        return mapper.map(cart, CartResponse.class);
    }

    @Override
    public void deleteCartById(Integer id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new AppException("Cart not found", 404));
        Product product = productRepository.findById(cart.getProduct().getId())
                .orElseThrow(() -> new AppException("Product not found", 404));
        product.setQuantity(product.getQuantity() + cart.getQuantity());
        productRepository.save(product);
        cartRepository.delete(cart);
    }

    @Override
    public CartResponse findByProductId(Integer idProduct) {
        Product product = productRepository.findById(idProduct)
                .orElseThrow(() -> new AppException("Product not found", 404));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = auth.getName();
            Account account = accountRepository.findById(username)
                    .orElseThrow(() -> new AppException("Account not found", 404));
            Cart cart = cartRepository.findByProductId(product, account);
            return mapper.map(cart, CartResponse.class);
        } else {
            throw new AppException("User not login", 401);
        }

    }


}
