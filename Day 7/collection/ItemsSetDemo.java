package com.hsbc.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ItemsSetDemo {

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(new Item(1, "Laptop", 30000, 4.2));
		items.add(new Item(2, "Mouse", 40000, 4.1));
		items.add(new Item(3, "Keyboard", 20000, 4.3));
		items.add(new Item(4, "Graphic Card", 50000, 4.4));
		items.add(new Item(4, "Monitor", 50000, 4.8));
		items.add(new Item(6, "UPS", 50000, 5.0));

		System.out.println("Size: "+items.size());
		
		ItemsSetDemo demo=new ItemsSetDemo();
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemIdInAscendingOrder());
		System.out.println("-------------Sorting by Item Id in Ascending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemIdInDescendingdingOrder());
		System.out.println("-------------Sorting by Item Id in Descending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemNameInAsendingdingdingOrder());
		System.out.println("-------------Sorting by Item Name in Ascending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemNameInDescendingdingOrder());
		System.out.println("-------------Sorting by Item Id in Descending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemPriceInAscendingOrder());
		System.out.println("-------------Sorting by Item Price in Ascending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemPriceInDescendingdingOrder());
		System.out.println("-------------Sorting by Item Price in Descending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemRatingInAscendingOrder());
		System.out.println("-------------Sorting by Item Rating in Ascending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
		Collections.sort(items, demo.new SortByItemRatingInDescendingdingOrder());
		System.out.println("-------------Sorting by Item Rating in Descending Order----------");
		for(Item item : items) {
			System.out.println(item);
		}
	}
	
	class SortByItemIdInAscendingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o1.getItemId()-o2.getItemId();
	}
	

		
	}
	class SortByItemIdInDescendingdingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o2.getItemId()-o1.getItemId();
		}
		
	}
	class SortByItemNameInDescendingdingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o2.getName().compareTo(o1.getName());
		}
		
	}
	class SortByItemNameInAsendingdingdingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	class SortByItemPriceInAscendingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)(o1.getPrice()-o2.getPrice());
	}
	

		
	}
	class SortByItemPriceInDescendingdingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)(o2.getPrice()-o1.getPrice());
		}
		
	}
	class SortByItemRatingInAscendingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)(o1.getRatings()-o2.getRatings());
	}
	

		
	}
	class SortByItemRatingInDescendingdingOrder implements Comparator<Item>
	{

		@Override
		public int compare(Item o1, Item o2) {
			// TODO Auto-generated method stub
			return (int)(o2.getRatings()-o1.getRatings());
		}
		
	}

}
