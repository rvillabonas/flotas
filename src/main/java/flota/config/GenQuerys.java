package flota.config;

/**
 * 
 * @author rvns
 *
 */

public class GenQuerys {

	public static final String PERFIL_PERSONA = "select id_rol rol from TGF_PERSONA\r\n"
			+ "	 WHERE usu_nickname = :nickname";

}
