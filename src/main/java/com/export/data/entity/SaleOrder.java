package com.export.data.entity;

import java.util.List;

import lombok.Data;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Dec 11, 2020	
 *@version 1.0
 */
@Data
public class SaleOrder {
	private Long SALE_ORDER_NO;
	private Long SALE_ORDER_TYPE;
	private Long SOLD_TO;
	private Long SHIP_TO;
	private Long CUS_PO_NO;
	private Long SALES_ORG;
	private Long DIST_CHANNEL;
	private Long DIVISION;
	private Long SALES_OFFICE;
	private Long SALES_GROUP;
	private Long IO_NO;
	private Long COST_CENTER;
	private Long PROFIT_CENTER;
	private Long ORDER_REASON;
	private Long SO_COM_STATUS;
	private Long TAX_ID_NO;
	private Long DISCOUNT_PRICE_H;
	private Long SO_DO_STATUS;
	private List<SaleOrderDetail> ITEMS;
}
