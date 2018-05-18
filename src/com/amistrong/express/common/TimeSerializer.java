package com.amistrong.express.common;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


public class TimeSerializer extends JsonSerializer<Timestamp>{

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	@Override
	public void serialize(Timestamp value, JsonGenerator jgen,SerializerProvider provider) throws IOException,JsonProcessingException {
		String formattedDate = simpleDateFormat.format(value);
		jgen.writeString(formattedDate);
	}
}
