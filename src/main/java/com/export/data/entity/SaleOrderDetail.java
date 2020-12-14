package com.export.data.entity;

import lombok.Data;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Dec 11; 2020	
 *@version 1.0
 */
@Data
public class SaleOrderDetail {
	private String LINE_ITEM;
	private Long MATERIAL_NO;
	private String MATERIAL_DESC;
	private String ITEM_CAT;
	private String SUB_CAM_ID;
	private Long QUANTITY;
	private Long PRICE_I;
	private String DISCOUNT_PRICE_I;
	private String MDR_PRICE_I;
	private String COMM_PRICE_I;
	private String PROMO_NAME;
	private String VOUC_START_DATE;
	private String VOUC_END_DATE;
}
