package ar.edu.unlam.tallerweb1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import ar.edu.unlam.tallerweb1.modelo.Tarea;
/*

public class TareaDaoImpl implements TareaDao {
	
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Tarea> listarTareas() {
		String sql = "SELECT T.*,U.nombre FROM Tareas T INNER JOIN Usuarios U ON T.usuarioAlta = U.usuarioId WHERE privacidad=1";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Tarea> result = jdbcTemplate.query(sql, params, new TareaMapper());
		return result;
	}

}
*/