package com.alerter.util;

import java.io.PrintWriter;
import java.util.List;

import com.alerter.entity.Product;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;

public class ProductDataToCSV {

	public static void write(PrintWriter writer, List<Product> product) {
		try {
			String[] columns = { "id", "name", "description", "bizArea", "bizOwner", "unitsAvailable", "url",
					"schedule", "upperLimit", "lowerLimit" };

			ColumnPositionMappingStrategy<Product> mapStrategy = new ColumnPositionMappingStrategy<Product>();
			mapStrategy.setType(Product.class);
			mapStrategy.generateHeader();
			mapStrategy.setColumnMapping(columns);

			StatefulBeanToCsv<Product> beanToCSV = new StatefulBeanToCsvBuilder<Product>(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.withMappingStrategy(mapStrategy)
					.withSeparator(',')
					.build();
			beanToCSV.write(product);
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}
}
