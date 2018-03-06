package com.iphotowalking.samples.utils;

import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jianglz
 * @since 2018/3/2.
 */
public class DateConvert implements Converter {
    private static final Logger logger = LoggerFactory.getLogger(DateConvert.class);

    private final static String pattern = "yyyy-MM-dd HH:mm:ss";

    @Override
    public <T> T convert(Class<T> type, Object value) {
        if (value == null) {
            return (null);
        }

        Date dateObj = null;
        if (value instanceof String) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                dateObj = sdf.parse((String) value);
            } catch (ParseException pe) {
                logger.error("日期类型转换异常");
                return (null);
            }
        }

        return (T) dateObj;
    }
}
