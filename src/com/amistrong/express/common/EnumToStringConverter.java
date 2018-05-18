package com.amistrong.express.common;

import java.util.Collections;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class EnumToStringConverter implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(Enum.class,
				String.class));
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Object convert(Object source, TypeDescriptor sourceType,
			TypeDescriptor targetType) {
		return ((Enum) source).ordinal();
	}
}
