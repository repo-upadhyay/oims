package com.wms.core.business.payments.service;

import java.util.List;

import com.wms.core.business.generic.exception.ServiceException;
import com.wms.core.business.generic.service.SalesManagerEntityService;
import com.wms.core.business.order.model.Order;
import com.wms.core.business.payments.model.Transaction;


public interface TransactionService extends SalesManagerEntityService<Long, Transaction> {

	/**
	 * Obtain a previous transaction that has type authorize for a give order
	 * @param order
	 * @return
	 * @throws ServiceException
	 */
	Transaction getCapturableTransaction(Order order) throws ServiceException;

	Transaction getRefundableTransaction(Order order) throws ServiceException;

	List<Transaction> listTransactions(Order order) throws ServiceException;



}