package com.wms.web.populator.order;

import java.util.Locale;

import org.apache.commons.lang.Validate;

import com.wms.core.business.catalog.product.service.PricingService;
import com.wms.core.business.generic.exception.ConversionException;
import com.wms.core.business.merchant.model.MerchantStore;
import com.wms.core.business.order.model.OrderTotal;
import com.wms.core.business.reference.language.model.Language;
import com.wms.core.utils.AbstractDataPopulator;
import com.wms.web.entity.order.ReadableOrderTotal;
import com.wms.web.utils.LabelUtils;
import com.wms.web.utils.LocaleUtils;

public class ReadableOrderTotalPopulator extends
		AbstractDataPopulator<OrderTotal, ReadableOrderTotal> {
	
	
	private PricingService pricingService;


	private LabelUtils messages;




	@Override
	public ReadableOrderTotal populate(OrderTotal source,
			ReadableOrderTotal target, MerchantStore store, Language language)
			throws ConversionException {
		
			Validate.notNull(pricingService,"PricingService must be set");
			Validate.notNull(messages,"LabelUtils must be set");
			
			Locale locale = LocaleUtils.getLocale(language);
		
			try {
				
				target.setCode(source.getOrderTotalCode());
				target.setId(source.getId());
				target.setModule(source.getModule());
				target.setOrder(source.getSortOrder());
				target.setTitle(messages.getMessage(source.getOrderTotalCode(), locale, source.getOrderTotalCode()));
				target.setValue(source.getValue());
				target.setTotal(pricingService.getDisplayAmount(source.getValue(), store));
				
			} catch(Exception e) {
				throw new ConversionException(e);
			}
			
			return target;
		
	}

	@Override
	protected ReadableOrderTotal createTarget() {
		return new ReadableOrderTotal();
	}
	
	public PricingService getPricingService() {
		return pricingService;
	}

	public void setPricingService(PricingService pricingService) {
		this.pricingService = pricingService;
	}
	
	public LabelUtils getMessages() {
		return messages;
	}

	public void setMessages(LabelUtils messages) {
		this.messages = messages;
	}

}
