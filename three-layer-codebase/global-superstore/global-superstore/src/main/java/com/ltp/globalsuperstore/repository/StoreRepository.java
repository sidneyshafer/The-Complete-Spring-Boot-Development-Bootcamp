package com.ltp.globalsuperstore.repository;

import java.util.ArrayList;
import java.util.List;

import com.ltp.globalsuperstore.Item;

public class StoreRepository {
  
  List<Item> items = new ArrayList<>();

  public Item getItem(int index) {
    return items.get(index);
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void updateItem(int index, Item item) {
    items.set(index, item);
  }
}
