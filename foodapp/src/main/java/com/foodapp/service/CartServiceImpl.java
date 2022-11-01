package com.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.entities.FoodCart;
import com.foodapp.entities.Item;
import com.foodapp.repo.ICartRepository;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	ICartRepository CRepo;
	
	@Override
	public FoodCart addItemToCart(FoodCart Cart,Item item)
	{
		FoodCart repoCart=CRepo.findById(Cart.getCartId()).get();
		List<Item> tempitems=repoCart.getItemList();
		tempitems.add(item);
		repoCart.setItemList(tempitems);
		CRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public FoodCart increaseQuantity(FoodCart Cart, Item item, int qnt) {
		// TODO Auto-generated method stub
		FoodCart repoCart=CRepo.findById(Cart.getCartId()).get();
		List<Item> tempitems=repoCart.getItemList();
		for(Item i:tempitems)
		{
			if(i.getItemId().equals(item.getItemId()))
			{
				int q=i.getQuantity();
				i.setQuantity(q+qnt);
				break;
				
			}
		}
		repoCart.setItemList(tempitems);
		CRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public FoodCart decreaseQuantity(FoodCart Cart, Item item, int qnt) {
		// TODO Auto-generated method stub
		FoodCart repoCart=CRepo.findById(Cart.getCartId()).get();
		List<Item>tempitems=repoCart.getItemList();
		for(Item i:tempitems)
		{
			if(i.getItemId().equals(item.getItemId()))
			{
				int q=i.getQuantity();
				i.setQuantity(Math.max((q-qnt),0));
				break;		
			}
		}
		repoCart.setItemList(tempitems);
		CRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public FoodCart deleteItem(FoodCart Cart, Item item) {
		// TODO Auto-generated method stub
		FoodCart repoCart=CRepo.findById(Cart.getCartId()).get();
		List<Item>tempitems=repoCart.getItemList();
		tempitems.remove(item);
		repoCart.setItemList(tempitems);
		CRepo.save(repoCart);
		return repoCart;
	}

	@Override
	public FoodCart clearCart(FoodCart Cart) {
		// TODO Auto-generated method stub
		FoodCart repoCart=CRepo.findById(Cart.getCartId()).get();
		List<Item>tempItems=repoCart.getItemList();
		tempItems.clear();
		repoCart.setItemList(tempItems);
		CRepo.save(repoCart);
		return repoCart;
	}

}
