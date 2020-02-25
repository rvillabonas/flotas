package flota.config;

/**
 * 
 * @author rvns
 *
 */

public class GenQuerys {

	public static final String PERFIL_PERSONA = " select per_dni from TGF_PERSONA\r\n"
			+ "	 WHERE usu_nickname = :nickname";

}
