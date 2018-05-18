package com.amistrong.express.common;

import java.util.Collections;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

public class StringToEnumConverter implements GenericConverter {

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		return Collections.singleton(new ConvertiblePair(String.class,
				Enum.class));
	}

	@SuppressWarnings({})
	@Override
	public Object convert(Object source, TypeDescriptor sourceType,
			TypeDescriptor targetType) {
		Class<?> type = targetType.getType();
		Object[] enums = type.getEnumConstants();
		if (enums == null)
			throw new IllegalArgumentException(type.getSimpleName()
					+ " does not represent an enum type.");
		try {
			return enums[Integer.parseInt((String) source)];
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot convert " + source
					+ " to " + type.getSimpleName() + " by ordinal value.", e);
		}
	}
}
