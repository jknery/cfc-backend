package br.com.carrefour.cfc.persistence.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Converter {

	private static ModelMapper mapper ;
	
	
	public static <S,T> T converter(S entidade, Class<T> tipoVO) {
		
        if (entidade == null) {
            return null;
        }
        mapper = new ModelMapper(); 
        return mapper.map(entidade, tipoVO);
    }
	
	public static <S,T> List<T> converterList(List<S> entidades, Class<T> tipoVO) {
        if (entidades.isEmpty()) {
            return null;
        }
        return entidades.stream().map(ent -> {return converter(ent, tipoVO);}).toList();
	}
		
}
