package com.marvel.app.utils;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.Mapper;

public class AppUtils {
	public static <T, U> ArrayList<U> map(final Mapper mapper, final List<T> source, final Class<U> destType) {
		final ArrayList<U> dest = new ArrayList<U>();
		for (T element : source) {
			if (element == null) {
				continue;
			}
			dest.add(mapper.map(element, destType));
		}
		return dest;
	}

	public static <T, U> U map(final Mapper mapper, final T source, final Class<U> destType) {
		return mapper.map(source, destType);
	}
}
