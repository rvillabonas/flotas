package flota.config;

/**
 * 
 * @author rvns
 *
 */

public class GenQuerys {

	public static final String ROL_DESCRIP = "select id_rol rol from TGF_ROL\r\n"
			+ "	WHERE rol_nombre = :rolname";

}
