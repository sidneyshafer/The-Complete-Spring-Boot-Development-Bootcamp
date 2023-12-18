package com.ltp.globalsuperstore.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.StoreRepository;

public class StoreService {
  
  StoreRepository storeRepository = new StoreRepository();

  public Item getItem(int index) {
    return storeRepository.getItem(index);
  }

  public List<Item> getItems() {
    return storeRepository.getItems();
  }

  public void addItem(Item item) {
    storeRepository.addItem(item);
  }

  public void updateItem(int index, Item item) {
    storeRepository.updateItem(index, item);
  }

  public Item getItemFromId(String id) {
    int index = getIndexFromId(id);
    return index == Constants.NOT_FOUND ? new Item() : getItem(index);
  }

  public int getIndexFromId(String id) {
    for (int i = 0; i < getItems().size(); i++) {
      if (getItems().get(i).getId().equals(id)) return i;
    }
    return Constants.NOT_FOUND;
  }

  public boolean within5Days(Date newDate, Date oldDate) {
    long diff = Math.abs(newDate.getTime() - oldDate.getTime());
    return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
  }

  public String handleSubmit(Item item) {
    int index = getIndexFromId(item.getId());
    String status = Constants.SUCCESS_STATUS;
    if (index == Constants.NOT_FOUND) {
      getItems().add(item);
    } else if (within5Days(item.getDate(), getItems().get(index).getDate())) {
      getItems().set(index, item);
    } else {
      status = Constants.FAILED_STATUS;
    }
    return status;
  }
}
