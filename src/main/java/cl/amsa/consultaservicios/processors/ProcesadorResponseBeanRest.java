package cl.amsa.consultaservicios.processors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import cl.amsa.consultaservicios.model.OutputParameters;
import cl.amsa.consultaservicios.model.RowSet;
import cl.amsa.consultaservicios.model.RowSet.Row;
import cl.amsa.consultaservicios.model.RowSet.Row.Column;

@Service
public class ProcesadorResponseBeanRest implements Processor {

	private static final Logger logger = Logger.getLogger(ProcesadorResponseBeanRest.class);
	public static final String NVARCHAR_TYPE = "nvarchar";
	public static final String VARCHAR_TYPE = "varchar";
	public static final String INT_TYPE = "int";
	
	private static final String NAME_ATTRIBUTE_NOMBRE_EQUIPO = "NombreEquipo";
	
	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {

		LinkedHashMap<Object, Object> bodyResponse = exchange.getIn().getBody(LinkedHashMap.class);

		Object response = bodyResponse.get("#result-set-1");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

		List<Object> listResponse = objectMapper.convertValue(response, List.class);

		OutputParameters output = new OutputParameters();
		List<RowSet> lista = output.getRowSet();
		RowSet rowSet = new RowSet();

		List<RowSet.Row> rowList = rowSet.getRow();
		Row row;
		List<RowSet.Row.Column> columnList;
		Map<String, Object> colMap;

		Column colIdServicio;
		Column colNombre;
		Column colDescripcion;
		Column colHoraInicio;
		Column colHoraFin;
		Column colIncompatibles;
		Column colNombreEquipo;
		
		if (!listResponse.isEmpty()) {
			for (Object o : listResponse) {
				row = new Row();
				columnList = row.getColumn();
				Map<String, Object> convertValue2 = objectMapper.convertValue(o, Map.class);
				colMap = convertValue2;
				colIdServicio = new Column();
				colIdServicio.setName("IdServicio");
				colIdServicio.setSqltype(INT_TYPE);
				colIdServicio.setValue(colMap.get("IdServicio").toString());

				colNombre = new Column();
				colNombre.setName("Nombre");
				colNombre.setSqltype(NVARCHAR_TYPE);
				colNombre.setValue(colMap.get("Nombre").toString());

				colDescripcion = new Column();
				colDescripcion.setName("Descripcion");
				colDescripcion.setSqltype(NVARCHAR_TYPE);
				colDescripcion.setValue(colMap.get("Descripcion").toString());

				colHoraInicio = new Column();
				colHoraInicio.setName("HoraInicio");
				colHoraInicio.setSqltype(VARCHAR_TYPE);
				colHoraInicio.setValue(colMap.get("HoraInicio").toString());

				colHoraFin = new Column();
				colHoraFin.setName("HoraFin");
				colHoraFin.setSqltype(VARCHAR_TYPE);
				colHoraFin.setValue(colMap.get("HoraFin").toString());

				colIncompatibles = new Column();
				colIncompatibles.setName("Incompatibles");
				colIncompatibles.setSqltype(VARCHAR_TYPE);
				colIncompatibles.setValue(colMap.get("Incompatibles").toString());

				colNombreEquipo = new Column();
				colNombreEquipo.setName(NAME_ATTRIBUTE_NOMBRE_EQUIPO);
				colNombreEquipo.setSqltype(NVARCHAR_TYPE);
				colNombreEquipo.setValue(colMap.get(NAME_ATTRIBUTE_NOMBRE_EQUIPO).toString());

				columnList.add(colIdServicio);
				columnList.add(colNombre);
				columnList.add(colDescripcion);
				columnList.add(colHoraInicio);
				columnList.add(colHoraFin);
				columnList.add(colIncompatibles);
				columnList.add(colNombreEquipo);
				rowList.add(row);

			}
		}

		lista.add(rowSet);

		exchange.getOut().setBody(output);
		exchange.getOut().removeHeader(NAME_ATTRIBUTE_NOMBRE_EQUIPO);
		exchange.getOut().removeHeader("IpEquipo");
		logger.info(output);

	}

}
