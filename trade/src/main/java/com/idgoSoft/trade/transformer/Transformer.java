/**
 * 
 */
package com.idgoSoft.trade.transformer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.idgoSoft.trade.data.DataFeed;

/**
 * @author Lenono
 *
 */
public class Transformer {
	
	public List<DataFeed> dataFeedPreparation(ArrayList<LinkedHashMap<String,?>> listOfStockData){
		ArrayList<DataFeed> arrayListDataFeed = new ArrayList<DataFeed>();
		listOfStockData.stream().forEach(mappedData -> {
			final DataFeed dataFeed = new DataFeed();
			dataFeed.setClose(mappedData.get("close").toString()); 
			arrayListDataFeed.add(dataFeed);
			});
		System.out.println("hi");
		return arrayListDataFeed;
		
	}

}
