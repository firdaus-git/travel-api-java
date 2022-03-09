package net.travel.common.util;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.AbstractConverter;
import org.modelmapper.AbstractProvider;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.convention.MatchingStrategies;


public class MapperUtil {
	
    private static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.createTypeMap (String.class, java.util.Date.class);

    }

    private MapperUtil() {
    }

    public static <D, T> D map(final T entity, Class<D> outClass) {
        modelMapper.addConverter (toStringDate);
        modelMapper.getTypeMap (String.class, java.util.Date.class).setProvider(javaDateProvider);
        return modelMapper.map(entity, outClass);
    }

    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        modelMapper.addConverter (toStringDate);
        modelMapper.getTypeMap (String.class, java.util.Date.class).setProvider(javaDateProvider);
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }

    public static <S, D> D map(final S source, D destination) {
        modelMapper.addConverter (toStringDate);
        modelMapper.getTypeMap (String.class, java.util.Date.class).setProvider(javaDateProvider);
        modelMapper.map(source, destination);
        return destination;
    }

    static Provider<Date> javaDateProvider = new AbstractProvider<Date>() {
        @Override
        public java.util.Date get() {
            return new java.util.Date();
        }
    };

    static Converter<String, Date> toStringDate = new AbstractConverter<String, Date>() {
        @Override
        protected java.util.Date convert (String source) {
            try {
                return DateUtil.toDateSTD(source);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    };
}
